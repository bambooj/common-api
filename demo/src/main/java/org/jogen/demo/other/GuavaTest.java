package org.jogen.demo.other;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.*;
import org.junit.Test;

import java.util.Map;

/**
 * guava test.
 */
public class GuavaTest {

    /**
     * table
     */
    @Test
    public void test01(){
        Table<Integer, String, String> table = HashBasedTable.create();

        table.put(0, "save", "保存");
        table.put(1,"auditing", "审核中");
        table.put(2,"pass", "通过");
        System.out.println(JSON.toJSONString(table.rowMap()));
        System.out.println(JSON.toJSONString(table.rowKeySet()));
        System.out.println(JSON.toJSONString(table.row(1).get("auditing")));
        System.out.println(JSON.toJSONString(table.column("save").get(0)));
        System.out.println(JSON.toJSONString(table.columnMap()));
        System.out.println(JSON.toJSONString(table));
    }

    /**
     * BiMap
     */
    @Test
    public void test02() {
        BiMap<String,String> status = HashBiMap.create();
        status.put("0","save");
        status.put("0", "auditing");
        status.put("2", "pass");
        status.put("3", "finished");
        //status.put("4", "finished");
        status.forcePut("4","pass");
        System.out.println(JSON.toJSONString(status));
        //status = status.inverse();
        System.out.println(status.inverse().get("pass"));
        Map<String, String> immutableMap = ImmutableMap.of("key","value","key2","value2");
        System.out.println(immutableMap.get("key"));
    }
}
