package io.mpms.socket;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.io.FileUtil;
import cn.jiangzeyin.common.DefaultSystemLog;
import cn.jiangzeyin.common.JsonMessage;
import cn.jiangzeyin.common.spring.SpringUtil;
import com.alibaba.fastjson.JSONObject;
import io.jpom.JpomApplication;
import io.jpom.model.data.TomcatInfoModel;
import io.jpom.service.manage.TomcatEditService;
import io.jpom.system.WebAopLog;
import io.jpom.util.SocketSessionUtil;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 插件端,控制台socket
 *
 */
@ServerEndpoint(value = "/tomcat_log")
@Component
public class AgentWebSocketTomcatHandle extends BaseAgentWebSocketHandle {

    private TomcatEditService tomcatEditService;

    private static final Map<String, File> CACHE_FILE = new ConcurrentHashMap<>();
}
