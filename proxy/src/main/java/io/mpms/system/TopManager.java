package io.mpms.system;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * top命令管理，保证整个服务器只获取一个top命令
 */
@Slf4j
@Component
public class TopManager {

    private static TopManager topManager;

    private static String nodeId;

    private static Long cycle = 60L;

    private Thread getTopRunner = null;

    private boolean isMonitor = true;

    List<Monitorinfo> monitorinfoList = new ArrayList<>();

    Logger logger = LoggerFactory.getLogger(TopManager.class);



    @Resource
    MonitorinfoService monitorinfoService;

    public static TopManager getInstance() {
        if (topManager == null) {
            topManager = SpringUtil.getBean(TopManager.class);
        }
        return topManager;
    }


    @PostConstruct
    public void startTopMonitor(){
        if (null == getTopRunner || getTopRunner.getState().equals(Thread.State.TERMINATED)){

            getTopRunner = new Thread(() -> {
                // 每次线程启动的时候，插入数据为0的数据
                get(nodeId,true);
                while (true){
                    try {
                        Long sleepCycle = cycle;
                        if (sleepCycle == 0){
                            sleepCycle = 60L;
                            isMonitor = false;
                        }else {
                            isMonitor = true;
                        }
                        Thread.sleep(sleepCycle *1000);
                        get(nodeId,false);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });

        }
        if (getTopRunner.getState().equals(Thread.State.NEW)) {
            getTopRunner.start();
            logger.info("******************* Start get Top Info ********************* Thread status is " + getTopRunner.getState());
        }
    }

    @PreDestroy
    public void stopTopMonitor(){
        if (!getTopRunner.getState().equals(Thread.State.TERMINATED)) {
            getTopRunner.interrupt();
        }
        getTopRunner = null;
    }

    public void updateHistoryInfo(){
        if (!monitorinfoList.isEmpty()){
            for (Monitorinfo item : monitorinfoList){
                item.setNodeId(nodeId);
            }
            monitorinfoService.insertBatch(monitorinfoList);
            resetMonitorList();
        }
    }

    public JSONObject get(String nodeId,Boolean isStart) {
        JSONObject topInfo = new JSONObject();
        // isStart 为true 代表第一次调用
        if (isMonitor&&!isStart) {
            topInfo = AbstractSystemCommander.getInstance().getAllMonitor();
        }else {
            topInfo.put("disk","0");
            topInfo.put("memory","0");
            topInfo.put("cpu", "0");
        }
        DateTime date = DateUtil.date();
        long monitorTime = date.getTime();
        topInfo.put("monitorTime", monitorTime);
        Monitorinfo monitorinfo = new Monitorinfo(nodeId, monitorTime, topInfo.getString("disk"), topInfo.getString("memory"), topInfo.getString("cpu"));
        if ((nodeId == null || nodeId.isEmpty())){
            monitorinfoList.add(monitorinfo);
        }else {
            if (!monitorinfoList.isEmpty()){
                for (Monitorinfo item : monitorinfoList){
                    item.setNodeId(nodeId);
                }
                // 批量新增监控数据
                monitorinfoService.insertBatch(monitorinfoList);
                resetMonitorList();
            }
            monitorinfoService.insert(monitorinfo);
        }

        return topInfo;
    }


    public void resetMonitorList(){
        //todo 置空，方便GC回收?，待研究
        monitorinfoList = null;
        monitorinfoList = new ArrayList<>();
    }

    public static long getCycle() {
        return cycle;
    }

    public static void setCycle(long cycle) {
        TopManager.cycle = cycle;
    }


    public static String getNodeId() {
        return nodeId;
    }

    public static void setNodeId(String nodeId) {
        TopManager.nodeId = nodeId;
    }

    public boolean isMonitor() {
        return isMonitor;
    }

    public void setMonitor(boolean monitor) {
        isMonitor = monitor;
    }
}
