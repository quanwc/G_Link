package com.quanwc.service.print;

import com.quanwc.entity.Node;
import com.quanwc.service.invere.InverseLink;
import com.quanwc.util.NodeUtil;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 设head指向一个非空单向链表
 *
 * 要求：
 * 		逆向输出链表节点数据域的值
 *
 * 实现：
 *      1、辅助栈
 *      2、递归
 *      3、岗哨end
 *      4、逆置后输出  缺点：会改变链表结构
 * Created by quanwenchao
 * 2018/4/24 20:03:57
 */
public class PrintLinkReverse {

    /**
     * 辅助栈
     * @param head 链表头节点
     */
    public static void print1(Node head) {

        if (head == null) {
            System.out.println("The Link is empty!");
            return;
        }

        // 创建栈
        Deque<Node> stack = new LinkedList<Node>();
        for (Node p = head; p != null; p = p.getNext()) {
            stack.push(p); // 入栈
        }

        // 遍历栈
        while (stack.size() > 0) {
            Node node = stack.pop();
            System.out.print(node.getData() + " ");
        }

    }


    /**
     * 递归：
     *      递归在本质上就是栈
     *      每访问到一个节点的时候，先递归输出它后面的节点，在输出该节点本身
     * @param head 链表头节点
     */
    public static void print2(Node head) {
        if (head == null) { // 递归的结束条件
            return;
        }

        print2(head.getNext()); //递归的调用，参数为head的next值
        System.out.print(head.getData() + " ");
    }


    /**
     * 岗哨end
     * @param head 岗哨的头节点
     */
    public static void print3(Node head) {
        if (head == null) {
            System.out.println("The Link is empty!");
            return;
        }

        Node p = null; // 遍历链表
        Node end = null; // 定义岗哨
        while (head != end) {
            for (p = head; p.getNext() != end; p = p.getNext());
            System.out.print(p.getData() + " ");
            end = p; // end前移
        }

    }


    /**
     * 逆置链表：
     *      将链表节点的指针反转过来，改变链表的方向，然后就可以逆向输出了
     * @param head 链表头节点
     */
    public static void print4(Node head) {
        if (head == null) {
            System.out.println("The Link is empty!");
            return;
        }

        head = InverseLink.inverse1(head); // 逆置链表
        NodeUtil.printLink(head); // 输出链表

    }


    public static void main(String[] args) {

        Integer[] arr = new Integer[]{10, 20, 30, 40, 50};

        // 创建单向链表
        Node head = NodeUtil.createLink(arr);

        //print1(head); // 方式1：辅助栈

        //print2(head); // 方式2：递归

        //print3(head); // 借助循环、岗哨

        print4(head);

        // 释放链表
        NodeUtil.clearLink(head);

    }

}
