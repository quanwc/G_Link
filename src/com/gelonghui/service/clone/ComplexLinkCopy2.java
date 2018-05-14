package com.gelonghui.service.clone;

import com.gelonghui.entity.ComplexNode;

/**
 * 方法3：
 * Created by quanwenchao
 * 2018/5/11 23:13:26
 */
public class ComplexLinkCopy2 {



    /**
     * 根据原链表的每个节点N创建对应的N'，并把N'链接在N的后面
     * @param pHead
     * @return
     */
    public static ComplexNode cloneNodes(ComplexNode pHead) {

        ComplexNode pNode = pHead; // 遍历链表
        while (pNode != null) {
            ComplexNode pCloned = new ComplexNode();
            pCloned.setData(pNode.getData());
            pCloned.setNext(pNode.getNext());
            pCloned.setSibling(null);

            pNode.setNext(pCloned);
            pNode = pCloned.getNext();
        }
        return pHead;
    }


    /**
     * 设置复制出来的sibling：
     *      如果原链表的节点N的sibling指向S，则它对应的复制节点N'的sibling指向S的下一节点S'
     * @param pHead
     */
    public static ComplexNode connectSiblingNodes(ComplexNode pHead) {
        ComplexNode pNode = pHead; // 遍历原链表
        while (pNode != null) {
            ComplexNode pCloned = pNode.getNext(); // 遍历复制链表
            if (pNode.getSibling() != null) {
                pCloned.setSibling(pNode.getSibling().getNext());
            }
            pNode = pCloned.getNext();
        }

        return pHead;
    }


    /**
     * 把长链表拆分为两个链表：
     *      把奇数位置的节点用next链接起来就是原始链表，把偶数位置的节点用next链接起来就是复制出来的链表
     * @param pHead
     * @return
     */
    public static ComplexNode splitComplexLink(ComplexNode pHead) {


        ComplexNode pNode = pHead; // 遍历原链表
        ComplexNode pClonedHead = null; // 复制链表的头节点
        ComplexNode pClonedNode = null; //遍历复制的链表


        if (pNode != null) { // 初始化链表指针
            pClonedNode = pClonedHead = pNode.getNext();
            pNode.setNext(pClonedNode.getNext());
            pNode = pNode.getNext();
        }

        while (pNode != null) {
            pClonedNode.setNext(pNode.getNext());
            pClonedNode = pClonedNode.getNext();

            pNode.setNext(pClonedNode.getNext());
            pNode = pNode.getNext();
        }

        return pClonedHead;
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
        //node4.setSibling(node2);
        node4.setSibling(node2);
        node5.setNext(null);
        node5.setSibling(null);



        ComplexNode pHead = cloneNodes(node1);
        pHead = connectSiblingNodes(pHead);
        ComplexNode pClonedHead = splitComplexLink(pHead);
        System.out.println("pClonedHead: " + pClonedHead.getData());

    }

}
