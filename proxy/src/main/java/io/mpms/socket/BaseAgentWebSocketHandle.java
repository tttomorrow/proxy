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

    /**
     * 判断授权信息是否正确
     *
     * @param session session
     * @return true 需要结束回话
     */
    public boolean checkAuthorize(Session session) {
        String authorize = this.getParameters(session, ConfigBean.MPMS_AGENT_AUTHORIZE);
        boolean ok = AgentAuthorize.getInstance().checkAuthorize(authorize);
        if (!ok) {
            try {
                session.close(new CloseReason(CANNOT_ACCEPT, "授权信息错误"));
            } catch (Exception e) {
                DefaultSystemLog.getLog().error("socket 错误", e);
            }
            return true;
        }
        this.addUser(session, this.getParameters(session, "optUser"));
        return false;
    }
}
