package cn.ftf.productblockchain.clientnode.bean;

import cn.ftf.productblockchain.clientnode.Application;
import cn.ftf.productblockchain.clientnode.websocket.MyServer;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.HashSet;
/**
 * WebSocketInit
 *
 * @Author 房廷飞
 * @Create 2021-03-19 23:35
 */
@Component
public class WebSocketInit {

    public static MyServer server;

    @PostConstruct
    public void init() throws Exception {
        server=new MyServer(Application.websocketPort);
        server.startServer();
    }
}
