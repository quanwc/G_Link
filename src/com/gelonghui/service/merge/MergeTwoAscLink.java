package com.gelonghui.service.merge;

import com.gelonghui.entity.Node;
import com.gelonghui.util.NodeUtil;

/**
 * 输入两个递增的单向链表
 * 要求：
 *      将两个非空升序链合并成一个升序链
 * 实现：
 *      也就是正向建链的过程
 *      i>: 创建空的链表头节点h，作为新的链表的头
 *      ii>: 同时遍历两个链表，在两个链表上找到较小的节点，挂链(正向建链)
 *      iii>: 最后处理剩余的部分
 *      iv>: 返回头指针h
 *
 * Created by quanwenchao
 * 2018/5/2 9:30:28
 */
public class MergeTwoAscLink {

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

        Node h = null; // 合并后链表的头节点
        Node p = null; // 遍历两个链表，指向两个链表中头节点较小的那个节点
        Node t = null; // 用来挂链

        while (head1 != null && head2 != null) {
            // step1: 先让p指向两链表中头节点较小的那个节点
            if (head1.getData() > head2.getData()) {
                p = head2;
                head2 = head2.getNext();
            } else {
                p = head1;
                head1 = head1.getNext();
            }

            // step2: 挂链
            if (h == null) {
                h = t = p;
            } else {
                t.setNext(p);
                t = p;
            }

        }

        // step3: 处理剩余部分，先让p指向不为null的链表上
        if (head1 == null) {
            p = head2;
        } else {
            p = head1;
        }

        // step4: 将剩余链表部分挂到新的链表中
        t.setNext(p);

        return h;
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
