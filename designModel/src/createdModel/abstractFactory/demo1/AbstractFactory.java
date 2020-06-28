package createdModel.abstractFactory.demo1;

import createdModel.abstractFactory.demo1.fast.FastFactory;
import createdModel.abstractFactory.demo1.good.GoodFactory;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-27 13:58
 */
public interface AbstractFactory {

     static AbstractFactory  getInstance(String name) throws Exception {
        if("fast".equals(name)){
            return new FastFactory();
        }else if("good".equalsIgnoreCase(name)){
            return new GoodFactory();
        }else {
            throw new Exception("type wrong exception");
        }
    }

    HtmlDocument createHtml(String md);

    WordDocument createWord(String md);

}
