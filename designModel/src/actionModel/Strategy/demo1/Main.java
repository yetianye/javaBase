package actionModel.Strategy.demo1;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-30 11:50
 *
 *  ======================================策略模式======================================
 *  策略模式的核心思想是在一个计算方法中把容易变化的算法抽出来作为“策略”参数传进去，从而使得新增策略不必修改原有逻辑。
 */
public class Main {

    public static void main(String[] args) {

        //容器
        DiscountContext ctx = new DiscountContext();
        //普通客户 九折
        BigDecimal discountPrice = ctx.computeDiscountPrice(new BigDecimal(299));
        System.out.println("普通客户："+discountPrice);


        //prime 会员

        ctx.setIscountStrategy(new PrimeDisCountStrategy());
        BigDecimal bigDecimal = ctx.computeDiscountPrice(new BigDecimal(299));
        System.out.println("prime 会员：" + bigDecimal);



        //满100 减20 会员再八折
        ctx.setIscountStrategy(new OverHundredDisCountStrategy());
        BigDecimal bigDecimal1 = ctx.computeDiscountPrice(new BigDecimal(299));

        ctx.setIscountStrategy(new PrimeDisCountStrategy());
        BigDecimal bigDecimal2 = ctx.computeDiscountPrice(bigDecimal1);

        System.out.println("满100-20，prime再打八折： " + bigDecimal2);


    }
}
