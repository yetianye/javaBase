package actionModel.ChainOfResponsibility.demo2;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-05 15:50
 */
public class Handler2 extends AbstractHandler{
    @Override
    void doHandler(HandlerChainContext handlerChainContext, Object arg0) {
        arg0 = arg0.toString() + "..2222222222的小尾巴.....";
        System.out.println("我是Handler2的实例，我在处理：" + arg0);
        // 继续执行下一个
        handlerChainContext.runNext(arg0);
    }
}
