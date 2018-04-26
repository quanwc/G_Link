package com.gelonghui.service.delete;

import com.gelonghui.entity.Node;
import com.gelonghui.util.NodeUtil;

import java.util.Scanner;

/**
 * 设head指向一个非空单向链表，数据域的值不重复
 *
 * 要求：
 *      任意输入一个key值，删除数据域值为key的节点
 * Created by quanwenchao
 * 2018/4/26 16:32:58
 */
public class DeleteKey {

    /**
     * 删除key值对应的节点
     * @param head 原链表
     * @param key 待删除的节点
     * @return 删除key值后的链表
     */
    public static Node deleteKey(Node head, Integer key) {
        if (head == null) {
            System.out.println("The Link is empty!");
            return null;
        }

        Node delp = null; // 当前(待删除)节点
        Node q = null; // 当前节点的前驱节点
        for (delp = head; delp != null; q = delp, delp = delp.getNext()) {
            if (delp.getData() == key) {
                if (delp == head) { // 如果是头节点
                    head = head.getNext(); // head后移
                } else {
                    q.setNext(delp.getNext()); // q.next = p.next
                }
            }
        }
        return head;
    }


    // 优化上面的方法：
    public static Node deleteKey2(Node head, Integer key) {
        if (head == null) {
            System.out.println("The Link is empty!");
            return null;
        }

        Node delp = null; // 当前(待删除)节点
        Node q = null; // 当前节点的前驱节点

        /*
         * 上面方法的for循环可以改进为一行代码，以";"结尾
         * 循环结束了，q、delp会指到相应的位置
         */
        for (delp = head; delp != null && delp.getData() != key; q=delp, delp=delp.getNext());

        if (delp == null) {
            System.out.print("\n未找到key");
        } else {
            if (delp == head) {
                head = head.getNext();
            } else {
                q.setNext(delp.getNext());
            }
        }

        return head;
    }

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{10, 20, 30, 40, 50};

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
        head = deleteKey(head, key);
        //head = deleteKey2(head, key);

        // 输出链表
        System.out.println("\nafter delete link: ");
        NodeUtil.printLink(head);

        // 释放链表
        NodeUtil.clearLink(head);

    }
}