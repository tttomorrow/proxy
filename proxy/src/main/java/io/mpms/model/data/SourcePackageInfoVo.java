package io.mpms.model.data;
import lombok.Data;

import java.io.Serializable;

@Data
public class SourcePackageInfoVo implements Serializable{
    /**
     * 包名
     */
    private String Package;

    /**
     * 版本
     */
    private String Version;

    /**
     * 架构
     */
    private String Architecture;
}
