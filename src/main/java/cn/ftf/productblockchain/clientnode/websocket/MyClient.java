package cn.ftf.productblockchain.clientnode.websocket;


import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.URI;

/**
 * 客户端
 *
 * @Author 房廷飞
 * @Create 2020-11-27 8:06
 */

public class MyClient extends WebSocketClient {
    private String uri;
    Logger logger= LoggerFactory.getLogger(getClass());
    public MyClient(URI serverUri) {
        super(serverUri);
        this.uri = serverUri.toString();
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        logger.info("[客户端开启连接] URI={}",uri);
    }

    @Override
    public void onMessage(String message) {
        logger.info("[客户端接收消息] Msg={}",message);;
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        logger.info("[客户端关闭连接] URI={}",uri);
    }

    @Override
    public void onError(Exception ex) {
        logger.info("[客户端错误] URI={}",uri);
    }
}
