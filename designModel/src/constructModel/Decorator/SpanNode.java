package constructModel.Decorator;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-29 20:28
 */
public class SpanNode implements TextNode {
    private String text;

    public SpanNode(String text) {
        this.text = text;
    }

    @Override
    public void setNode(String text) {
        this.text = text;
    }

    @Override
    public String getNode() {
        return "<span>"+this.text+"</span>";
    }
}
