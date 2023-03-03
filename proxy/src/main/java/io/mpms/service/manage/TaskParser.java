package io.mpms.service.manage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.jpom.model.TaskQueueModel;
import io.jpom.model.data.DelayedTask;

import java.util.ArrayList;
import java.util.List;

public class TaskParser {
    private static volatile TaskParser taskParserInstance;

    private static final TaskQueueModel taskQueue = TaskQueueModel.getInstance();

    public TaskParser() {

    }

    public JSONObject taskModelToJsonobject(DelayedTask delayedTask) {
        JSONObject taskJsonObj = new JSONObject();

        taskJsonObj.put("id", delayedTask.getId());
        taskJsonObj.put("nodeId", delayedTask.getTaskNodeId());
        taskJsonObj.put("taskStatus", delayedTask.getTaskStatus());
        taskJsonObj.put("taskPriority", delayedTask.getTaskPriority());
        taskJsonObj.put("taskGroupId", delayedTask.getTaskGroupId());
        taskJsonObj.put("taskAction", delayedTask.getTaskAction());
        taskJsonObj.put("taskTarget", delayedTask.getTaskTarget());
        taskJsonObj.put("taskContent", delayedTask.getTaskContent());
        taskJsonObj.put("taskViewTimes", delayedTask.getTaskViewTimes());
        taskJsonObj.put("taskExtra", delayedTask.getTaskExtra());

        return taskJsonObj;
    }
}
