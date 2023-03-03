package io.mpms.service.mysqldb.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.jpom.dao.DelayedTaskDao;
import io.jpom.service.manage.TaskParser;
import io.jpom.service.mysqldb.DelayedTaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DelayedTask)表服务实现类
 *
 * 
 * @since 2021-10-21 14:34:09
 */
@Service("delayedTaskService")
public class DelayedTaskServiceImpl implements DelayedTaskService {

    @Resource
    private DelayedTaskDao delayedTaskDao;

    private final TaskParser taskParser = new TaskParser();

    private String nodeId;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DelayedTask queryById(Integer id) {
        return this.delayedTaskDao.queryById(this.nodeId, id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<DelayedTask> queryAllByLimit(int offset, int limit) {
        return this.delayedTaskDao.queryAllByLimit(this.nodeId, offset, limit);
    }
}