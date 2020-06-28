package createdModel.abstractFactory.demo1.fast;

import createdModel.abstractFactory.demo1.WordDocument;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-27 14:01
 */
public class FastWordDocument implements WordDocument {


    @Override
    public String toWord() {
        return "fast - word";
    }

    @Override
    public void save(String path) {

    }
}
