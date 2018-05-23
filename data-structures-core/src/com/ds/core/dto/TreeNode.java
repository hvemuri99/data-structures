package com.ds.core.dto;

import java.io.Serializable;

public class TreeNode implements Serializable {

    private static final long serialVersionUID = 7019009520698032767L;
    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;
    private TreeNode parent;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
}
