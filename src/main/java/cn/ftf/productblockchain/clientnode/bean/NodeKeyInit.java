package cn.ftf.productblockchain.clientnode.bean;

import cn.ftf.productblockchain.clientnode.util.RSAUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * NodeKey
 *
 * @Author 房廷飞
 * @Create 2021-03-19 22:38
 */
@Component
public class NodeKeyInit {
    // 公钥
    public PublicKey publicKey;
    // 私钥
    public PrivateKey privateKey;

    @PostConstruct
    public void init(){
        File pubFile = new File("key.pub");
        File priFile = new File("key.pri");
        // 如果文件不存在,说明没有公私钥,就创建公私钥文件
        if (!pubFile.exists() || pubFile.length() == 0 || !priFile.exists() || priFile.length() == 0) {
            RSAUtils.generateKeys("RSA","key.pri","key.pub");
        }
        // 从文件中读取公私钥
        publicKey = RSAUtils.getPublicKeyFromFile("RSA","key.pub");
        privateKey = RSAUtils.getPrivateKeyFile("RSA","key.pri");
        String publicKeyEncode = Base64.encodeBase64String(publicKey.getEncoded());
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }
}
