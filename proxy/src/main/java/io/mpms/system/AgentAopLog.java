package io.mpms.system;

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

    @Pointcut("execution(public * io.jpom.controller..*.*(..))")
    public void AgentLog() {

    }

    @Before("AgentLog()")
    public void doBefore(JoinPoint joinPoint) {
        String ip = BaseAgentController.getAgentIp();
        NodeIp = ip;
    }

    @AfterReturning(returning = "ret", pointcut = "AgentLog()")
    public void doAfterReturning(Object ret) {
        if (ret == null) {
            return;
        }
    }
}

