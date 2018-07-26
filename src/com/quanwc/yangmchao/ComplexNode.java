package com.quanwc.yangmchao;

public class ComplexNode {

	private String value;
	private ComplexNode nextNode;
	private ComplexNode Sibling;

	public ComplexNode(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ComplexNode getNextNode() {
		return nextNode;
	}

	public void setNextNode(ComplexNode nextNode) {
		this.nextNode = nextNode;
	}

	public ComplexNode getSibling() {
		return Sibling;
	}

	public void setSibling(ComplexNode sibling) {
		Sibling = sibling;
	}

}
