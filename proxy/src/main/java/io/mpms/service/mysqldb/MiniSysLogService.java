package io.mpms.service.mysqldb;

import cn.hutool.core.date.DateTime;

import java.util.List;

/**
 * 凝思系统软件安装管理平台系统日志表(Minisyslog)表服务接口
 *
 * 
 * @since 2021-10-22 09:53:54
 */
public interface MiniSysLogService {

    /**
     * 通过ID查询单条数据
     */
    MiniSysLog queryById(Integer id);

    /**
     * 查询多条数据
     */
    List<MiniSysLog> queryAllByLimit(int offset, int limit);

    /**
     * 查询所有日志数据
     */
    List<MiniSysLog> queryAll();

    /**
     * 新增数据
     *
     * @return 影响行数
     */
    Integer insert(int level, String content, String extra);

    /**
     * 新增数据
     *
     * @return 影响行数
     */
    Integer insertMultiple(List<MiniSysLog> insertList);

    /**
     * 修改数据
     */
    MiniSysLog update(int id, int type, String ip, int level, DateTime time, String content, String extra);

}
