package io.mpms.service.mysqldb.impl;

import cn.hutool.core.date.DateTime;
import io.jpom.dao.MiniSysLogDao;
import io.jpom.model.data.MiniSysLog;
import io.jpom.service.mysqldb.MiniSysLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

/**
 * 凝思系统软件安装管理平台系统日志表(Minisyslog)表服务实现类
 *
 * 
 * @since 2021-10-22 09:53:54
 */
@Service("miniSysLogService")
public class MiniSysLogServiceImpl implements MiniSysLogService {

    @Resource
    private MiniSysLogDao minisyslogDao;
}
