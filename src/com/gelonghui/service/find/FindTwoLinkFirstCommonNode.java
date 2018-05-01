package com.gelonghui.service.find;

import com.gelonghui.entity.Node;
import com.gelonghui.util.NodeUtil;

import java.util.*;

/**
 * 输入两个单向链表，找出它们的第一个公共结点
 *
 * 分析：
 *      由于是单向链表，每个节点只有一个next域，因此从第一个公共节点开始，之后它们所有节点都是重合的，不可能再出现分叉
 *
 *
 * 实现：
 *      1、蛮力法：
 *              两层for循环遍历链表，判断两链表上的节点是否一样，时间复杂度为O(mn)，不建议使用
 *      2、辅助栈：
 *              分别把两个链表的结点放入两个栈里，这样两个链表的尾结点就位于两个栈的栈顶，接下来比较两个栈顶的结点是否相同。
 *          如果相同，则把栈顶弹出接着比较下一个栈顶，直到找到最后一个相同的结点。
 *      3、遍历一次链表
 *          得到两链表长度，并求出两个长度之差 -> 先在长链表上走几步，再同时遍历两链表 -> 得到第一个公共节点
 *
 * 参考：
 *      http://zhedahht.blog.163.com/blog/static/254111742008053169567/
 *
 * Created by quanwenchao
 * 2018/4/30 09:36:41
 */
public class FindTwoLinkFirstCommonNode {

    /**
     * 方式2：辅助栈
     * @param head1 第一个链表
     * @param head2 第二个链表
     * @return 第一个公共节点
     */
    public static Node findFirstCommonNode2(Node head1, Node head2) {

        Deque<Node> stack1 = new LinkedList<Node>();
        Deque<Node> stack2 = new LinkedList<Node>();

        // 先将两个链表节点放入栈里
        Node p1 = head1;
        Node p2 = head2;
        while (p1 != null) {
            stack1.push(p1);
            p1 = p1.getNext();
        }
        while (p2 != null) {
            stack2.push(p2);
            p2 = p2.getNext();
        }

        List<Node> list = new ArrayList<Node>();
        // 出栈
        while (stack1.size() >0 && stack2.size() > 0) {
            Node node1 = stack1.pop();
            Node node2 = stack2.pop();
            if (node1 == node2) {
                list.add(node1);
            } else {
                break;
            }
        }

        Node result = null;
        if (list.size() > 0) {
            result = list.get(list.size()-1);
        }
        return result;
    }

    /**
     * 方式3：遍历一次链表
     * @param head1 第一个链表
     * @param head2 第二个链表
     * @return 第一个公共节点
     */
    public static Node findFirstCommonNode3(Node head1, Node head2) {

        // step1：得到两个链表的长度
        Integer length1 = getLinkLength(head1);
        Integer length2 = getLinkLength(head2);
        Integer lengthDif = length1 - length2;

        Node pHeadLong = head1;
        Node pHeadShort = head2;
        if (length2 > length1) {
            lengthDif = length2 - length1;
            pHeadLong = head2;
            pHeadShort = pHeadShort;
        }

        // 先在长链表上走几步，再同时在两个链表上遍历
        for (int i = 0; i < lengthDif; ++i) {
            pHeadLong = pHeadLong.getNext();
        }

        while ((pHeadLong != null) &&
                (pHeadShort != null) &&
                (pHeadLong != pHeadShort)) {
            pHeadLong = pHeadLong.getNext();
            pHeadShort = pHeadShort.getNext();
        }

        // 得到第一个公共节点
        Node firstCommonNode = null;
        if (pHeadLong == pHeadShort) {
            firstCommonNode = pHeadLong;
        }

        return firstCommonNode;
    }


    /**
     * 统计链表长度
     * @param head 原链表
     * @return 链表长度
     */
    private static Integer getLinkLength(Node head) {

        Integer length = 0;
        Node p = head;

        while (p != null) {
            length++;
            p = p.getNext();
        }

        return length;
    }


    public static void main(String[] args) {

        test2();

        test3();

    }


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
    public static void test2() {

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

        Node result = findFirstCommonNode2(node1, node5);
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
    public static void test3() {
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

        Node result = findFirstCommonNode3(node1, node4);
        if (result == null) {
            System.out.println("两链表没有公共节点");
        } else {
            System.out.println("公共节点为: " + result.getData());
        }
    }

}
