/*
 *耗时任务队列实体类
 *
 * 
 
 */

package io.mpms.model;

import io.jpom.model.data.DelayedTaskModel;

import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

public class TaskQueueModel {


    private static volatile TaskQueueModel taskQueueInstance;

    private TaskQueueModel() {

    }
}
