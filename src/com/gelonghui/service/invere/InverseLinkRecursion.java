package com.gelonghui.service.invere;

import com.gelonghui.entity.Node;
import com.gelonghui.util.NodeUtil;

/**
 * 用递归方式实现逆置链表
 * Created by quanwenchao
 * 2018/5/2 9:28:56
 */
public class InverseLinkRecursion {

    /**
     * 递归方式逆置链表
     * @param pre 当前节点的前驱节点
     * @param cur 当前节点
     * @return 逆置后的链表
     */
    public static Node inverse(Node pre, Node cur) {

        if (cur == null) {
            return pre;
        }

        Node head = inverse(cur, cur.getNext()); //递归向后传递的参数：当前节点，当前节点的下一节点
        cur.setNext(pre); //当前节点再指向前一个节点

        return head;
    }

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{10, 20, 30, 40, 50, 60};

        // 创建单向链表
        Node head = NodeUtil.createLink(arr);

        // 输出单项链表
        System.out.println("逆置前: ");
        NodeUtil.printLink(head);

        // 逆置单向链表
        head = inverse(null, head);

        // 输出单向链表
        System.out.println("逆置后: ");
        NodeUtil.printLink(head);

        // 释放链表
        NodeUtil.clearLink(head);
    }
}
