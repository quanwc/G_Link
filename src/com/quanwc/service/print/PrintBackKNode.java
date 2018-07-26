package com.quanwc.service.print;

import com.quanwc.entity.Node;
import com.quanwc.util.NodeUtil;

import java.util.Scanner;

/**
 * 设head指向一个非空单向链表
 * 要求：
 * 		输出该链表中倒数第k个节点：（链表的尾节点是倒数第1个节点）
 *
 *  实现：
 *      1、遍历链表，统计链表中的节点个数；遍历链表，找到倒数第k个
 *         缺点：需要遍历链表两次
 *      2、遍历链表一次，通过两个指针实现
 *         i>： 第一个指针从头节点走k步，第二个指针保持不动；
 *         ii>：从第k步开始，第二个指针从头开始遍历
 *         iii>：两指针的距离是k-1，当第一个指针达到链表尾节点时，第二个指针(走在后面的)指针正好是倒数第k个节点
 *
 * Created by quanwenchao
 * 2018/4/25 09:59:36
 */
public class PrintBackKNode {


    /**
     * 方式1：遍历链表两次
     * @param head 原链表
     * @param k 对应倒数第k个节点
     * @return 倒数第k个节点
     */
    public static Node print1(Node head, Integer k) {
        if (head == null) {
            throw new RuntimeException("The Link is empty!");
        }
        if (k < 1) {
            throw new RuntimeException("计数是从1开始的，输入" + k + "没有实际意义");
        }

        // 统计链表长度
        Node p = head;
        Integer length = 0;
        while (p != null) {
            length += 1;
            p = p.getNext();
        }

        if (k > length) {
            System.out.println("链表长度为" + length + ", k值超出范围");
            throw new RuntimeException("k值出界");
        }

        // 输出倒数第k个节点
        int i = 0;
        Node pend = null;
        for (p = head; p != null; i++, p = p.getNext()) {
            if (i == length-k) {
                pend = p;
            }
        }
        return pend;
    }


    /**
     * 方式2：使用两个指针
     * @param head 原链表
     * @param k 对应倒数第k个节点
     * @return 倒数第k个节点
     */
    public static Node print2(Node head, Integer k) {

        if (head == null) {
            throw new RuntimeException("The link is empty!");
        }
        if (k < 1) {
            throw new RuntimeException("计数是从1开始的，输入" + k + "没有实际意义");
        }

        int i= 0;
        Node q = head;
        Node p = head;
        boolean flag = false;
        for (; p != null; i++, p=p.getNext()) { // 先让p跑k步
            if (i == k) {
                flag = true;
            }
            if (flag) { // q接着跑
                q = q.getNext();
            }
        }

        if (i < k) {
            System.out.println("链表长度为" + i +", k值超出范围");
            throw new RuntimeException("k值出界");
        }

        return q;
    }


    /**
     * 方式2：使用两个指针，对上面print2()方法的优化
     * @param head 原链表
     * @param k 对应倒数第k个节点
     * @return 倒数第k个节点
     */
    public static Node print3(Node head, Integer k) {

        if (head == null) {
            throw new RuntimeException("The Link is empty!");
        }
        if (k < 1) {
            throw new RuntimeException("计数是从1开始的，输入" + k + "没有实际意义");
        }

        Node pA = head;
        Node pB = null;
        for (int i = 0; i < k; i++) { // 先让pA跑k步
            if (pA != null) {
                pA = pA.getNext();
            } else {
                throw new RuntimeException("k值超出范围，链表长度小于k"); // 链表的length少于k
            }
        }

        pB = head; // pB接着跑
        while (pA != null) {
            pA = pA.getNext();
            pB = pB.getNext();
        }

        return pB;
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
        Node pend = print3(head, k);
        System.out.println("倒数第k个节点是: " + pend.getData());

        // 释放链表
        NodeUtil.clearLink(head);


    }

}
