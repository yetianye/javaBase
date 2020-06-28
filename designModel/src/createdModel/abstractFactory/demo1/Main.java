package createdModel.abstractFactory.demo1;

import createdModel.abstractFactory.demo1.fast.FastFactory;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-27 14:06
 * 抽象工厂模式
 *
 *  AbstractFactory 抽象文档工厂
 *  FastFactory 抽象 fast工厂
 *
 */
public class Main {
    public static void main(String[] args) throws Exception {

        AbstractFactory goodfactory = AbstractFactory.getInstance("good");
        HtmlDocument asd = goodfactory.createHtml("asd");
        WordDocument asddd = goodfactory.createWord("asddd");
        System.out.println(asd.toHtml());
        System.out.println(asddd.toWord());

        AbstractFactory fastfactory = AbstractFactory.getInstance("fast");
        HtmlDocument aaa = fastfactory.createHtml("asd");
        WordDocument ddd = fastfactory.createWord("asddd");
        System.out.println(aaa.toHtml());
        System.out.println(ddd.toWord());

    }
}
