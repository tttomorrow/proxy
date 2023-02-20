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

    @OnOpen
    public void onOpen(Session session) {
        try {
            if (super.checkAuthorize(session)) {
                return;
            }
            String tomcatId = super.getParameters(session, "tomcatId");
            if (tomcatEditService == null) {
                tomcatEditService = SpringUtil.getBean(TomcatEditService.class);
            }
            TomcatInfoModel tomcatInfoModel = tomcatEditService.getItem(tomcatId);
            if (tomcatInfoModel == null && !JpomApplication.SYSTEM_ID.equalsIgnoreCase(tomcatId)) {
                SocketSessionUtil.send(session, "获取tomcat信息错误");
                session.close();
                return;
            }
            SocketSessionUtil.send(session, "连接成功：" + (tomcatInfoModel == null ? "" : tomcatInfoModel.getName()));
        } catch (Exception e) {
            DefaultSystemLog.getLog().error("socket 错误", e);
            try {
                SocketSessionUtil.send(session, JsonMessage.getString(500, "系统错误!"));
                session.close();
            } catch (IOException e1) {
                DefaultSystemLog.getLog().error(e1.getMessage(), e1);
            }
        }
    }

    @OnMessage
    public void onMessage(String message, Session session) throws Exception {
        JSONObject json = JSONObject.parseObject(message);
        String op = json.getString("op");
        ConsoleCommandOp consoleCommandOp = ConsoleCommandOp.valueOf(op);
        if (consoleCommandOp == ConsoleCommandOp.heart) {
            return;
        }
        String tomcatId = json.getString("tomcatId");
        if (JpomApplication.SYSTEM_ID.equalsIgnoreCase(tomcatId)) {
            runMsg(session, json);
        } else {
            TomcatInfoModel tomcatInfoModel = tomcatEditService.getItem(tomcatId);
            if (tomcatInfoModel == null) {
                SocketSessionUtil.send(session, "没有对应tomcat");
                session.close();
                return;
            }
            runMsg(session, tomcatInfoModel, json);
        }
    }
}
