package actionModel.ChainOfResponsibility.demo2;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-05 15:41
 *
 * handle 上下文 ：维护链和 链的执行
 */
public class HandlerChainContext {
    HandlerChainContext nextHandlerChainContext;
    AbstractHandler handler;

    public HandlerChainContext(AbstractHandler handler) {
        this.handler = handler;
    }

    void handler(Object arg0){
        this.handler.doHandler(this,arg0);
    }

    void runNext(Object arg0){
        if(this.nextHandlerChainContext != null){
            this.nextHandlerChainContext.handler(arg0);
        }
    }
}
