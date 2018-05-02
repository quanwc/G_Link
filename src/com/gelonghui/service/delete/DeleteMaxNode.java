package com.gelonghui.service.delete;

import com.gelonghui.entity.Node;
import com.gelonghui.util.NodeUtil;

import java.util.Scanner;

/**
 * 设head指向一个非空单向链表，其数据域值不重复。删除链表中的最大值节点。
 * Created by quanwenchao
 * 2018/5/2 21:00:03
 */
public class DeleteMaxNode {

    /**
     * 删除链表最大值节点
     * @param head 原链表
     * @return 删除后的链表
     */
    public static Node deleteMaxNode(Node head) {

        if (head == null) {
            return null;
        }

        Node q = null; //遍历链表，指向当前节点的前驱节点
        Node p = null; //遍历链表，指向当前节点
        Node qmax = null; //最大值节点的前驱节点
        Node pmax = head; //最大值节点

        for (p = head; p != null; q = p, p = p.getNext()) {
            if (p.getData() > pmax.getData()) {
                pmax = p;
                qmax = q;
            }
        }

        if (pmax == head) { //如果最大值节点是头节点，head后移
            head = head.getNext();
        } else {
            qmax.setNext(pmax.getNext());
        }

        return head;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{120, 20, 80, 40};

        // 创建单向链表
        Node head = NodeUtil.createLink(arr);

        // 输出链表
        System.out.println("before delete link: ");
        NodeUtil.printLink(head);

        // 删除key值
        head = deleteMaxNode(head);

        // 输出链表
        System.out.println("after delete link: ");
        NodeUtil.printLink(head);

        // 释放链表
        NodeUtil.clearLink(head);

    }
}
