package com.merchant.model;

import java.util.Date;

/**
 * 商户消息表
 * @author luoqw
 * 2016-9-5下午3:38:46
 */
public class MerchantsMessage {
    private Integer id;

    private String msgContent;

    private Date createDate;

    private String readState;

    private Integer merchantsId;

    private String sendUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent == null ? null : msgContent.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getReadState() {
        return readState;
    }

    public void setReadState(String readState) {
        this.readState = readState == null ? null : readState.trim();
    }

    public Integer getMerchantsId() {
        return merchantsId;
    }

    public void setMerchantsId(Integer merchantsId) {
        this.merchantsId = merchantsId;
    }

    public String getSendUser() {
        return sendUser;
    }

    public void setSendUser(String sendUser) {
        this.sendUser = sendUser == null ? null : sendUser.trim();
    }
}