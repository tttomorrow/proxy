package io.mpms.service.manage;

import cn.jiangzeyin.common.DefaultSystemLog;
import io.jpom.common.commander.AbstractSystemCommander;
import io.jpom.model.data.DelayedTask;
import io.jpom.model.data.SystemCommanderResult;
import io.jpom.service.mysqldb.DelayedTaskService;
import io.jpom.service.mysqldb.MiniSysLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DelayedTaskRunner implements Runnable {

    @Resource
    private DelayedTaskService delayedtaskService;
}
