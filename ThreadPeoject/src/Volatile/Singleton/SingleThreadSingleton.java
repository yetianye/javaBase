package Volatile.Singleton;

/**
 * @Author: yetianye
 * 单线程实现单例模式
 */

public class SingleThreadSingleton {
    //唯一实例
    private static  SingleThreadSingleton instance = null;

    public SingleThreadSingleton() {

    }
    //需要的时候才会创建 instance对象
    public static SingleThreadSingleton getInstance() {
        if(null == instance){
            instance = new SingleThreadSingleton();
        }
        return instance;
    }
}
