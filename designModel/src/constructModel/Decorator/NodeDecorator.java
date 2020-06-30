package constructModel.Decorator;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-29 20:39
 *
 * 抽象类，实现 textNode接口，拥有textNode对象
 */
public abstract class NodeDecorator implements TextNode {

    protected final TextNode textNode;


    protected NodeDecorator(TextNode textNode) {
        this.textNode = textNode;
    }
}

/*装饰器 子类*/
class BoildDecorator extends  NodeDecorator{

    protected BoildDecorator(TextNode textNode) {
        super(textNode);
    }

    @Override
    public void setNode(String text) {

    }

    @Override
    public String getNode() {
        return "<b>" + textNode.getNode() + "<b>";
    }
}



