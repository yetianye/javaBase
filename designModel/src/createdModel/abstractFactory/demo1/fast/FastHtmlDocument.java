package createdModel.abstractFactory.demo1.fast;

import createdModel.abstractFactory.demo1.AbstractFactory;
import createdModel.abstractFactory.demo1.HtmlDocument;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-27 14:01
 */
public class FastHtmlDocument implements HtmlDocument {

    @Override
    public String toHtml() {
        return "fast - html ";
    }

    @Override
    public void save(String path) {

    }
}
