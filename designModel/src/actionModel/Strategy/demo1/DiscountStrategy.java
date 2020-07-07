package actionModel.Strategy.demo1;

import java.math.BigDecimal;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-30 14:01
 *
 *    折扣接口
 */
public interface DiscountStrategy {
    BigDecimal  getDisCount(BigDecimal total);
}
