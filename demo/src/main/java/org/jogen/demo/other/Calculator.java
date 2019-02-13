package org.jogen.demo.other;

/**
 * 策略枚举模式
 */
public enum Calculator {
    ADD {
        @Override
        public int exec(int a, int b) {
            return a + b;
        }
    },
    SUB {
        @Override
        public int exec(int a, int b) {
            return a - b;
        }
    };

    public abstract int exec(int a, int b);
}
