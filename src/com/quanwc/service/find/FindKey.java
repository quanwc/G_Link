package com.quanwc.service.find;

import com.quanwc.entity.Node;
import com.quanwc.util.NodeUtil;

import java.util.Scanner;

/**
 * 设数据域的值不重复
 *      任意输入一个key值，在链表中查找key值。若找到，返回节点地址，若未找到，返回null
 * Created by quanwenchao
 * 2018/4/23 23:48:59
 */
public class FindKey {

    /**
     * 在链表中查找data域为key的节点
     * @param head 链表头节点
     * @param key key值
     * @return
     */
    public static Node findKey(Node head, Integer key) {

        if (head == null) {
            return null;
        }

        for (Node p = head; p != null; p = p.getNext()) {
            if (p.getData() == key) {
                return p;
            }
        }

        return null;
    }

    /**
     * 优化上面的方法
     * @param head
     * @param key
     * @return
     */
    public static Node findKey2(Node head, Integer key) {
        if (head == null) {
            System.out.println("The Link is empty");
            return null;
        }

        Node p = null;
        for (p=head; p != null && (p.getData() != key); p = p.getNext()); // 以";"结尾

        return p; // 直接返回p：找到了，返回p；没找到，p跑到链表的结尾null
    }

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{6, 2, 5, 8, 3, 4, 7, 9};

        // 逆向创建单向链表
        Node head = NodeUtil.re_createLink(arr);

        // 从控制台获取key值
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input key: ");
        Integer key = scanner.nextInt();

        // 查找key值
        Node p = findKey2(head, key);
        if (p == null) {
            System.out.println("没有找到该key值");
        } else {
            System.out.println("找到了key，值为: " + p.getData());
        }

        // 关闭资源
        scanner.close();

        // 释放单向链表
        NodeUtil.clearLink(head);

    }
}