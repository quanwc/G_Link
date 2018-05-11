package com.gelonghui.service.clone;

import com.gelonghui.entity.ComplexNode;
import org.junit.Test;

/**
 * Created by quanwenchao
 * 2018/5/6 19:13:04
 */
public class ComplexLinkCopyTest {

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
    @Test
    public void test1() {

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
        node4.setSibling(node2);
        node5.setNext(null);
        node5.setSibling(null);


        // 复制链表
        ComplexNode h = ComplexLinkCopy.clone1(node1);
        System.out.println(h);
    }

}
