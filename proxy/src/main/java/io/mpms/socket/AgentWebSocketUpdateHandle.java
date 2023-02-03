package io.mpms.socket;

import cn.jiangzeyin.common.DefaultSystemLog;
import com.alibaba.fastjson.JSONObject;
import io.jpom.JpomApplication;
import io.jpom.common.JpomManifest;
import io.jpom.model.AgentFileModel;
import io.jpom.model.WebSocketMessageModel;
import io.jpom.model.data.UploadFileModel;
import io.jpom.system.AgentConfigBean;
import io.jpom.util.SocketSessionUtil;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;

/**
 * 在线升级
 *
 *
 */
@ServerEndpoint(value = "/node_update")
@Component
public class AgentWebSocketUpdateHandle extends BaseAgentWebSocketHandle {

    private static final Map<String, UploadFileModel> UPLOAD_FILE_INFO = new HashMap<>();

    @OnOpen
    public void onOpen(Session session) {
        if (super.checkAuthorize(session)) {
            return;
        }
        session.setMaxBinaryMessageBufferSize(1024 * 1024);

    }
}
