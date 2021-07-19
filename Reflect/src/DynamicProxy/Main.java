package DynamicProxy;

import java.lang.reflect.Proxy;

/**
 * @Author: yetianye
 * JDK代理
 *
 */
public class Main {
    /**
     * Proxy.newProxyInstance() 实现一个基于 接口的实现类
     * ClassLoader loader, 类加载器
     * Class<?>[] interfaces, 类实现的接口
     * InvocationHandler h 注入处理接口
     */
    public static void main(String[] args) {
        JavaDeveloper ye = new JavaDeveloper("ye");
        /**
         * InvocationHandler作用就是，当代理对象的原本方法被调用的时候，会绑定执行一个方法，
         * 这个方法就是InvocationHandler里面定义的内容，同时会替代原本方法的结果返回。
         * InvocationHandler接收三个参数
         * proxy，代理后的实例对象。
         * method，对象被调用方法。
         * args，调用时的参数。
         */
        Developer yeProxy = (Developer)Proxy.newProxyInstance(ye.getClass().getClassLoader(), ye.getClass().getInterfaces(), ((proxy, method, args1) -> {
            if (method.getName().equals("write")) {
                System.out.println("写代码之前先喝酒。。。。");
                return method.invoke(ye, args);
            }
            return null;
        }));

        yeProxy.write();
    }
}


class JavaDeveloper implements Developer{
    private String name;
    public JavaDeveloper(String name) {
        this.name = name;
    }

    @Override
    public void write() {
        System.out.println("coding.......");
    }
}

interface  Developer {
    void write();
}
