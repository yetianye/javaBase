package SimpleChain;

/**
 * @Author: yetianye
 * @CreateTime: 2020-06-07 15:16
 * 简单的链表
 */
public class Main {
    public static void main(String[] args) {
        //头节点
        Node head = new Node(-1);
        //第一个节点
        Node firstNode = new Node(0);
        //第二个节点
        Node secondNode = new Node(1);

        head.addToNext(firstNode)
        .addToNext(secondNode)
        .addToTail(new Node(2));

        head.addToHead(head,new Node(3));


        //链接
        System.out.println(head.toString());
    }
}
