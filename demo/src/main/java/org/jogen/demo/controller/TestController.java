package org.jogen.demo.controller;

import com.alibaba.fastjson.JSON;
import org.jogen.demo.dao.PayableDao;
import org.jogen.demo.po.Payable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jogen
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    PayableDao payableDao;

    @GetMapping("get")
    public ResponseEntity<?> get(@RequestParam String id){
        System.out.println(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/batchInsert")
    public ResponseEntity<?> batchInsert(){
        List<Payable> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Payable payable = new Payable();
            payable.setSupplierAccount("SupplierAccount"+i);
            payable.setFinancingAmount(i*100);
            payable.setSupplierName("SupplierName"+i);
            list.add(payable);
        }
        int result = payableDao.batchInsert(list);
        System.out.println(result);
        System.out.println(JSON.toJSONString(result, true));
        return ResponseEntity.ok(list);
    }
}
