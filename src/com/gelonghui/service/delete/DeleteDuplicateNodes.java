package com.gelonghui.service.delete;

import com.gelonghui.entity.Node;
import com.gelonghui.util.NodeUtil;

/**
 * 设head指向一个非空单向链表：
 * 		其数据域的值重复且有序，删除链表中的重复值节点
 *
 * 注：保留一位重复值节点，eg：
 *     1 2 2 3 3 4  --> 1 2 3 4
 *
 * Created by quanwenchao
 * 2018/5/3 10:25:23
 */
public class DeleteDuplicateNodes {

    public static Node delete(Node head) {

        if (head == null) {
            return null;
        }

        Node q = head; // p的前驱
        Node p = head.getNext(); // 遍历链表，用来指向当前节点
        while (p != null) {
            if (p.getData() == q.getData()) {
                q.setNext(p.getNext()); // 挂链删除p节点
                p = q.getNext(); //p后移，处理下一个节点
            } else {
                q = p;
                p = p.getNext();
            }
        }

        return head;
    }

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{1, 1, 2, 2, 3, 5, 5, 9};

        // 创建单向链表
        Node head = NodeUtil.createLink(arr);

        // 输出链表
        System.out.println("before delete link: ");
        NodeUtil.printLink(head);

        // 删除重复节点
        head = delete(head);

        // 输出链表
        System.out.println("after delete link: ");
        NodeUtil.printLink(head);

        // 释放链表
        NodeUtil.clearLink(head);

    }
}
