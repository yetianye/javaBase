package actionModel.Strategy.demo1;

import java.math.BigDecimal;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-30 14:12
 *
 * 策略容器
 */
public class DiscountContext {
    //默认策略
    private  DiscountStrategy discountStrategy = new UserDisCountStrategy();

    public void setIscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    //计算打折后价格
    public BigDecimal computeDiscountPrice(BigDecimal total){
        return total.subtract(this.discountStrategy.getDisCount(total));
    }
}
