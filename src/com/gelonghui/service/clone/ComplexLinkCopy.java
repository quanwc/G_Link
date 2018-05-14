package com.gelonghui.service.clone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gelonghui.entity.ComplexNode;

/**
 * 复杂链表的复制：
 *      有一个复杂链表，其结点除了有一个next指针指向下一个结点外，还有一个sibling指向链表中的任一结点或者NULL。
 *      完成对复杂链表的复制功能
 *
 * Created by quanwenchao
 * 2018/5/4 15:42:24
 */
public class ComplexLinkCopy {

    /**
     * 复制原始链表上的每一个结点，并用next链接起来
     * @param head
     * @return
     */
    public static ComplexNode connectLinkNext(ComplexNode head) {

        if (head == null) {
            return null;
        }

        ComplexNode h = null;
        ComplexNode t = null;
        ComplexNode loop = null; // 遍历原链表
        for (loop = head; loop != null; loop = loop.getNext()) {
            ComplexNode p = new ComplexNode(loop.getData());
            p.setNext(null);

            if (loop == head) {
                h = t = p;
            } else {
                t.setNext(p);
                t = p;
            }
        }

        return h;
    }



    /**
     * 复杂链表的复制：O(n2)
     *      step1：复制原始链表上的每一个结点，并用next链接起来；
     *      step2：设置每个节点的sibling节点。查找每个节点的sibling节点需从头遍历链表，故时间复杂度为O(n2)
     *
     * @param head 原链表
     * @return 复制后的链表
     */
    public static ComplexNode clone1(ComplexNode head) {

        // step1：复制原始链表上的每一个结点，并用next链接起来；
        ComplexNode h = connectLinkNext(head);

        List<Integer> list = new ArrayList<>();

        // step2：设置每个节点的sibling节点
        ComplexNode p = null;
        ComplexNode q = null;
        for (p = head; p != null; p = p.getNext()) {
            Integer i = 0;
            for (q = head; q != null; i++, q = q.getNext()) {
                if (p.getSibling() == q) {
                    System.out.println("q: " + q.getData());
                    list.add(i);
                    break;
                } else {
                    list.add(-1);
                }
            }

        }

        System.out.println(list.toString());

        return null;
    }


    /**
     * 方式2：借助hash表
     * @param head
     * @return
     */
    public static ComplexNode clone2(ComplexNode head) {
        if (head == null) {
            return null;
        }

        Map<ComplexNode, ComplexNode> map = new HashMap<ComplexNode, ComplexNode>();

        return null;
    }


    public static void main(String[] args) {

    }
}
