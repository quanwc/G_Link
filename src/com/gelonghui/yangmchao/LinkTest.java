package com.gelonghui.yangmchao;

public class LinkTest {

	public static void main(String[] args) {
		ComplexNode node1 = new ComplexNode("node1");
		ComplexNode node2 = new ComplexNode("node2");
		ComplexNode node3 = new ComplexNode("node3");
		ComplexNode node4 = new ComplexNode("node4");
		ComplexNode node5 = new ComplexNode("node5");

		// 挂链
		node1.setNextNode(node2);
		node1.setSibling(node3);
		node2.setNextNode(node3);
		node2.setSibling(node5);
		node3.setNextNode(node4);
		node3.setSibling(null);
		node4.setNextNode(node5);
		node4.setSibling(node2);
		node5.setNextNode(null);
		node5.setSibling(null);
		
		ComplexNode newNode1 = LinkUtil.CloneNodes(null);
		LinkUtil.printLink(node1);
		LinkUtil.printLink(newNode1);

	}

}
