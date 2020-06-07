package actionModel.ChainOfResponsibility.demo1;

import java.math.BigDecimal;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-05 13:16
 * 请求对象
 */
public class Request {
    private String name;
    private BigDecimal amount;

    public Request(String name, BigDecimal amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
