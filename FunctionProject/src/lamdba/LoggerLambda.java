package lamdba;

import java.util.Arrays;
import java.util.Comparator;

/**
 * lamdba 接口
 */
public class LoggerLambda {

    public static void main(String[] args) {
        /*String a = "aaa";
        String b = "ccc";
        String c = "ccc";

        log(1, new MessageBuilder() {
            @Override
            public String buiderMessage() {
                return a + b + c;
            }
        });

        log(1,() -> a + b + c);

        //线程
        new Thread(()->System.out.println(123)).start();*/

        //比较器
        String[] array = { "abc", "ab", "abcd" };
        System.out.println(Arrays.toString(array));
        Arrays.sort(array, newComparator() );
        System.out.println(Arrays.toString(array));
    }

    //日志
    static void log(int level,MessageBuilder builder){
        if(level > 1 ){
            System.out.println(builder.buiderMessage());
        }
    }

    //比较器
    static Comparator<String> newComparator(){
        return (a,b) -> b.length() - a.length();
    }
}
