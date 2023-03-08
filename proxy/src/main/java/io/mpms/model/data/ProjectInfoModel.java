package io.mpms.model.data;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HtmlUtil;
import cn.jiangzeyin.common.DefaultSystemLog;
import cn.jiangzeyin.common.request.XssFilter;
import cn.jiangzeyin.common.spring.SpringUtil;
import io.jpom.common.commander.AbstractProjectCommander;
import io.jpom.model.BaseJsonModel;
import io.jpom.model.BaseModel;
import io.jpom.model.RunMode;
import io.jpom.service.WhitelistDirectoryService;
import io.jpom.system.LinuxRuntimeException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 项目配置信息实体
 *
 */
public class ProjectInfoModel extends BaseModel {
    /**
     * 分组
     */
    private String group;
    private String mainClass;
    private String lib;
    /**
     * 白名单目录
     */
    private String whitelistDirectory;
}
