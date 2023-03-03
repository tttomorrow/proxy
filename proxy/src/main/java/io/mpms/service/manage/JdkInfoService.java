package io.mpms.service.manage;

import org.springframework.stereotype.Service;

/**
 * jdk 管理
 *
 *
 */
@Service
public class JdkInfoService extends BaseOperService<JdkInfoModel> {

    public JdkInfoService() {
        super(AgentConfigBean.JDK_CONF);
    }


}
