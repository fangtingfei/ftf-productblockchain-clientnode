package cn.ftf.productblockchain.clientnode.controller;

import cn.ftf.productblockchain.clientnode.message.Result;
import org.springframework.stereotype.Controller;
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

    @PostMapping
    public Result addNode(String url){

        return new Result(true,"success");
    }

}
