package actionModel.ChainOfResponsibility.SimpleChain;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-05 18:22
 * 一个简单的连表
 */
public class Chain {

    public Node head = new Node();

    void add(Object data){
        Node node = head;
        while(node.next != null){
            node = node.next;
        }
        node.next = new Node();

    }

    Node getChanin(){
        return head;
    }

    public static void main(String[] args) {
        Chain c= new Chain();
        c.add(123);
        c.add(2342);
        System.out.println(c);
    }
}

class Node {
    Node next;
    Object data;
    public Node() {
    }
    public Node(Object data) {
        this.data = data;
    }

}
