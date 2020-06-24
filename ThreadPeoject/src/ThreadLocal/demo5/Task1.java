package ThreadLocal.demo5;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-24 15:59
 */
class Task1 {
    public void process() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        System.out.printf("[%s] check user %s...\n", Thread.currentThread().getName(), UserContext.getCurrentUser());
    }
}

class Task2 {
    public void process() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        System.out.printf("[%s] %s registered ok.\n", Thread.currentThread().getName(), UserContext.getCurrentUser());
    }
}

class Task3 {
    public void process() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        System.out.printf("[%s] work of %s has done.\n", Thread.currentThread().getName(),
                UserContext.getCurrentUser());
    }
}