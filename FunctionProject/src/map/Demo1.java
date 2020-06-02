package map;

import java.util.stream.Stream;

/**
 * @Author: yetianye
 * 所谓map操作，就是把一种操作运算，映射到一个序列的每一个元素上。例如，对x计算它的平方，可以使用函数f(x) = x * x。
 * 我们把这个函数映射到一个序列1，2，3，4，5上，就得到了另一个序列1，4，9，16，25：
 */
public class Demo1 {
    public static void main(String[] args) {
        Stream<Integer> s = Stream.of(1, 2, 3, 4, 5);
        s.map(n -> n * n).forEach((a)-> System.out.println(a));
    }
}
