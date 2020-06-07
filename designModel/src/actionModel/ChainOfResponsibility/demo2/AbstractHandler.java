package actionModel.ChainOfResponsibility.demo2;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-05 15:40
 *
 * Handler抽象类
 */
abstract class AbstractHandler {

    abstract void doHandler(HandlerChainContext handlerChainContext, Object arg0);
}
