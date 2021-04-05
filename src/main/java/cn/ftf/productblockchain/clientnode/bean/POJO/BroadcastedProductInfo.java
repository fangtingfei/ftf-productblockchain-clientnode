package cn.ftf.productblockchain.clientnode.bean.POJO;

import java.io.Serializable;
import java.util.Objects;

/**
 * 商品录入信息
 *
 * @Author 房廷飞
 * @Create 2020-12-10 17:16
 */

public class BroadcastedProductInfo implements Serializable {
    private String company;
    private String product;
    private Long timeStamp;
    private String orginPlace;
    private String description;
    private String notes;

    //扫描终端公钥
    private String senderPublicKey;
    //数据签名
    private String signaturedData;

    public BroadcastedProductInfo(){

    }

    public BroadcastedProductInfo(String company, String product, Long timeStamp, String orginPlace, String description, String notes, String senderPublicKey, String signaturedData) {
        this.company = company;
        this.product = product;
        this.timeStamp = timeStamp;
        this.orginPlace = orginPlace;
        this.description = description;
        this.notes = notes;
        this.senderPublicKey = senderPublicKey;
        this.signaturedData = signaturedData;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getOrginPlace() {
        return orginPlace;
    }

    public void setOrginPlace(String orginPlace) {
        this.orginPlace = orginPlace;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getSenderPublicKey() {
        return senderPublicKey;
    }

    public void setSenderPublicKey(String senderPublicKey) {
        this.senderPublicKey = senderPublicKey;
    }

    public String getSignaturedData() {
        return signaturedData;
    }

    public void setSignaturedData(String signaturedData) {
        this.signaturedData = signaturedData;
    }

    @Override
    public String toString() {
        return "BroadcastedProductInfo{" +
                "company='" + company + '\'' +
                ", product='" + product + '\'' +
                ", timeStamp=" + timeStamp +
                ", orginPlace='" + orginPlace + '\'' +
                ", description='" + description + '\'' +
                ", notes='" + notes + '\'' +
                ", senderPublicKey='" + senderPublicKey + '\'' +
                ", signaturedData='" + signaturedData + '\'' +
                '}';
    }
}
