package org.jogen.demo.vo;

import java.io.Serializable;

/**
 *
 * @author Jogen
 */
public final class PageVo implements Serializable {

    private Long count;

    private Object data;

    public PageVo() {
    }

    public PageVo(Long count, Object data) {
        this.count = count;
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

