package cn.ftf.productblockchain.clientnode.cache;

import cn.ftf.productblockchain.clientnode.websocket.MyClient;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;

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
    public void init(){
        //初始化客户端
//        addressPoll.add("ws://127.0.0.1:7000");
//        addressPoll.add("ws://127.0.0.1:7001");
//        addressPoll.add("ws://127.0.0.1:7002");
    }

    public void addURL(String url) throws URISyntaxException {
        addressPoll.add(url);
        MyClient client = new MyClient(new URI(url));
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
