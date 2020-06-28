package createdModel.abstractFactory.demo1.good;

import createdModel.abstractFactory.demo1.HtmlDocument;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-27 14:01
 */
public class GoodHtmlDocument implements HtmlDocument {

    @Override
    public String toHtml() {
        return "Good - html ";
    }

    @Override
    public void save(String path) {

    }
}
