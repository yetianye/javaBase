package actionModel.Strategy.demo1;

import java.math.BigDecimal;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-30 14:03
 * 普通会员 9 折
 */
public class PrimeDisCountStrategy implements DiscountStrategy {

    @Override
    public BigDecimal getDisCount(BigDecimal total) {
        //折扣价格
        BigDecimal bigDecimal = total.multiply(new BigDecimal(0.2)).setScale(2, BigDecimal.ROUND_DOWN);
        return bigDecimal;
    }

}
