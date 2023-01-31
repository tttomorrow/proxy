package io.mpms;

import cn.jiangzeyin.common.EnableCommonBoot;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * jpom 启动类
 *
 */
@SpringBootApplication
@ServletComponentScan
@EnableCommonBoot
//开启定时任务(也可以放在启动类上)
@EnableScheduling
public class JpomAgentApplication {

    /**
     * 启动执行
     *
     * @param args 参数
     * @throws Exception 异常
     */
    public static void main(String[] args) throws Exception {
        JpomApplication jpomApplication = new JpomApplication(Type.Agent, JpomAgentApplication.class, args);
        jpomApplication
                // 拦截器
                .addInterceptor(AuthorizeInterceptor.class)
                .run(args);
    }

}
