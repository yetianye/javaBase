package createdModel.abstractFactory.demo1.good;

import createdModel.abstractFactory.demo1.WordDocument;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-27 14:01
 */
public class GoodWordDocument implements WordDocument {

    @Override
    public String toWord() {
        return "Good - word";
    }

    @Override
    public void save(String path) {

    }
}
