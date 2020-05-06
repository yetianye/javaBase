package productAndCost;

/**
 * 生产者消费者
 */
public class Test {
    public static void main(String[] args) {
        //等待唤醒案例
        BaoZi bz = new BaoZi();
        ChiHuo ch = new ChiHuo("吃货",bz);
        BaoZiPu bzp = new BaoZiPu("包子铺",bz);
        ch.start();
        bzp.start();
}
}
