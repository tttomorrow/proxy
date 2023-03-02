package io.mpms.service.mysqldb;

import io.jpom.model.system.SourceConfig;

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
     * @param id 主键
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

}