package createdModel.Singleton.demo1;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-29 10:32
 *
 *  延迟加载 （懒汉模式）
 *  多线程模式下 会有问题
 */
public class LazySingleton {

    private static LazySingleton instance = null;

    public static LazySingleton getInstance() {
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}

/**
 * 多线程中 ，双重检查
 */
 class MultiLazySingleton{
    private static  MultiLazySingleton instance = null;

     public static MultiLazySingleton getInstance() {
         if(instance == null){
             synchronized (MultiLazySingleton.class){
                if(instance == null){
                    instance = new MultiLazySingleton();
                }
             }
         }
         return instance;
     }
}
