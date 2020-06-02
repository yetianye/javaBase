package reduce;

import java.util.stream.Stream;

/**
 * @Author: yetianye
 * map()和filter()都是Stream的转换方法，而Stream.reduce()则是Stream的一个聚合方法，它可以把一个Stream的所有元素按照聚合函数聚合成一个结果。
 */
public class Demo1 {

    public static void main(String[] args) {
        //0 是起始数字
        int sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce(0, (acc, n) -> acc + n);
        System.out.println(sum); // 45
    }
}
