package com.quanwc.service.find;

import org.junit.Test;

import com.quanwc.entity.Node;
import com.quanwc.util.NodeUtil;

/**
 * Created by quanwenchao
 * 2018/5/5 17:00:12
 */
public class FindTwoLinkFirstCommonNodeTest {

    /**
     * 测试方法：
     * 构建有公共节点的两个单向链表
     *
     * 公共节点为最后一个节点：
     *  1 - 2 -3 - 4 \
     *                 7
     *         5 - 6 /
     * @return
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

        // step2、挂链
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node7);
        node5.setNext(node6);
        node6.setNext(node7);
        node7.setNext(null);

        System.out.println("测试输出链表数据: ");
        NodeUtil.printLink(node1);
        NodeUtil.printLink(node5);
        System.out.println("==============");

        Node result =  FindTwoLinkFirstCommonNode.findFirstCommonNode2(node1, node5);
        if (result == null) {
            System.out.println("两链表没有公共节点");
        } else {
            System.out.println("公共节点为: " + result.getData());
        }

    }


    /**
     * 测试方法：
     * 构建有公共节点的两个单向链表
     *
     * 第一个公共节点在链表中间
     *  1 - 2 - 3 \
     *              6 - 7 - 8
     *      4 - 5 /
     */
    @Test
    public void test3() {
        // step1、创建节点
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        // step2、挂链
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node6);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
        node7.setNext(node8);
        node8.setNext(null);


        System.out.println("测试输出链表数据: ");
        NodeUtil.printLink(node1);
        NodeUtil.printLink(node4);
        System.out.println("===================");

        Node result = FindTwoLinkFirstCommonNode.findFirstCommonNode3(node1, node4);
        if (result == null) {
            System.out.println("两链表没有公共节点");
        } else {
            System.out.println("公共节点为: " + result.getData());
        }
    }

}
