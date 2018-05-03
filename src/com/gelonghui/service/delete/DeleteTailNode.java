package com.gelonghui.service.delete;

import com.gelonghui.entity.Node;
import com.gelonghui.util.NodeUtil;

/**
 * 设head指向一个非空单向链表，删除链表的尾节点
 * Created by quanwenchao
 * 2018/5/2 20:54:10
 */
public class DeleteTailNode {

    /**
     * 删除链表为节点
     * @param head 原链表
     * @return 删除后的链表
     */
    public static Node delete(Node head) {

        if (head == null) {
            return null;
        }

        Node q = null; // p的前驱
        Node p = null; // 遍历链表，指向当前节点

        if (head.getNext() == null) { //判断是不是只有头节点。只有头节点，则进行头删
            head = head.getNext();
        } else {
            for (p = head; p.getNext() != null; q = p, p = p.getNext());
            q.setNext(p.getNext());
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

        // 删除相同节点
        head = delete(head);

        // 输出链表
        System.out.println("after delete link: ");
        NodeUtil.printLink(head);

        // 释放链表
        NodeUtil.clearLink(head);
    }
}
