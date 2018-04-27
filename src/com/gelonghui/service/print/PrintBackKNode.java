package com.gelonghui.service.print;

import com.gelonghui.entity.Node;
import com.gelonghui.util.NodeUtil;

import java.util.Scanner;

/**
 * 设head指向一个非空单向链表
 * 要求：
 * 		输出该链表中倒数第k个节点：（链表的尾节点是倒数第1个节点）
 *
 *  实现：
 *
 *
 * Created by quanwenchao
 * 2018/4/25 09:59:36
 */
public class PrintBackKNode {


    /**
     * 输出链表倒数第k个节点
     * @param head 原链表
     * @param k 对应倒数第k个节点
     */
    public static void printK(Node head, Integer k) {

    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{10, 20, 30, 40, 50};

        // 创建单向链表
        Node head = NodeUtil.createLink(arr);

        // 输出单向链表
        NodeUtil.printLink(head);

        // 从控制台获取K值
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input K number: ");
        Integer k = scanner.nextInt();

        // 输出倒数第K个节点
        printK(head, k);

        // 释放链表
        NodeUtil.clearLink(head);


    }

}
