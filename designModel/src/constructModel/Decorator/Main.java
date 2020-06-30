package constructModel.Decorator;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-29 20:26
 *
 * 动态地给一个对象添加一些额外的职责。就增加功能来说，相比生成子类更为灵活。
 * 如果我们要自己设计完整的Decorator模式，应该如何设计？
 *
 *
 */
public class Main {
    public static void main(String[] args) {
        TextNode asd = new SpanNode("asd");

        BoildDecorator boildDecorator = new BoildDecorator(asd);

        System.out.println(boildDecorator.getNode());//
    }
}
