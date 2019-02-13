package org.jogen.demo.other;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamTest {

    @Test
    public void test01() {
        List<String> list = Arrays.asList("a1", "a2", "b2", "b1", "c3", "c1", "c2");
        list.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

    }

    @Test
    public void test02() {
       // Assert.assertFalse("", false);
        org.springframework.util.Assert.hasText("1","wuabc");

    }

    @Test
    public void test03() {
        Map<String, Object> params = new HashMap<>();
        params.put("projectId", 291L);
        params.put("page", 1);
        params.put("pageLength", 20);
        String paramStr = JSON.toJSONString(params);
        System.out.println(paramStr);
    }


}
