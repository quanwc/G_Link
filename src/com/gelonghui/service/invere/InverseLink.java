package com.gelonghui.service.invere;

import com.gelonghui.entity.Node;
import com.gelonghui.util.NodeUtil;

/**
 * 将一个非空单向链表就地逆置
 * Created by quanwenchao
 * 2018/4/25 9:00:22
 */
public class InverseLink {

    /**
     * 正向建链
     * @param head 链表头节点
     */
    public static Node inverse1(Node head) {
        if (head == null) {
            System.out.println("The Link is empty!");
            return null;
        }

        Node s = null; // 指向链表剩余部分的头节点
        Node p = null; // 遍历链表过程中，指向当前操作的节点
        s = head.getNext();
        head.setNext(null);
        while(s != null) {
            p = s; // p先指到s上
            s = s.getNext(); // s再后移
            p.setNext(head); //操作当前指针p，让p指向head
            head = p; // head再后移
        }

        return head;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{10, 20, 30, 40, 50, 60};

        // 创建单向链表
        Node head = NodeUtil.createLink(arr);

        // 逆置单向链表
        head = inverse1(head);

        // 输出单向链表
        NodeUtil.printLink(head);

        // 释放链表
        NodeUtil.clearLink(head);

    }

}
