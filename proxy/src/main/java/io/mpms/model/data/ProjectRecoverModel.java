package io.mpms.model.data;

import cn.hutool.core.lang.ObjectId;
import io.jpom.model.BaseModel;

/**
 * 项目回收记录实体
 *

 */
public class ProjectRecoverModel extends BaseModel {
    /**
     * 删除人
     */
    private String delUser;
    /**
     * 删除时间
     */
    private String delTime;
    /**
     * 删除的对应项目信息
     */
    private ProjectInfoModel projectInfoModel;
}
