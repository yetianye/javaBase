package actionModel.ChainOfResponsibility.demo2;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-05 15:50
 * // -----链表形式调用------netty就是类似的这种形式
 */
public class PipelineDemo {
    //初始化 管道头
    public HandlerChainContext head = new HandlerChainContext(new AbstractHandler(){
        @Override
        void doHandler(HandlerChainContext handlerChainContext, Object arg0) {
            handlerChainContext.runNext(arg0);
        }
    });

    //向HandlerChainContext 最后的位置插入对象
    public void addLast(AbstractHandler abstractHandler){
        HandlerChainContext temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new HandlerChainContext(abstractHandler);
    }

    public void requestProcess(Object obj){
        this.head.handler(obj);
    }

    public static void main(String[] args) {
        PipelineDemo pipe = new PipelineDemo();
        pipe.addLast(new Handler1());
        pipe.addLast(new Handler2());
        pipe.addLast(new Handler1());
        pipe.addLast(new Handler2());
        pipe.requestProcess("开始执行请求");
    }
}
