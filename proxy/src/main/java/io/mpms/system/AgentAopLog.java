package io.mpms.system;

import io.jpom.common.BaseAgentController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * 自动记录日志
 *
 */
@Aspect
@Component
public class AgentAopLog {
    String NodeIp = null;
}

