package io.mpms.service.manage;

import cn.jiangzeyin.common.DefaultSystemLog;
import io.jpom.model.data.DelayedTask;
import io.jpom.model.data.SystemCommanderResult;
import io.jpom.service.mysqldb.DelayedTaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DelayedTaskRunner implements Runnable {

    @Resource
    private DelayedTaskService delayedtaskService;

    @Resource
    private MiniSysLogService miniSysLogService;

    private String nodeId;

    private String extra;

    private SystemCommanderResult performTask(DelayedTask task) {
        String action = task.getTaskAction();
        switch (action) {
            case "install": {
                extra = "安装软件包" + task.getTaskTarget();
                return AbstractSystemCommander.getInstance().installPackage(task.getTaskTarget().replace(" ", ""));
            }

            case "uninstall": {
                extra = "卸载软件包" + task.getTaskTarget();
                return AbstractSystemCommander.getInstance().uninstallPackage(task.getTaskTarget().replace(" ", ""));
            }

            case "update": {
                extra = "更新软件包" + task.getTaskTarget();
                return AbstractSystemCommander.getInstance().updatePackage(task.getTaskTarget().replace(" ", ""));
            }

            default:{
                // 删除本次循环的任务,可能为脏数据
                this.delayedtaskService.deleteById(task.getId());
            }
        }
        return null;
    }
}
