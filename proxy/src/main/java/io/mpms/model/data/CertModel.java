package io.mpms.model.data;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.KeyUtil;
import cn.hutool.crypto.PemUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.jiangzeyin.common.DefaultSystemLog;
import cn.jiangzeyin.common.spring.SpringUtil;
import com.alibaba.fastjson.JSONObject;
import io.jpom.model.BaseModel;
import io.jpom.service.system.CertService;
import io.jpom.system.LinuxRuntimeException;

import java.io.InputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Date;

/**
 * 证书实体
 *
 *
 */
public class CertModel extends BaseModel {

    private static final String KEY = "Jpom 管理系统";
}
