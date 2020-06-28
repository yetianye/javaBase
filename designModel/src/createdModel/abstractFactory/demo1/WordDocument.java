package createdModel.abstractFactory.demo1;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-27 13:59
 */
public interface WordDocument {
    String toWord();
    void save(String path);
}
