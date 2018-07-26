package com.quanwc.service.invere;

import com.quanwc.entity.Node;
import com.quanwc.util.NodeUtil;

/**
 * 将一个非空单向链表就地逆置
 * Created by quanwenchao
 * 2018/4/25 9:00:22
 */
public class InverseLink {

    /**
     * 正向建链，返回的是原链表
     * @param head 链表头节点
     * @return 逆置后的链表头节点
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

    /**
     * 逆向建链，返回新的链表
     * @param head 链表头节点
     * @return 逆置后的链表头节点
     */
    public static Node inverse2(Node head) {

        Node p = null; // 当前操作节点
        Node h1 = null; //新的链表

        while (head != null) {
            p = head;
            head = head.getNext();
            p.setNext(h1);
            h1 = p; // h1前移，最后h1刚好指向head头节点
        }

        return h1;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{10, 20, 30, 40, 50, 60};

        // 创建单向链表
        Node head = NodeUtil.createLink(arr);

        // 输出单项链表
        System.out.println("逆置前: ");
        NodeUtil.printLink(head);

        // 逆置单向链表
        //head = inverse1(head);
        head = inverse2(head);

        // 输出单向链表
        System.out.println("逆置后: ");
        NodeUtil.printLink(head);

        // 释放链表
        NodeUtil.clearLink(head);

    }

}
