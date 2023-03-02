package io.mpms.service.mysqldb.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.jpom.dao.DelayedTaskDao;
import io.jpom.model.data.DelayedTask;
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
}