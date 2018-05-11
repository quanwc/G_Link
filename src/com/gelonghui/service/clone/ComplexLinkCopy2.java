package com.gelonghui.service.clone;

import com.gelonghui.entity.ComplexNode;

/**
 * Created by quanwenchao
 * 2018/5/11 23:13:26
 */
public class ComplexLinkCopy2 {



    /**
     * 根据原链表的每个节点N创建对应的N'，并把N'链接在N的后面
     * @param head
     * @return
     */
    public static void cloneNodes(ComplexNode head) {


        ComplexNode p = head; // 遍历链表
        while (p != null) {
            ComplexNode pCloned = new ComplexNode();
            pCloned.setData(p.getData());
            pCloned.setNext(p.getNext());
            pCloned.setSibling(null);

            p.setNext(pCloned);
            p = pCloned.getNext();
        }

    }


    /**
     * 设置复制出来的sibling：
     *      如果原链表的节点N的sibling指向S，则它对应的复制节点N'的sibling指向S的下一节点S'
     * @param head
     */
    public static void connectSiblingNodes(ComplexNode head) {
        ComplexNode p = head; // 遍历原链表
        while (p != null) {
            ComplexNode pCloned = p.getNext(); // 遍历复制链表
            if (p.getSibling() != null) {
                pCloned.setSibling(p.getSibling().getNext());
            }
            p = pCloned.getNext();
        }
    }


    /**
     * 把长链表拆分为两个链表：
     *      把奇数位置的节点用next链接起来就是原始链表，把偶数位置的节点用next链接起来就是复制出来的链表
     * @param head
     * @return
     */
    public static ComplexNode splitComplexLink(ComplexNode head) {

        return null;
    }

    public static void main(String[] args) {


        /**
         * 创建复杂链表：
         *
         *       | <- -  - ^
         *       |         |
         *  1 -> 2 -> 3 -> 4 -> 5
         *  |    |    ^         ^
         *  |    |    |         |
         *  | - -| - ->         |
         *       | - - - - - - ->
         */

        // step1、创建节点
        ComplexNode node1 = new ComplexNode(1);
        ComplexNode node2 = new ComplexNode(2);
        ComplexNode node3 = new ComplexNode(3);
        ComplexNode node4 = new ComplexNode(4);
        ComplexNode node5 = new ComplexNode(5);


        // 挂链
        node1.setNext(node2);
        node1.setSibling(node3);
        node2.setNext(node3);
        node2.setSibling(node5);
        node3.setNext(node4);
        node3.setSibling(null);
        node4.setNext(node5);
        node4.setSibling(node2);
        node5.setNext(null);
        node5.setSibling(null);



        cloneNodes(node1);
        connectSiblingNodes(node1);
        splitComplexLink(node1);

    }

}
