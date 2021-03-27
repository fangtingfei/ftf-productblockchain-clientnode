package cn.ftf.productblockchain.clientnode.cache;

import cn.ftf.productblockchain.clientnode.util.RSAUtils;
import cn.ftf.productblockchain.clientnode.websocket.MyClient;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * AddressPool
 *
 * @Author 房廷飞
 * @Create 2020-12-12 20:32
 */
@Component
public class AddressPool {
    Logger logger= LoggerFactory.getLogger(getClass());
    public static HashSet<String> addressPoll = new HashSet<>();
    public AddressPool(){
    }

    @PostConstruct
    public void init() throws Exception {
        File addressPool = new File("addressPool.uri");
        if (!addressPool.exists() || addressPool.length() == 0 || !addressPool.exists() || addressPool.length() == 0) {
            addressPool.createNewFile();
        }
        List<String> addressFromFile = FileUtils.readLines(addressPool, "UTF-8");
        addressFromFile.stream().forEach(address->addURI(address));
    }

    public void addURI(String uri){
        if(addressPoll.contains(uri)){
            return;
        }
        addressPoll.add(uri);
        MyClient client = null;
        try {
            logger.info("[注册节点] URI=",uri);
            client = new MyClient(new URI(uri));
        } catch (URISyntaxException e) {
            logger.info("[注册节点失败] URI=",uri);
            e.printStackTrace();
        }
        client.connect();
    }
    public void removeURI(String uri){
        addressPoll.remove(uri);
    }
    public HashSet<String> getAddressPoll() {
        return addressPoll;
    }

    public void setAddressPoll(HashSet<String> addressPoll) {
        AddressPool.addressPoll = addressPoll;
    }
}
