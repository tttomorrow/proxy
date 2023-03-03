package io.mpms.service.manage;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import io.jpom.common.BaseAgentController;
import io.jpom.common.BaseOperService;
import io.jpom.model.data.ProjectInfoModel;
import io.jpom.model.data.ProjectRecoverModel;
import io.jpom.system.AgentConfigBean;
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
}
