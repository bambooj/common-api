package org.jogen.demo.dao;

import org.jogen.demo.po.BasePo;

import java.util.List;
import java.util.Map;

/**
 * IDao.
 * @author Jogen
 */
public interface BaseDao {

    /**
     * 新增
     * @param po
     */
    void insert(BasePo po);

    /**
     * 删除
     * @param po
     */
    void delete(BasePo po);

    /**
     * 修改
     * @param po
     */
    void update(BasePo po);

    /**
     * 查询
     * @param po
     * @return
     */
    BasePo select(BasePo po);

    /**
     * 查询记录数.
     * @param requestMap
     * @return
     */
    long count(Map<String, Object> requestMap);

    /**
     * 查询列表
     * @param requestMap
     * @return
     */
    List<BasePo> list(Map<String, Object> requestMap);

}
