package io.mpms.service;

import cn.jiangzeyin.common.DefaultSystemLog;
import com.alibaba.fastjson.JSONObject;
import io.jpom.common.BaseDataService;
import io.jpom.model.data.AgentWhitelist;
import io.jpom.system.AgentConfigBean;
import io.jpom.util.JsonFileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 白名单服务
 */
@Service
public class WhitelistDirectoryService extends BaseDataService {

    /**
     * 获取白名单信息配置、如何没有配置或者配置错误将返回新对象
     *
     * @return AgentWhitelist
     */
    public AgentWhitelist getWhitelist() {
        try {
            JSONObject jsonObject = getJSONObject(AgentConfigBean.WHITELIST_DIRECTORY);
            if (jsonObject == null) {
                return new AgentWhitelist();
            }
            return jsonObject.toJavaObject(AgentWhitelist.class);
        } catch (Exception e) {
            DefaultSystemLog.getLog().error(e.getMessage(), e);
        }
        return new AgentWhitelist();
    }


    /**
     * 单项添加白名单
     *
     * @param item 白名单
     */
    public void addProjectWhiteList(String item) {
        AgentWhitelist agentWhitelist = getWhitelist();
        List<String> project = agentWhitelist.getProject();
        if (project == null) {
            project = new ArrayList<>();
        }
        project.add(item);
        saveWhitelistDirectory(agentWhitelist);
    }
}
