package org.jogen.demo.other;

/**
 *
 */
public class CalculatorTest {
    public static void main(String[] args) {

        int res = Calculator.ADD.exec(12,4);
//        CaseFormat.UPPER_CAMEL.to()
        System.out.println(res);
        /*org.springframework.util.Assert.hasText("wu", "wuabc");
        //org.springframework.util.Assert.hasText("", "wuabc");
        org.springframework.util.Assert.isTrue(false, "不能为空");*/

    }
}
