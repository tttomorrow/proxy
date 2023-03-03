package io.mpms.service.manage;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import io.jpom.model.data.ProjectInfoModel;
import io.jpom.model.data.ProjectRecoverModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.HashSet;
import java.util.List;

/**
 * 项目管理
 *
 */
@Service
public class ProjectInfoService extends BaseOperService<ProjectInfoModel> {
    @Resource
    private ProjectRecoverService projectRecoverService;

    public ProjectInfoService() {
        super(AgentConfigBean.PROJECT);
    }

    public HashSet<String> getAllGroup() {
        //获取所有分组
        List<ProjectInfoModel> projectInfoModels = list();
        HashSet<String> hashSet = new HashSet<>();
        if (projectInfoModels == null) {
            return hashSet;
        }
        for (ProjectInfoModel projectInfoModel : projectInfoModels) {
            hashSet.add(projectInfoModel.getGroup());
        }
        return hashSet;
    }

    /**
     * 修改项目信息
     *
     * @param projectInfo 项目信息
     */
    @Override
    public void updateItem(ProjectInfoModel projectInfo) {
        projectInfo.setModifyTime(DateUtil.now());
        String userName = BaseAgentController.getNowUserName();
        if (!StrUtil.DASHED.equals(userName)) {
            projectInfo.setModifyUser(userName);
        }
        super.updateItem(projectInfo);
    }
}
