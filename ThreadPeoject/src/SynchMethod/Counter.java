package SynchMethod;

/**
 * 同步方法
 * synchronized 修饰得方法相当于用实例 this 所著整个方法内容
 * 加和减 得写法是等价得。
 *
 */
public class Counter {
    private  int count = 0;
    /*加*/
    public synchronized void addCount() { this.count++;}
    /*减*/
    public  void decCount() {
        synchronized(this){
            this.count--;
        }
    }

    //查询方法不需要同步
    public int getCount() {return count;}

}

class test {
    public static void main(String[] args) throws InterruptedException {
        //每个对象，有单独的对象锁，不会被其它线程影响到
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();

        new Thread(()->{
            for (int i = 0; i <10000 ; i++) {
                counter1.addCount();
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i <10000 ; i++) {
                counter1.decCount();
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i <10000 ; i++) {
                counter2.addCount();
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i <10000 ; i++) {
                counter2.decCount();
            }
        }).start();

        Thread.sleep(1000);
        System.out.println(counter1.getCount());
        System.out.println(counter2.getCount());
    }
}
