package io.mpms.system;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.jiangzeyin.common.spring.SpringUtil;
import com.alibaba.fastjson.JSONObject;
import io.jpom.model.system.AgentAutoUser;
import io.jpom.util.JsonFileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * proxy端授权账号信息
 *
 

 */
@Configuration
public class AgentAuthorize {

    private static AgentAuthorize agentAuthorize;
    /**
     * 账号
     */
    @Value("${" + ConfigBean.AUTHORIZE_USER_KEY + "}")
    private String agentName;
    /**
     * 密码
     */
    @Value("${" + ConfigBean.AUTHORIZE_PWD_KEY + ":}")
    private String agentPwd;
    /**
     * 授权加密字符串
     */
    private String authorize;


    /**
     * 单例
     *
     * @return this
     */
    public static AgentAuthorize getInstance() {
        if (agentAuthorize == null) {
            agentAuthorize = SpringUtil.getBean(AgentAuthorize.class);
            // 登录名不能为空
            if (StrUtil.isEmpty(agentAuthorize.agentName)) {
                throw new LinuxRuntimeException("proxy端登录名不能为空");
            }
            agentAuthorize.checkPwd();
            // 生成密码授权字符串
            agentAuthorize.authorize = SecureUtil.sha1(agentAuthorize.agentName + "@" + agentAuthorize.agentPwd);
        }
        return agentAuthorize;
    }

    public String getAgentName() {
        return agentName;
    }

    public String getAgentPwd() {
        return agentPwd;
    }
}
