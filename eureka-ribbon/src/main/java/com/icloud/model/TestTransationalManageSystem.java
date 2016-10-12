package com.icloud.model;

public class TestTransationalManageSystem {
    private Integer id;

    private String transactionalid;

    private String eventtype;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransactionalid() {
        return transactionalid;
    }

    public void setTransactionalid(String transactionalid) {
        this.transactionalid = transactionalid == null ? null : transactionalid.trim();
    }

    public String getEventtype() {
        return eventtype;
    }

    public void setEventtype(String eventtype) {
        this.eventtype = eventtype == null ? null : eventtype.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}