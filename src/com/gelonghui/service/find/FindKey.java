package com.gelonghui.service.find;

import com.gelonghui.entity.Node;
import com.gelonghui.util.NodeUtil;

/**
 * 单向链表的创建和输出
 * Created by quanwenchao
 * 2018/4/23 13:59:59
 */
public class FindKey {
    public static void main(String[] args) {

        Integer[] arr = new Integer[]{6, 2, 5, 8};

        // 创建单向链表
        Node head = NodeUtil.createLink(arr);

        // 逆向创建单向链表
        //Node head1 = NodeUtil.re_createLink(arr);

        // 输出单向链表
        NodeUtil.printLink(head);

        // 释放单向链表
        NodeUtil.clearLink(head);

    }
}
