package SynchMethod;

/**
 * 静态方法 通过synchronized修饰方法,会锁住Class对象。
 */
public class StaticCounter {
    private  static int count = 0;
    /*加*/
    public static void addCount() {
        synchronized (StaticCounter.class){
            count++;
        }
    }
    /*减*/
    public static synchronized  void decCount() {
        count--;
    }
    //查询方法不需要同步
    public static  int getCount() {return  count;}
}

class StaticCounterMain{

    public static void main(String[] args) throws InterruptedException {
        StaticCounter counter2 = new StaticCounter();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                StaticCounter.addCount();
            }
        });
        Thread thread2 = new Thread(()->{
            for (int i = 0; i <100000 ; i++) {
                StaticCounter.decCount();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(StaticCounter.getCount());

    }
}
