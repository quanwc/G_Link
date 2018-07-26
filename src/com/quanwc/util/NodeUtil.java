package com.quanwc.util;

import com.quanwc.entity.Node;

/**
 * 链表工具类:
 *      包括：单向链表的创建(正向、逆向)、输出、释放
 *      正向、逆向创建链表：方向表示的是建链的过程
 * Created by quanwenchao
 * 2018/4/21 23:54:53
 */
public class NodeUtil {

    /**
     * 正向创建单向链表
     * @param arr 数组元素
     * @return 链表头节点
     */
    public static Node createLink(Integer[] arr) {
        if(arr == null || arr.length ==0) {
            return null;
        }

        Node head = null; //头节点
        Node t = null; // 方便挂链
        for (int i=0; i<arr.length; ++i) {
            Node p = new Node(arr[i], null);
            if (i ==0) {
                head = t = p; // 三个指针都指到头节点
            } else {
                t.setNext(p); // 挂链
                t = p; // 挪尾指针
            }
        }

        return head;
    }


    /**
     * 逆向创建单向链表
     * @param arr 数组元素
     * @return 链表头节点
     */
    public static Node re_createLink(Integer[] arr) {
        // 必要判断
        if (arr == null || arr.length == 0) {
            return null;
        }

        Node head = null; // 先让head指向null
        for (int i = arr.length-1; i >= 0; i--) {
            Node p = new Node(arr[i], head); // p的data域赋值为arr[i]，并且让p的next域指向head
            head = p;
        }
        return head;
    }

    /**
     * 输出单向链表
     * @param head 链表的头节点
     */
    public static void printLink(Node head) {
        if (head == null) {
            System.out.println("The Link is empty!");
            return;
        }
        for (Node p = head; p != null; p = p.getNext()) {
            System.out.print(p.getData().hashCode() + " ");
        }
        System.out.println();
    }


    /**
     * 释放单向链表，即就是：将链表节点赋值为null
     * @param head
     * @return 链表的头节点
     */
    public static Node clearLink(Node head) {
        if (head == null) {
            System.out.println("The Link is empty!");
            return null;
        }

        Node delp = null;
        while (head != null) {
            delp = head;
            head = head.getNext();
            delp = null;
        }
        return head;
    }


    /**
     * 测试链表是否创建成功：
     *      通过data域的值是否相等来判断
     * @param head 链表头节点
     */
    public static void testTrue(Node head) {
        if (head == null) {
            System.out.println("The Link is empty!");
            return;
        }


        Node q = head;
        Node p = q.getNext(); // 先让p指向q的next
        for (; p.getNext() != null; q = p, p = p.getNext()) {
            if (p.equals(q.getNext())) {
                System.out.println(true);
            }
        }
    }


    /**
     * 测试：单向链表的创建和输出
     * @param args
     */
    public static void main(String[] args) {

        Integer[] arr = new Integer[]{6, 2, 5, 8};

        // 创建单向链表
        Node head = NodeUtil.createLink(arr);

        // 测试链表是否创建(挂链)成功
        NodeUtil.testTrue(head);

        // 输出单向链表
        NodeUtil.printLink(head);


        // 释放单向链表
        NodeUtil.clearLink(head);

    }

}
