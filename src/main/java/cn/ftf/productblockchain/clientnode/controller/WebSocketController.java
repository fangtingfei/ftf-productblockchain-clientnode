package cn.ftf.productblockchain.clientnode.controller;

import cn.ftf.productblockchain.clientnode.cache.AddressPool;
import cn.ftf.productblockchain.clientnode.message.Result;
import org.mockito.internal.junit.UniversalTestListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;

/**
 * WebSocketController
 *
 * @Author 房廷飞
 * @Create 2021-03-20 21:27
 */
@Controller
public class WebSocketController {
    Logger logger= LoggerFactory.getLogger(getClass());
    @Autowired
    private AddressPool addressPool;
    @PostMapping
    public Result addNode (String url)throws Exception{
        addressPool.addURL(url);
        logger.info("[添加节点成功] url={}",url);
        return new Result(true,"success");
    }
    @PostMapping
    public Result removeNode (String url)throws Exception{
        addressPool.removeURL(url);
        logger.info("[移除节点成功] url={}",url);
        return new Result(true,"success");
    }


}
