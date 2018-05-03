package com.gelonghui.service.delete;

import com.gelonghui.entity.Node;
import com.gelonghui.util.NodeUtil;

import java.util.Scanner;

/**
 * 设head指向一个非空单向链表，其数据域的值重复且无序。
 * 要求：
 *      任意输入一个key值，删除所有节点数据域值为key的节点
 * 实现：
 *      循环遍历，再删除。删除的时候注意区分头节点、中间节点
 *
 * Created by quanwenchao
 * 2018/5/2 20:51:41
 */
public class DeleteKeys {

    /**
     * 删除链表中key值对应的节点
     * @param head 原链表
     * @param key key值对应待删除节点
     * @return 删除后的节点
     */
    public static Node deleteKeys(Node head, Integer key) {

        if (head == null) {
            return null;
        }

        Node q = null;
        Node p = null;

        for (p = head; p != null; q = p, p = p.getNext()) {
            if (p.getData() == key) { //找到key
                if (p == head) { //如果是头节点
                    head = head.getNext();
                } else {
                    q.setNext(p.getNext());
                }
            }
        }

        return head;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{6, 2, 5, 8, 3, 5, 5, 9};

        // 创建单向链表
        Node head = NodeUtil.createLink(arr);

        // 输出链表
        System.out.println("before delete link: ");
        NodeUtil.printLink(head);

        // 从控制台获取key值
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input key: ");
        Integer key = scanner.nextInt();

        // 删除key值
        head = deleteKeys(head, key);

        // 输出链表
        System.out.println("after delete link: ");
        NodeUtil.printLink(head);

        // 释放链表
        NodeUtil.clearLink(head);

    }
}
