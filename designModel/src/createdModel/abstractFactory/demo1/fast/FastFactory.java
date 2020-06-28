package createdModel.abstractFactory.demo1.fast;

import createdModel.abstractFactory.demo1.AbstractFactory;
import createdModel.abstractFactory.demo1.HtmlDocument;
import createdModel.abstractFactory.demo1.WordDocument;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-27 14:05
 */
public class FastFactory implements AbstractFactory {
    @Override
    public HtmlDocument createHtml(String md) {
        return new FastHtmlDocument();
    }

    @Override
    public WordDocument createWord(String md) {
        return new FastWordDocument();
    }
}
