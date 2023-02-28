package io.mpms.service.manage;

import cn.hutool.core.date.DateUtil;
import io.jpom.common.BaseOperService;
import io.jpom.model.data.ProjectRecoverModel;
import io.jpom.system.AgentConfigBean;
import org.springframework.stereotype.Service;

/**
 * 项目管理
 *
 */
@Service
public class ProjectRecoverService extends BaseOperService<ProjectRecoverModel> {

    public ProjectRecoverService() {
        super(AgentConfigBean.PROJECT_RECOVER);
    }
}
