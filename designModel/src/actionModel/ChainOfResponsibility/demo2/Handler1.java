package actionModel.ChainOfResponsibility.demo2;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-05 15:48
 */
public class Handler1 extends AbstractHandler {

    @Override
    void doHandler(HandlerChainContext handlerChainContext, Object arg0) {
        arg0 = arg0.toString() + "..111111111的小尾巴.....";
        System.out.println("我是Handler1的实例，我在处理：" + arg0);
        // 继续执行下一个
        handlerChainContext.runNext(arg0);
    }
}
