package io.mpms.service.mysqldb;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.jpom.model.data.DelayedTask;

import java.util.List;

/**
 * (Delayedtask)表服务接口
 *
 *
 * @since 2021-10-21 14:34:09
 */
public interface DelayedTaskService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DelayedTask queryById(Integer id);

}