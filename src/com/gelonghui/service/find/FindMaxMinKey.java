package com.gelonghui.service.find;

import com.gelonghui.entity.Node;
import com.gelonghui.util.NodeUtil;

/**
 * 设数据域值不重复，一次性通过，找出链表中的最大值和最小值
 * Created by quanwenchao
 * 2018/4/24 23:30:19
 */
public class FindMaxMinKey {

    /**
     * 设数据域值不重复，找出最大、最小值
     * @param head 链表头节点
     */
    public static void findMaxMin(Node head) {

        if (head == null) {
            System.out.println("The Link is empty!");
            return;
        }

        Node pMax = null; // 指向最大值节点
        Node pMin = null; // 指向最小值节点
        pMax = pMin = head;
        for (Node p = head; p != null; p = p.getNext()) {
            if (p.getData() > pMax.getData()) {
                pMax = p;
            }
            if (p.getData() < pMin.getData()) {
                pMin = p;
            }
        }

        System.out.println("pMax: " + pMax.getData());
        System.out.println("pMin: " + pMin.getData());
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{30, 20, 80, 40, 50};

        // 创建单向链表
        Node head = NodeUtil.createLink(arr);

        // 找出最大、最小值
        findMaxMin(head);

        // 释放链表
        NodeUtil.clearLink(head);

    }

}
