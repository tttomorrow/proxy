package io.mpms.service.manage;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import io.jpom.common.BaseOperService;
import io.jpom.model.data.TomcatInfoModel;
import io.jpom.system.AgentConfigBean;
import org.springframework.stereotype.Service;

@Service
public class TomcatEditService extends BaseOperService<TomcatInfoModel> {

    public TomcatEditService() {
        super(AgentConfigBean.TOMCAT);
    }

    /**
     * 根据tomcat名称查询tomcat信息
     *
     * @param name tomcat的名称
     * @return tomcat信息
     */
    public TomcatInfoModel getItemByName(String name) {
        JSONObject allTomcat = getJSONObject(AgentConfigBean.TOMCAT);

        if (allTomcat == null) {
            return null;
        }

        JSONObject tomcat = null;
        for (String key : allTomcat.keySet()) {
            JSONObject object = allTomcat.getJSONObject(key);
            if (name.equals(object.getString("name"))) {
                tomcat = object;
                break;
            }
        }

        return JSONObject.toJavaObject(tomcat, TomcatInfoModel.class);
    }

}
