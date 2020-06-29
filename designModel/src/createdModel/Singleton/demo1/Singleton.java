package createdModel.Singleton.demo1;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-29 10:25
 *
 * 单例模式
 *
 * 只有private构造方法，确保外部无法实例化；
 * 通过private static变量持有唯一实例，保证全局唯一性；
 * 通过public static方法返回此唯一实例，使外部调用方能获取到实例。
 */
public class Singleton {
    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();

    }
}

