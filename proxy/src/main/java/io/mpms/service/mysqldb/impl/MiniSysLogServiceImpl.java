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

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MiniSysLog queryById(Integer id) {
        return this.minisyslogDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<MiniSysLog> queryAllByLimit(int offset, int limit) {
        return this.minisyslogDao.queryAllByLimit(offset, limit);
    }
}
