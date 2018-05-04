package com.gelonghui.service.circle;

import com.gelonghui.entity.Node;
import com.gelonghui.util.NodeUtil;

/**
 *
 * 设head指向一个非空单向链表，数据域的值不重复
 *
 * 要求：
 *      判断单向链表中是否有环，找到环的入口节点
 *
 * 分析：
 *      如果一个单链表中有环，用一个指针去遍历，永远不会结束，
 *      可以用两个指针，一个指针跑next，另一个指针跑next->next，如果存在环，那么当程序执行到某一状态时，两个指针会相遇(地址值相等)，如果链表没有环，程序会执行到a==NULL，程序结束。时间复杂度为O(n)。
 *
 *
 *  因为是链表，fast的速度只能是slow的2倍、3倍...，肯定是整数倍
 *  当fast与slow相遇时，slow肯定没有走完链表，或者刚好走完一圈。
 *
 *
 * Created by quanwenchao
 * 2018/5/4 15:40:22
 */
public class HasCircle {

    public static Node hasCircle(Node head) {

        if (head == null) {
            return null;
        }

        Node fast = head;
        Node slow = head;
        Node result = null;
        while (fast != null && fast.getNext() != null) { // 循环结束条件：通过fast来判断

            if (fast == slow) { // 相遇，存在环
                result = fast;
                break;
            }

            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }


        return result;
    }

    public static void main(String[] args) {


        // 有环
        test1();


    }


    /**
     * 测试方法：
     * 构建有环链表
     *
     *  1 - 2 - 3 - 4
     *          |   |
     *          5 - 6
     * @return
     */
    public static void test1() {

        // step1、创建节点
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        // step2、挂链
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node6);
        node6.setNext(node5);
        node5.setNext(node3);

        // 判断链表是否有环
        Node result = hasCircle(node1);
        if (result == null) {
            System.out.println("链表无环!");
        } else {
            System.out.println("链表有环: " + result.getData());
        }

    }

}


