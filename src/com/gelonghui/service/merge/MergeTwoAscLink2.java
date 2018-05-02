package com.gelonghui.service.merge;

import com.gelonghui.entity.Node;
import com.gelonghui.util.NodeUtil;

/**
 * 输入两个递增的单向链表
 * 要求：
 *      将两个非空升序链合并成一个升序链
 * 实现：
 *      不借助新的头节点，直接在原链表上进行操作比较
 *      分为两层循环实现：h1为基础链表不动，拆分h2链表
 *      i>: 外层循环遍历h2，每次取出第一个节点s，作为带插入节点，准备插入到h1中
 *      ii>: 内层循环遍历h1，将s插入到h1的合适位置处
 *      iii>: 最后h2为null，h2的节点也就都插入到了h1的链表中了，再将h1返回
 *
 * Created by quanwenchao
 * 2018/5/2 17:46:11
 */
public class MergeTwoAscLink2 {

    /**
     * 将两个升序链表，合并为一个升序链
     * @param head1 第一个升序链表
     * @param head2 第二个升序链表
     * @return 合并后的升序链表
     */
    public static Node merge(Node head1, Node head2) {

        // 必要判断
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        } else if (head1 == null && head2 == null) {
            return null;
        }

        Node q = null; // q的前驱
        Node p = null; // 遍历链表h1，用来指向h1链表中的当前节点
        Node s = null; // 再链表h2中，用来指向h2的剩余部分

        while (head2 != null) {
            s = head2;
            head2 = head2.getNext();

            for (p = head1; p != null && p.getData() < s.getData(); q = p, p = p.getNext());

            s.setNext(p);

            if (p == head1) {
                head1 = s;
            } else {
                q.setNext(s);
            }
        }

        return head1;
    }

    public static void main(String[] args) {
        Integer[] arr1 = new Integer[]{0, 3, 9, 30, 40, 50, 100};
        Integer[] arr2 = new Integer[]{2, 4, 6, 8, 10};

        Node head1 = NodeUtil.createLink(arr1);
        Node head2 = NodeUtil.createLink(arr2);

        System.out.println("链表head1: ");
        NodeUtil.printLink(head1);
        System.out.println("链表head2: ");
        NodeUtil.printLink(head2);

        // 合并两链表
        Node result = merge(head1, head2);
        if (result == null) {
            System.out.println("输入的两链表都为null，没有意义");
        } else {
            System.out.println("合并后的链表为: ");
            NodeUtil.printLink(result);
        }

        // 释放链表
        NodeUtil.clearLink(head1);
        NodeUtil.clearLink(head2);

    }
}
