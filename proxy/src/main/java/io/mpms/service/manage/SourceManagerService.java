package io.mpms.service.manage;

import cn.hutool.core.io.watch.WatchMonitor;
import cn.hutool.core.io.watch.Watcher;
import cn.hutool.core.io.watch.watchers.DelayWatcher;
import cn.hutool.system.SystemUtil;
import io.jpom.model.system.SourceConfig;
import io.jpom.service.mysqldb.MiniSysLogService;
import io.jpom.service.mysqldb.SourceConfigService;
import io.jpom.util.CommandUtil;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.nio.file.Path;
import java.nio.file.WatchEvent;

@Service
public class SourceManagerService implements Runnable {


    @Resource
    MiniSysLogService miniSysLogService;

    @Resource
    private SourceConfigService sourceconfigService;
    public static final String SourceFileName = "/etc/apt/sources.list";
    private final String osInfoFile = "/etc/issue";
    private long Cycle = 1;
    private String netCheckContent;

    public SourceManagerService() {

    }

    private String getOsVersion() {
        return FileOperator.getFileContent(osInfoFile);
    }

}
