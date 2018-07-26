package com.quanwc.yangmchao;

public class LinkUtil {

	public static ComplexNode CloneNodes(ComplexNode head) {
		return cloneNode(head);
	}

	private static ComplexNode cloneNode(ComplexNode node) {
		if (node != null) {
			ComplexNode cloned = new ComplexNode("复制的" + node.getValue());
			cloned.setNextNode(cloneNode(node.getNextNode()));
			cloned.setSibling(node.getSibling());
			return cloned;
		}
		return null;
	}

	public static void printLink(ComplexNode head) {
		while (head != null) {
			String currentNodeValue = head.getValue();
			String nextNodeValue = head.getNextNode() == null ? "null" : head.getNextNode().getValue();
			String siblingNodeValue = head.getSibling() == null ? "null" : head.getSibling().getValue();
			System.out.println("c:" + currentNodeValue + " n:" + nextNodeValue + " s:" + siblingNodeValue);
			head = head.getNextNode();
		}

	}
}
