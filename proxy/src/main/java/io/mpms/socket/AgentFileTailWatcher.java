package io.mpms.socket;

import cn.hutool.core.io.FileUtil;
import cn.jiangzeyin.common.DefaultSystemLog;
import io.jpom.util.BaseFileTailWatcher;

import javax.websocket.Session;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 文件跟随器
 *
 */
public class AgentFileTailWatcher<T> extends BaseFileTailWatcher<T> {
    private static final ConcurrentHashMap<File, AgentFileTailWatcher<Session>> CONCURRENT_HASH_MAP = new ConcurrentHashMap<>();

    private AgentFileTailWatcher(File logFile) throws IOException {
        super(logFile);
    }

    public static int getOneLineCount() {
        return CONCURRENT_HASH_MAP.size();
    }
}
