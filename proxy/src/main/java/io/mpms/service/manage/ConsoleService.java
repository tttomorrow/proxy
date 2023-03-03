package io.mpms.service.manage;

import cn.hutool.core.date.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 控制台
 */
@Service
public class ConsoleService {
    @Resource
    private ProjectInfoService projectInfoService;

    /**
     * 执行shell命令
     *
     * @param consoleCommandOp 执行的操作
     * @param projectInfoModel 项目信息
     * @param copyItem         副本信息
     * @return 执行结果
     * @throws Exception 异常
     */
    public String execCommand(ConsoleCommandOp consoleCommandOp, ProjectInfoModel projectInfoModel, ProjectInfoModel.JavaCopyItem copyItem) throws Exception {
        String result;
        AbstractProjectCommander abstractProjectCommander = AbstractProjectCommander.getInstance();
        // 执行命令
        switch (consoleCommandOp) {
            case restart:
                result = abstractProjectCommander.restart(projectInfoModel, copyItem);
                break;
            case start:
                result = abstractProjectCommander.start(projectInfoModel, copyItem);
                break;
            case stop:
                result = abstractProjectCommander.stop(projectInfoModel, copyItem);
                break;
            case status: {
                String tag = copyItem == null ? projectInfoModel.getId() : copyItem.getTagId();
                result = abstractProjectCommander.status(tag);
                break;
            }
            case top:
            case showlog:
            default:
                throw new IllegalArgumentException(consoleCommandOp + " error");
        }
        //  通知日志刷新
        if (consoleCommandOp == ConsoleCommandOp.start || consoleCommandOp == ConsoleCommandOp.restart) {
            // 修改 run lib 使用情况
            ProjectInfoModel modify = projectInfoService.getItem(projectInfoModel.getId());
            //
            if (copyItem != null) {
                ProjectInfoModel.JavaCopyItem copyItem1 = modify.findCopyItem(copyItem.getId());
                copyItem1.setModifyTime(DateUtil.now());
            }
            modify.setRunLibDesc(projectInfoModel.getUseLibDesc());
            try {
                projectInfoService.updateItem(modify);
            } catch (Exception ignored) {
            }
        }
        return result;
    }
}
