package com.gelonghui.service.delete;

import com.gelonghui.entity.Node;
import com.gelonghui.util.NodeUtil;

import java.util.Scanner;

/**
 * 设head指向一个非空单向链表，数据域的值不重复
 *
 * 要求：
 *      任意输入一个key值，删除数据域值为key的节点
 *      在O(1)时间删除链表结点
 * 实现：
 *      比如一个链表A->B->C->D->E->F->G，删除E节点，思路如下：
 *      i>： 将F节点data域的值，复制到E
 *      ii>：将E的next域指向F的next域
 *      iii>：删除F节点
 *
 *    补充：
 *      i>： 本质上真正删除的是E节点的下一节点F，因为我们可以很方便的得到要删除节点的下一节点
 *      ii>：把下一个节点的内容复制到需要删除的节点上，覆盖原有的内容，再把下一个节点删除，就相当于把需要删除的节点删除了，某种程度上有偷梁换柱的嫌疑
 *
 * Created by quanwenchao
 * 2018/4/25 18:55:30
 */
public class DeleteKey2 {

    /**
     * 构建问题，解决问题:
     *      在删除链表节点的方法deleteKey()中，需要传入"待删除的节点"作为参数
     *      i>： 我们可以传入key值，key值对应的节点就是待删除节点；不过前提链表key不重复，需要判断key是否在链表中存在
     *      ii>：在创建链表的时候，就让指针p随机指向链表的某个节点，作为待删除节点
     * 总的平均时间复杂度：[(n-1)*O(1) + O(n)]/n，结果还是O(n)
     * @param head 原链表
     * @return 删除节点后的链表
     */
    public static Node deleteKey(Node head, int key) {
        if (head == null) {
            throw new RuntimeException("The Link is empty!");
        }

        Node delp = null;
        for (delp = head; delp != null && delp.getData() != key; delp = delp.getNext());
        if (delp == null) { // 在链表中未找到key值
            throw new RuntimeException("Not found key!");
        }


        if (delp.getNext() != null) { // 要删除的节点不是尾节点

            Node pNext = delp.getNext();
            delp.setData(pNext.getData());
            delp.setNext(pNext.getNext());
            pNext = null;

        } else if (delp == head) { // 如果只有一个节点，删除头节点，也是尾节点
             delp = null;
             head = null;
        } else { // 链表中有多个节点，删除尾节点，此处特殊处理是因为，delp是尾节点，它的next为null，没法按照O(1)的思路来实现
            Node p = head;
            while (p.getNext() != delp) {
                p = p.getNext();
            }
            p.setNext(null);
        }

        return head;
    }

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{10, 20, 30, 40};

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

        // 输出链表
        System.out.println("after delete link: ");
        NodeUtil.printLink(head);

        // 释放链表
        NodeUtil.clearLink(head);

    }

}
