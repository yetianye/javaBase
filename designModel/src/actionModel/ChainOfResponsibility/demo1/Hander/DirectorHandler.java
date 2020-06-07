package actionModel.ChainOfResponsibility.demo1.Hander;

import actionModel.ChainOfResponsibility.demo1.Request;

import java.math.BigDecimal;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-05 13:18
 *
 * 总经理审批处理器
 */
public class DirectorHandler implements Handler {

    @Override
    public Boolean process(Request request) {
        //大于1000,交给下个处理
        if(request.getAmount().compareTo(BigDecimal.valueOf(2000)) > 0){
            return null;
        }
        //除了bob，其它人返回true
        return !request.getName().equalsIgnoreCase("bob");
    }
}
