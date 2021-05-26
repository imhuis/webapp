package com.imhui.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Coffee implements Serializable {
    private Long id;
    private String name;
    private BigDecimal price;
    private Date createTime;
    private Date updateTime;

    public Coffee() {
    }

    public Coffee(String name, BigDecimal price, Date createTime, Date updateTime) {
        this.name = name;
        this.price = price;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
