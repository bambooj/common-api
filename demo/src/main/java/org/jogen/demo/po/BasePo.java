package org.jogen.demo.po;

import java.io.Serializable;
import java.time.LocalDateTime;

public class BasePo implements Serializable {

    /**
     * id
     */
    protected Long id;

    /**
     * 是否删除；1：删除，0：未删除
     */
    protected boolean isDeleted;

    /**
     * 状态
     */
    protected int status;

    /** 建立日期 **/
    protected LocalDateTime createdAt;

    /** 修改日期 **/
    protected LocalDateTime updatedAt;

    public BasePo() {
    }

    public BasePo(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
