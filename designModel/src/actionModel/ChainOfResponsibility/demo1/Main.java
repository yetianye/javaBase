package actionModel.ChainOfResponsibility.demo1;

import actionModel.ChainOfResponsibility.demo1.Hander.CEOHandler;
import actionModel.ChainOfResponsibility.demo1.Hander.DirectorHandler;
import actionModel.ChainOfResponsibility.demo1.Hander.ManagerHandler;

import java.math.BigDecimal;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-05 13:29
 */
public class Main {
    public static void main(String[] args) {
        // 构造责任链:
        HandlerChain chain = new HandlerChain();
        chain.addHander(new ManagerHandler());
        chain.addHander(new DirectorHandler());
        chain.addHander(new CEOHandler());
        // 处理请求:
        chain.process(new Request("Bob", new BigDecimal("123.45")));
        chain.process(new Request("Alice", new BigDecimal("1234.56")));
        chain.process(new Request("Bill", new BigDecimal("2345.67")));
        chain.process(new Request("John", new BigDecimal("3456.78")));
    }
}
