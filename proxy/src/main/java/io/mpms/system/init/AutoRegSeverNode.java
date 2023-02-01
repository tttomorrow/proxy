package io.mpms.system.init;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpStatus;
import cn.jiangzeyin.common.DefaultSystemLog;
import cn.jiangzeyin.common.JsonMessage;
import cn.jiangzeyin.common.PreLoadClass;
import cn.jiangzeyin.common.PreLoadMethod;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.jpom.common.ServerOpenApi;
import io.jpom.system.AgentAuthorize;
import io.jpom.system.AgentConfigBean;
import io.jpom.system.AgentExtConfigBean;
import io.jpom.system.ConfigBean;
import io.jpom.util.JsonFileUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

/**
 * 自动注册server 节点
 *
 * 
 
 */
@PreLoadClass
public class AutoRegSeverNode {


}
