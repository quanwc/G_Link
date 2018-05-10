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

        Node q = null; // p的前驱
        Node p = head; // 遍历链表，用来指向当前节点
        while (p != null) {
            Node pNext = p.getNext(); // p的下一个节点
            Boolean needDelete = false; // 表示当前节点是否需要被删除
            if (p.getData() == pNext.getData()) {
                needDelete = true;
            }

            if (!needDelete) {
                q = p;
                p = p.getNext();
            } else {
                //Integer value = p.getData();
                //Node delP = p; // 删除节点
                //
                //while(delP != null && delP.getData() == value) {
                //    delP.setNext(pNext.getNext());
                //
                //    //delP
                //    delP = delP.getNext();
                //    pNext = delP.getNext();
                //}
                //if (p == head) {
                //
                //} else {
                //    q.setNext(delP);
                //}
                //
                //p = delP; // p后移


                Integer value = p.getData();
                for (; pNext != null && pNext.getData() != value; pNext = pNext.getNext());
                p = pNext;
                q.setNext(pNext);

            }
        }

        return head;
    }

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{10, 20, 20, 20, 40};

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
