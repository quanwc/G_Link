package com.quanwc.service.circle;

import org.junit.Test;

import com.quanwc.entity.Node;
import com.quanwc.util.NodeUtil;

/** HasCircle测试类
 * Created by quanwenchao
 * 2018/5/5 16:00:35
 */
public class HasCircleTest {

    // 创建HasCircle类型的对象
    private HasCircle obj = new HasCircle();


    /**
     * 计算环的入口、长度， HasCircle类中computeCircle()方法
     *
     * 构建有环链表：
     *  1 -> 2 -> 3 -> 4
     *            |    |
     *            6 <- 5
     *
     */
    @Test
    public void test1() {

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
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node3);

        // 判断链表是否有环
        Node result = HasCircle.computeCircle(node1);

        if (result == null) {
            System.out.println("链表无环!");
        } else {
            System.out.println("链表有环: " + result.getData());
        }

    }


    /**
     * 计算环的入口、长度， HasCircle类中computeCircle()方法
     *
     * 构建有环链表:
     *  1 -> 2 -> 3 -> 4
     *       |         |
     *       9         5
     *       |         |
     *       8 <- 7 <- 6
     *
     */
    @Test
    public void test2() {

        // step1、创建节点
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

        // step2、挂链
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
        node7.setNext(node8);
        node8.setNext(node9);
        node9.setNext(node2);

        // 判断链表是否有环
        Node result = obj.computeCircle(node1);
        if (result == null) {
            System.out.println("链表无环!");
        } else {
            System.out.println("链表有环: " + result.getData());
        }

    }



    /**
     * 计算环的入口、长度， HasCircle类中computeCircle()方法
     *
     * 构建单向链表，没有环：
     *  10 -> 20 -> 30 -> 40 -> 50
     *
     */
    @Test
    public void test3() {

        Integer[] arr = new Integer[]{10, 20, 30, 40, 50};

        Node head = NodeUtil.createLink(arr);

        // 判断链表是否有环
        Node result = HasCircle.computeCircle(head);
        if (result == null) {
            System.out.println("链表无环!");
        } else {
            System.out.println("链表有环: " + result.getData());
        }
    }


    /**
     * 计算环的入口， HasCircle类中enterNode()方法
     *
     * 构建有环链表：
     *  1 -> 2 -> 3 -> 4
     *            |    |
     *            6 <- 5
     */
    @Test
    public void test5() {
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
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node3);

        // 判断链表是否有环
        Node result = obj.enterNode(node1);
        if (result == null) {
            System.out.println("链表无环!");
        } else {
            System.out.println("链表有环，入口: " + result.getData());
        }
    }


    /**
     * 计算环的入口， HasCircle类中enterNode()方法
     *
     * 构建有环链表:
     *  1 -> 2 -> 3 -> 4
     *       |         |
     *       9         5
     *       |         |
     *       8 <- 7 <- 6
     */
    @Test
    public void test6() {
        // step1、创建节点
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

        // step2、挂链
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
        node7.setNext(node8);
        node8.setNext(node9);
        node9.setNext(node2);

        // 判断链表是否有环
        Node result = obj.enterNode(node1);
        if (result == null) {
            System.out.println("链表无环!");
        } else {
            System.out.println("链表有环，入口: " + result.getData());
        }

    }


    /**
     * 计算环的入口、长度， HasCircle类中computeCircle()方法
     *
     * 构建单向链表，没有环：
     *  10 -> 20 -> 30 -> 40 -> 50
     *
     */
    @Test
    public void test7() {

        Integer[] arr = new Integer[]{10, 20, 30, 40, 50};

        Node head = NodeUtil.createLink(arr);

        // 判断链表是否有环
        Node result = HasCircle.enterNode(head);
        if (result == null) {
            System.out.println("链表无环!");
        } else {
            System.out.println("链表有环: " + result.getData());
        }
    }


}
