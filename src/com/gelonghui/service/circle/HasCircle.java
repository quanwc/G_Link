package com.gelonghui.service.circle;

import com.gelonghui.entity.Node;

import java.util.ArrayList;
import java.util.List;

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
 * 判断是否相遇：
 *      因为是链表，fast的速度只能是slow的2倍、3倍...，肯定是整数倍
 *      当fast与slow相遇时，slow肯定没有走完链表，或者刚好走完一圈。
 *
 *      slow = next
 *      fast = next -> next
 *      slow跑next距离，fast跑2倍的next距离，如果某一时刻，slow和fast相遇了(地址相等)，则相遇
 *
 *
 * Created by quanwenchao
 * 2018/5/4 15:40:22
 */
public class HasCircle {

    /**
     * 判断链表是否有环：
     *     没有环，返回null
     *     有环返回环的入口节点，并计算环的长度
     *
     * @param head 原链表
     * @return
     */
    public static Node computeCircle(Node head) {

        if (head == null) {
            return null;
        }

        // step1：判断链表是否有环
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.getNext() != null) { // 循环结束条件：通过fast来判断
            slow = slow.getNext(); // slow跑next
            fast = fast.getNext().getNext(); // fast跑next的next
            if (fast == slow) { // 相遇，存在环
                break;
            }
        }

        // 如过没环，返回null
        if (fast == null || fast.getNext() == null) {
            return null;
        }



        // step2：判断环的入口，当然也可以使用下面的enterNode()方法
        /**
         * 碰撞点到连接点的距离 == 头指针到连接点的距离
         * 所以，计算环的入口：在头结点和相遇结点分别设一指针，同步前进，则最后一定相遇在环入口结点。
         */
        slow = head;
        while (slow != fast) { // slow和fast的相遇点就是环的入口
            slow = slow.getNext();
            fast = fast.getNext();
        }


        // step2：计算环的长度
        Integer length = 1;
        Node p = slow.getNext();
        while (p != slow) {
            p = p.getNext();
            length++;
        }
        System.out.println("环的长度: " + length);

        return slow;
    }


    /**
     * 判断环的入口：
     *      通过集合记录节点， 并判断下下一个点是否在这个集合
     *
     * @param head
     * @return
     */
    public static Node enterNode(Node head) {
        List<Node> list = new ArrayList<Node>();

        if (head == null) {
            return null;
        }

        Node result = null; // 返回值
        for (Node p = head; p != null; p = p.getNext()) {
            list.add(p);

            if (list.contains(p.getNext())) { // 如果集合中包含下一个元素，那么下一个元素就是入口
                System.out.println("入口： " + p.getNext().getData());
                result = p.getNext();
                break;
            }
        }

        return result;
    }


    public static void main(String[] args) {

        //test1(); // 有环

        //test2(); // 有环

        //test3(); // 无环

    }

}


