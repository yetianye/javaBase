package actionModel.ChainOfResponsibility.demo1.Hander;

import actionModel.ChainOfResponsibility.demo1.Request;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-05 13:17
 * 处理器
 */
public interface Handler {
    // 返回Boolean.TRUE = 成功
    // 返回Boolean.FALSE = 拒绝
    // 返回null = 交下一个处理
    Boolean process(Request request);
}
