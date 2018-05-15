package com.gelonghui.service.delete;

import com.gelonghui.entity.Node;
import com.gelonghui.util.NodeUtil;

/**
 * 设head指向一个非空单向链表：
 * 		其数据域的值重复且有序，删除链表中的重复值节点
 *
 * 注：不保留重复值节点，eg：
 *     1 2 2 3 3 4  --> 1 4
 *
 * Created by quanwenchao
 * 2018/5/3 10:32:33
 */
public class DeleteDuplicateNodes2 {

    /**
     * 删除链表重复值节点，不做保留
     * @param head 原链表
     * @return 删除后的链表
     */
    public static Node delete(Node head) {

        if (head == null) {
            return null;
        }

        Node preNode = null; // pNode的前驱
        Node pNode = head; // 遍历链表，用来指向当前节点
        while (pNode != null && pNode.getNext() != null) {
            Node pNext = pNode.getNext(); // pNode的下一个节点
            Boolean needDelete = false; // 表示当前节点是否需要被删除
            if (pNode != null && pNode.getData() == pNext.getData()) {
                needDelete = true;
            }

            if (!needDelete) {
                preNode = pNode;
                pNode = pNode.getNext();
            } else {
                Integer value = pNode.getData();
                Node delP = pNode; // 指向待删除节点
                while (delP != null && delP.getData() == value) { // while循环结束，pNext指向第一个与pNode不重复的节点，然后q前去直接指上pNext，中间的与pNode重复的节点就会被删除了，不用一个next一个next删除，
                    pNext = delP.getNext();
                    delP = pNext;
                }

                if (preNode == null) { // 处理头节点
                    head = pNext;
                } else { // 找到
                    preNode.setNext(pNext);
                }

                pNode = pNext; // p后移，处理下一个节点
            }
        }

        return head;
    }

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{10, 20, 20, 30, 30, 40, 40};

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
