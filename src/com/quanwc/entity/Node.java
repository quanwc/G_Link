package com.quanwc.entity;

/**
 * 链表的Node类
 * Created by quanwenchao
 * 2018/4/21 17:57:04
 */
public class Node {
    /**
     * 数据域
     */
    private Integer data; // 以Integer为例，当然也可以用Object类型
    /**
     * next域
     */
    private Node next; // 用来指向下一个节点


    /**
     * 无参构造
     */
    public Node() {

    }

    public Node(Integer data) {
        this.data = data;
    }

    /**
     * 有参构造
     */
    public Node(Integer data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
