package ThreadLocal.demo1;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-22 15:33
 *
 * Threadlocal的使用
 * 每个线程绑定自己的值，通过ThreadLocalMap 对象存储，当前线程作为key.
 * Threadlocal解决不同线程之间的隔离性，，即不同县城拥有自己的值
 *     public void set(T value) {
 *         Thread t = Thread.currentThread();
 *         ThreadLocalMap map = getMap(t);
 *         if (map != null)
 *             map.set(this, value);
 *         else
 *             createMap(t, value);
 *     }
 */
public class Run {
    public static ThreadLocal tl = new ThreadLocal();
    public static void main(String[] args) {
        if (tl.get() == null) {
            System.out.println("从未放过值");
            tl.set("我的值");
        }
        System.out.println(tl.get());
        System.out.println(tl.get());
    }
}
