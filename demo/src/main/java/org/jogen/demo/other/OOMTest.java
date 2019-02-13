package org.jogen.demo.other;
/**
 * -Xms20m -Xmx20m
 * @author J
 */
public class OOMTest extends Thread{
    public static void main(String[] args) throws InterruptedException {
        OOMTest t = new OOMTest();
        for(int i = 1; i < 10000; i++) {
            new HelloWorld(i);
            sleep(100);
        }
    }
}

class HelloWorld {
    public HelloWorld(int i) {
        System.out.println("Hello Java!" + i);
    }
}