package io.mpms.model.data;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.ZipUtil;
import io.jpom.model.BaseModel;
import io.jpom.system.LinuxRuntimeException;

import java.io.File;
import java.io.InputStream;

/**
 * tomcat 对象实体
 *
 *
 */
public class TomcatInfoModel extends BaseModel {

    private String path;
    private int port;
    private int status;
    private String appBase;
}
