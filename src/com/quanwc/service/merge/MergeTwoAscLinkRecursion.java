package com.quanwc.service.merge;

import com.quanwc.entity.Node;
import com.quanwc.util.NodeUtil;

/**
 * 输入两个递增的单向链表
 * 要求：
 *      将两个非空升序链合并成一个升序链
 * 实现：
 *      对MergeTwoAscLink类中方法的扩充，合并的思想是一致的，只不过用递归的方式来实现了
 *
 * Created by quanwenchao
 * 2018/5/2 20:24:25
 */
public class MergeTwoAscLinkRecursion {

    public static Node merge(Node head1, Node head2) {

        // 递归的结束条件
        if (head1 == null) {
            return head2;
        } else if (head2 == null){
            return head1;
        }

        Node resultHead = null;
        /**
         * 先找到data域值小的节点resultHead，
         * 然后再递归调用，
         * 让比它大的节点进行比较，比较完成后，resultHead再指上来，那么合并后的链表就是升序的了
         */

        if (head1.getData() < head2.getData()) {
            resultHead = head1;
            resultHead.setNext(merge(head1.getNext(), head2));
        } else {
            resultHead = head2;
            resultHead.setNext(merge(head1, head2.getNext()));
        }

        return resultHead;
    }

    public static void main(String[] args) {
        Integer[] arr1 = new Integer[]{0, 3, 3, 30, 40, 50, 100};
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
