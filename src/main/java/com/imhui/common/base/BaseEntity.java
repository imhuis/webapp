package com.imhui.common.base;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: zyixh
 * @date: 2020/1/28
 * @description:
 */
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1428342568790550230L;

    private Long id;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
