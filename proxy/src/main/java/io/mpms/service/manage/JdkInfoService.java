package io.mpms.service.manage;

import io.jpom.model.data.JdkInfoModel;
import io.jpom.system.AgentConfigBean;
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

    /**
     * 删除项目
     *
     * @param id 项目
     */
    @Override
    public void deleteItem(String id) {
        ProjectInfoModel projectInfo = getItem(id);
        String userId = BaseAgentController.getNowUserName();
        super.deleteItem(id);
        // 添加回收记录
        ProjectRecoverModel projectRecoverModel = new ProjectRecoverModel(projectInfo);
        projectRecoverModel.setDelUser(userId);
        projectRecoverService.addItem(projectRecoverModel);
    }

}
