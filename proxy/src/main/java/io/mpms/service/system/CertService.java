package io.mpms.service.system;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import io.jpom.common.BaseOperService;
import io.jpom.model.data.CertModel;
import io.jpom.system.AgentConfigBean;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * 
 */
@Service
public class CertService extends BaseOperService<CertModel> {

    public CertService() {
        super(AgentConfigBean.CERT);
    }
}
