package org.jogen.demo.dao;

import org.jogen.demo.po.Payable;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 *
 * @author Jogen
 */
@Repository
public interface PayableDao extends BaseDao{

    /**
     * 批量新增，新增成功后，会设置好主键
     * 目前Oracle批量新增时，没有设置好主键
     * @param list
     * @return
     */
    int batchInsert(List<Payable> list);

}