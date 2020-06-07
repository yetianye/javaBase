package actionModel.ChainOfResponsibility.demo1;

import actionModel.ChainOfResponsibility.demo1.Hander.Handler;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-05 13:21
 */
public class HandlerChain {
    //集合
    private List<Handler> handlers = new ArrayList<>();

    //添加hander
    public void addHander (Handler handler){
        this.handlers.add(handler);
    }

    public boolean process(Request request) {
        // 依次调用每个Handler:
        for (Handler handler : handlers) {
            Boolean r = handler.process(request);
            // 如果返回TRUE或FALSE，处理结束:
            //如果等于null，那继续通过其它的处理器处理请求
            if (r != null) {
                System.out.println(request.getName() + " " + (r ? "通过 by " : "拒绝 by ") + handler.getClass().getSimpleName());
                return r;
            }
        }

        throw new RuntimeException("Could not handle request: " + request);
    }
}
