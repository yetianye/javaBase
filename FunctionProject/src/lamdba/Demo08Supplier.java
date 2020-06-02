package lamdba;

import java.util.function.Supplier;

public class Demo08Supplier {
    public static void main(String[] args) {
        String a = "asd";
        String b = "asd";
        System.out.println(getString(()-> a + b));

    }

    static String getString(Supplier<String> function){
        return function.get();
    }
}

