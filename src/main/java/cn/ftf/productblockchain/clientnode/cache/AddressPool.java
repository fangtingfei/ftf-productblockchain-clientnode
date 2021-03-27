package cn.ftf.productblockchain.clientnode.cache;

import cn.ftf.productblockchain.clientnode.util.RSAUtils;
import cn.ftf.productblockchain.clientnode.websocket.MyClient;
import org.apache.commons.io.FileUtils;
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
    public static HashSet<String> addressPoll = new HashSet<>();

    public AddressPool(){
    }

    @PostConstruct
    public void init() throws Exception {
        File addressPool = new File("addressPool.url");
        if (!addressPool.exists() || addressPool.length() == 0 || !addressPool.exists() || addressPool.length() == 0) {
            addressPool.createNewFile();
        }
        List<String> addressFromFile = FileUtils.readLines(addressPool, "UTF-8");
        addressFromFile.stream().forEach(address->addURL(address));
    }

    public void addURL(String url){
        addressPoll.add(url);
        MyClient client = null;
        try {
            client = new MyClient(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        client.connect();
    }
    public void removeURL(String url){
        addressPoll.remove(url);
    }
    public HashSet<String> getAddressPoll() {
        return addressPoll;
    }

    public void setAddressPoll(HashSet<String> addressPoll) {
        AddressPool.addressPoll = addressPoll;
    }
}
