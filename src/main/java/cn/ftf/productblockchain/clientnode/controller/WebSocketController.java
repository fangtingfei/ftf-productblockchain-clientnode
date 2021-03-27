package cn.ftf.productblockchain.clientnode.controller;

import cn.ftf.productblockchain.clientnode.cache.AddressPool;
import cn.ftf.productblockchain.clientnode.message.Result;
import org.mockito.internal.junit.UniversalTestListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

/**
 * WebSocketController
 *
 * @Author 房廷飞
 * @Create 2021-03-20 21:27
 */
@RestController
@RequestMapping("/node")
public class WebSocketController {
    Logger logger= LoggerFactory.getLogger(getClass());
    @Autowired
    private AddressPool addressPool;
    @GetMapping("/add")
    public Result addNode (String uri)throws Exception{
        addressPool.addURI(uri);
        logger.info("[添加节点成功] URI={}",uri);
        return new Result(true,"success");
    }
    @PostMapping("/remove")
    public Result removeNode (String uri)throws Exception{
        addressPool.removeURI(uri);
        logger.info("[移除节点成功] URI={}",uri);
        return new Result(true,"success");
    }


}
