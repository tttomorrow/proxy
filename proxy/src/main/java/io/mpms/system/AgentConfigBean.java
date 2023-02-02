package io.mpms.system;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.jiangzeyin.common.spring.SpringUtil;
import io.jpom.common.BaseAgentController;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * 插件端配置
 *


 */
@Configuration
public class AgentConfigBean {
    /**
     * 白名单文件
     */
    public static final String WHITELIST_DIRECTORY = "whitelistDirectory.json";
    /**
     * 项目数据文件
     */
    public static final String PROJECT = "project.json";

    public static final String TOMCAT = "tomcat.json";
    /**
     * 项目回收文件
     */
    public static final String PROJECT_RECOVER = "project_recover.json";
    /**
     * 证书文件
     */
    public static final String CERT = "cert.json";
    /**
     * 脚本管理数据文件
     */
    public static final String SCRIPT = "script.json";
    /**
     * 脚本模板存放路径
     */
    public static final String SCRIPT_DIRECTORY = "script";

    /**
     * Server 端的信息
     */
    public static final String SERVER_ID = "SERVER.json";

    /**
     * nginx配置信息
     */
    public static final String NGINX_CONF = "nginx_conf.json";

    /**
     * jdk列表信息
     */
    public static final String JDK_CONF = "jdk_conf.json";

    private static AgentConfigBean agentConfigBean;
}
