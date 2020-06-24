package Volatile.Singleton;

/**
 *  双重检查锁定单例模式
 *  当其它线程通过操作三创建单例，其它线程就可以通过操作1 直接看到变量的状态
 */
public class MutilThreadSingleton {
    //唯一实例
    private static volatile  SingleThreadSingleton instance;

    public MutilThreadSingleton() {

    }
    //需要的时候才会创建 instance对象
    public static SingleThreadSingleton getInstance() {
        if(null == instance){  //操作1
            synchronized (MutilThreadSingleton.class){
                if(null == instance){//操作2
                    instance = new SingleThreadSingleton(); //操作3
                }
            }
        }
        return instance;
    }
}
