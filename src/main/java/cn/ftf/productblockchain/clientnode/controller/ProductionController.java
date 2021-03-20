package cn.ftf.productblockchain.clientnode.controller;

import cn.ftf.productblockchain.clientnode.bean.POJO.BroadcastedProductInfo;
import cn.ftf.productblockchain.clientnode.bean.NodeKey;
import cn.ftf.productblockchain.clientnode.bean.POJO.ProductInfo;
import cn.ftf.productblockchain.clientnode.message.Result;
import cn.ftf.productblockchain.clientnode.util.RSAUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * client-ProductionController
 *
 * @Author 房廷飞
 * @Create 2021-03-19 22:05
 */

@RestController
public class ProductionController {

    Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private NodeKey nodeKey;

    @RequestMapping(value = "/addProduction", method = RequestMethod.POST)
    public Result addProduction(@RequestBody ProductInfo productInfo) throws Exception {
        String productInfojson = null;
        String broadcastedProductInfoJson=null;
        logger.info("[接收商品信息] productInfo:" + productInfo);
        ObjectMapper mapper = new ObjectMapper();
        try {
            productInfojson = mapper.writeValueAsString(productInfo);
            logger.info("[商品信息转化为JSON] productInfojson:" + productInfojson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        String signature = RSAUtils.getSignature("SHA256withRSA", nodeKey.getPrivateKey(), productInfojson);

        BroadcastedProductInfo broadcastedProductInfo=new BroadcastedProductInfo(productInfo.getCompany(),productInfo.getProduct(),productInfo.getProductionDate(),productInfo.getOrginPlace(),productInfo.getDescription(),productInfo.getNotes(), Base64.encodeBase64String(nodeKey.getPublicKey().getEncoded()),signature);
        logger.info("[生成加密商品信息] broadcastedProductInfo:" + broadcastedProductInfo);
        try {
            broadcastedProductInfoJson = mapper.writeValueAsString(broadcastedProductInfo);
            logger.info("[生成加密商品信息JSON] broadcastedProductInfoJson:" + broadcastedProductInfoJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new Result(true,"success a");
    }
}