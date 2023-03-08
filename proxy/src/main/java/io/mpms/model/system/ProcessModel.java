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
    /**
     * 进程名
     */
    private String command;
    /**
     * 运行状态
     */
    private String status;
    /**
     * 进程仍然在使用的，没被交换出物理内存部分的大小
     */
    private String res;
    /**
     * 所有者
     */
    private String user;
}
