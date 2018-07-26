package com.quanwc.entity;

/**
 * 复杂链表的节点类
 * Created by quanwenchao
 * 2018/5/6 19:22:38
 */
public class ComplexNode {
    /**
     * 数据域
     */
    private Integer data; // 以Integer为例，当然也可以用Object类型
    /**
     * next域
     */
    private ComplexNode next; // 用来指向下一个节点

    private ComplexNode sibling; //兄弟姊妹节点，指向链表中的任一结点或者NULL

    // 构造
    public ComplexNode() {

    }

    public ComplexNode(Integer data) {
        this.data = data;
    }

    public ComplexNode(ComplexNode next, ComplexNode sibling) {
        this.next = next;
        this.sibling = sibling;
    }

    // set、get
    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public ComplexNode getNext() {
        return next;
    }

    public void setNext(ComplexNode next) {
        this.next = next;
    }

    public ComplexNode getSibling() {
        return sibling;
    }

    public void setSibling(ComplexNode sibling) {
        this.sibling = sibling;
    }

    @Override
    public String toString() {
        return "ComplexNode{" +
                "data=" + data +
                ", next=" + next +
                ", sibling=" + sibling +
                '}';
    }
}
