package actionModel.Strategy.demo1;

import java.math.BigDecimal;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-30 14:03
 *  满100 减 20
 */
public class OverHundredDisCountStrategy implements DiscountStrategy {

    @Override
    public BigDecimal getDisCount(BigDecimal total) {
        if(total.intValue() >= 100){
            //折扣价格
            return  new BigDecimal(20);
        }

        return new BigDecimal(0);
    }

}
