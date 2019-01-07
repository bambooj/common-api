package org.jogen.demo.service;

import org.jogen.demo.dao.DaoHandler;
import org.jogen.demo.dao.PayableDao;
import org.jogen.demo.po.BasePo;
import org.jogen.demo.po.Payable;
import org.jogen.demo.vo.PageVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 供应商服务.
 * @author Jogen
 */
@Service
public class PayableService extends BaseService<Payable, PayableDao>{

    @Override
    public PageVo findPage(Integer page, Integer pageSize, Map<String, Object> conditions) {
        //查找总数
        Long count = dao.count(DaoHandler.params(conditions));
        //查询分页信息
        List<BasePo> resultLists = dao.list(
                DaoHandler.param().requestPage(page, pageSize).params(conditions));

        return new PageVo(count, resultLists);
    }
}
