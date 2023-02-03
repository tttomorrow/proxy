package io.mpms.socket;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.jiangzeyin.common.DefaultSystemLog;
import io.jpom.system.AgentAuthorize;
import io.jpom.system.ConfigBean;
import io.jpom.util.SocketSessionUtil;

import javax.websocket.CloseReason;
import javax.websocket.Session;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static javax.websocket.CloseReason.CloseCodes.CANNOT_ACCEPT;

/**
 * 插件端socket 基类
 *
 */
public abstract class BaseAgentWebSocketHandle {
    private static final ConcurrentHashMap<String, String> USER = new ConcurrentHashMap<>();


    protected String getParameters(Session session, String name) {
        Map<String, List<String>> pathParameters = session.getRequestParameterMap();
        List<String> strings = pathParameters.get(name);
        return CollUtil.join(strings, StrUtil.COMMA);
    }
}
