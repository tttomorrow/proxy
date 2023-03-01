package io.mpms.service.manage;

import cn.hutool.core.date.DateUtil;
import io.jpom.common.commander.AbstractProjectCommander;
import io.jpom.model.data.ProjectInfoModel;
import io.jpom.socket.ConsoleCommandOp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 控制台
 */
@Service
public class ConsoleService {
    @Resource
    private ProjectInfoService projectInfoService;
}
