package io.mpms.service.mysqldb;


import io.mpms.model.system.SourceConfig;

import java.util.List;

/**
 * (Sourceconfig)表服务接口
 *
 *
 * @since 2021-10-25 17:05:11
 */
public interface SourceConfigService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SourceConfig queryById(Integer id);

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    List<SourceConfig> selectAll();

    /**
     * 通过ID查询单条数据
     *
     * @param sourceconfig 源信息对象实例
     * @return 找到为true,反之为false
     */
    boolean isFoundByEntity(SourceConfig sourceconfig);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SourceConfig> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sourceconfig 实例对象
     * @return 实例对象
     */
    SourceConfig insert(SourceConfig sourceconfig);

    /**
     * 修改数据
     *
     * @param sourceconfig 实例对象
     * @return 实例对象
     */
    SourceConfig update(SourceConfig sourceconfig);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}