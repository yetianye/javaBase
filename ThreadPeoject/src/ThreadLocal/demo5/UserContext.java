package ThreadLocal.demo5;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-24 15:58
 *
 * 通过AutoCloseable接口配合try (resource) {...}结构，让编译器自动为我们关闭资源
 */
class UserContext implements AutoCloseable {
    private static final ThreadLocal<String> userThreadLocal = new ThreadLocal<>();

    public UserContext(String name) {
        userThreadLocal.set(name);
        System.out.printf("[%s] init user %s...\n", Thread.currentThread().getName(), UserContext.getCurrentUser());
    }

    public static String getCurrentUser() {
        return userThreadLocal.get();
    }

    //
    @Override
    public void close() {
        System.out.printf("[%s] cleanup for user %s...\n", Thread.currentThread().getName(),
                UserContext.getCurrentUser());
        userThreadLocal.remove();
    }
}