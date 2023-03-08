package io.mpms.model.data;

import io.jpom.model.BaseModel;

/**
 * jdk 信息
 *
 *
 */
public class JdkInfoModel extends BaseModel {

    /**
     * jdk 路径
     */
    private String path;

    /**
     * jdk 版本
     */
    private String version;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
