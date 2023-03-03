package io.mpms.model.system;

import cn.hutool.core.util.StrUtil;
import cn.jiangzeyin.common.DefaultSystemLog;
import io.jpom.common.commander.AbstractProjectCommander;
import io.jpom.model.BaseJsonModel;

import java.io.IOException;

/**
 * 进程信息实体
 *
 
 
 */
public class ProcessModel extends BaseJsonModel {
    /**
     * 进程id
     */
    private int pid;
}
