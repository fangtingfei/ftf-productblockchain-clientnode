package cn.ftf.productblockchain.clientnode.cache;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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
        addressPoll.add("ws://127.0.0.1:7000");
        addressPoll.add("ws://127.0.0.1:7001");
        addressPoll.add("ws://127.0.0.1:7002");
    }
}
