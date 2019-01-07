package org.jogen.demo.service;


import org.jogen.demo.dao.BaseDao;
import org.jogen.demo.po.BasePo;
import org.jogen.demo.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jogen
 */
public abstract class BaseService<T extends BasePo, D extends BaseDao> {

    @Autowired
    protected D dao;

    public void save(T obj){
        obj.setDeleted(false);
        obj.setStatus(1);
        obj.setCreatedAt(LocalDateTime.now(ZoneId.systemDefault()));
        obj.setUpdatedAt(LocalDateTime.now(ZoneId.systemDefault()));
        dao.insert(obj);
    }

    public void delete(T obj){
        dao.delete(obj);
    }

    public void update(T obj){
        dao.update(obj);
    }

    public boolean exist(Long id){
        BasePo po = new BasePo();
        po.setId(id);
        return dao.select(po) != null;
    }

    public T findOne(T obj){
        return (T) dao.select(obj);
    }

    public T findById(Long id){
        BasePo po = new BasePo();
        po.setId(id);
        return (T) dao.select(po);
    }

    public List<BasePo> list(Map<String, Object> conditions){
        conditions.put("offset", 1);
        conditions.put("limit", Integer.MAX_VALUE);
        return dao.list(conditions);
    }

    /**
     * 分页查找
     * @param page
     * @param pageSize
     * @param conditions
     * @return
     */
    public abstract PageVo findPage(Integer page, Integer pageSize, Map<String, Object> conditions);


}
