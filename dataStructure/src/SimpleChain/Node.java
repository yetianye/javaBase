package SimpleChain;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-07 17:32
 * https://blog.csdn.net/CrazyHSF/article/details/81049609
 */
public class Node {
    //数据
    private int value;
    //下一节点
    private Node next;

    public Node(int value,Node next){
        this.value =value;
        this.next = next;
    }

    public Node(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node setValue(int value) {
        this.value = value;
        return this;
    }

    public Node getNext() {
        return next;
    }

    public Node setNext(Node next) {
        this.next = next;
        return this;
    }

    public boolean hasNext(){
        return this.next == null ? false : true;
    }

    public Node addToNext(Node node){
        this.next = node;
        return node;
    }

    /**
     * 尾部插入一个元素
     * @return
     */
    public void addToTail(Node node){
        Node temp = this;
        while(temp.hasNext()){
            temp = temp.next;
        }
        temp.next = node;
    }

    //现将新节点的值指向原有头节点的下一个节点，再将头节点指向新节点
    public void addToHead(Node head,Node node){
        node.next = head.next;
        head.next = node;
    }

    @Override
    public String toString() {
        String val = Integer.toString(value);
        if(next != null){
            val = val.concat(" -> ");
            val = val.concat(next.toString());
        }
        return val;
    }

}
