package lamdba;

import java.util.function.Consumer;

public class Demo09Consumer {
    public static void main(String[] args) {
        newConsumer((s)-> System.out.println(s));
    }

    public static void newConsumer(Consumer consumer){
         consumer.accept("123");
    }
}
