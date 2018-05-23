package com.ds.core.util;

import com.ds.core.dto.TreeNode;

public class BinaryTree {

    private TreeNode root;

    public void insert(int data) {
        if (root == null) {
            root = new TreeNode();
            root.setData(data);
            return;
        }

        if (root.getData() == data) {
            return;
        }
        TreeNode presentNode = root.getLeftChild();
        if (root.getData() < data) {
            presentNode = root.getRightChild();
        }
        while (presentNode != null) {
            if (presentNode.getData() == data) {
                return;
            }
            TreeNode leftChild = presentNode.getLeftChild();
            TreeNode rightChild = presentNode.getRightChild();
            if (leftChild == null && rightChild == null) {
                if (presentNode.getData() > data) {
                    TreeNode newNode = new TreeNode();
                    newNode.setData(data);
                    presentNode.setLeftChild(newNode);
                    return;
                }
                TreeNode newNode = new TreeNode();
                newNode.setData(data);
                presentNode.setRightChild(newNode);
                return;
            }
            if (leftChild != null && rightChild == null) {
                presentNode = leftChild;
            }
            if (leftChild == null) {
                presentNode = rightChild;
            }
        }

    }

    public void getTreeByPreOrderAndInOrder(String preOrder, String inOrder) throws Exception {

        if (preOrder.length() != inOrder.length()) {
            throw new Exception("Invalid input");
        }
        if (preOrder.length() == 0) {
            return;
        }

        TreeNode parent = new TreeNode();
        char rootChar = preOrder.charAt(0);
        parent.setData(rootChar);

        int index = inOrder.indexOf(rootChar);
        char rightChar = inOrder.charAt(index + 1);
        char leftChar = inOrder.charAt(index - 1);
        if (preOrder.indexOf(rightChar) == preOrder.length() - 1) {
            TreeNode rightChild = new TreeNode();
            rightChild.setData(rightChar);
            parent.setRightChild(rightChild);
            int[] inOrderIndexes = {index, index + 1};
            inOrder = removeChar(inOrder, inOrderIndexes);
            int[] preOrderIndexes = {0, preOrder.indexOf(rightChar)};
            preOrder = removeChar(preOrder, preOrderIndexes);
        }

        if (preOrder.indexOf(leftChar) == preOrder.charAt(1)) {
            TreeNode leftChild = new TreeNode();
            leftChild.setData(leftChar);
            parent.setLeftChild(leftChild);
            int[] inOrderIndexes = {index, index - 1};
            inOrder = removeChar(inOrder, inOrderIndexes);
            int[] preOrderIndexes = {0, preOrder.indexOf(leftChar)};
            preOrder = removeChar(preOrder, preOrderIndexes);
        }
        if (root == null) {
            root = parent;
            getTreeByPreOrderAndInOrder(preOrder, inOrder);
        }
        TreeNode leftChild = root.getLeftChild();
        TreeNode rightChild = root.getRightChild();
        TreeNode rootNode = root;
        while (rootNode != null) {
            if (leftChild == null && rightChild == null) {
                if (parent.getData() > root.getData()) {
                    rootNode.setRightChild(parent);
                    break;
                }
                if (parent.getData() < root.getData()) {
                    rootNode.setLeftChild(parent);
                    break;
                }
            }
            if (leftChild != null && rightChild == null) {
                rootNode.setRightChild(parent);
                break;
            }
            if (leftChild == null && rightChild != null) {
                rootNode.setLeftChild(parent);
                break;
            }
            if (leftChild != null && rightChild != null) {
                if (leftChild.getLeftChild() != null || leftChild.getRightChild() != null) {
                    rootNode = rootNode.getLeftChild();
                }
                if (rightChild.getLeftChild() != null || rightChild.getRightChild() != null) {
                    rootNode = rootNode.getRightChild();
                }
            }

        }
        getTreeByPreOrderAndInOrder(preOrder, inOrder);
    }

    private String removeChar(String input, int[] indexs) {
        StringBuilder sb = new StringBuilder(input);
        for (int index = 0; index <= indexs.length; index++) {
            sb.deleteCharAt(index);
        }
        return sb.toString();
    }

    public int getSuccessorInBT(int x) throws Exception {
        if (root == null) {
            throw new Exception("Tree is null");
        }

        TreeNode nodeX = getNodeX(x);
        TreeNode parentNode = null;
        if (nodeX.getLeftChild() == null && nodeX.getRightChild() == null) {
            parentNode = nodeX.getParent();
        }
        TreeNode nextNode = null;
        if (nodeX.getRightChild() != null) {
            nextNode = nodeX.getRightChild();
        }
        int smallestNode = 0;
        while (nextNode != null) {
            TreeNode leftNode = nextNode.getLeftChild();
            TreeNode rightNode = nextNode.getRightChild();
            if (leftNode == null && rightNode == null) {
                break;
            }
            if (leftNode != null) {
                nextNode = leftNode;
                smallestNode = leftNode.getData();
                continue;
            }
            nextNode = rightNode;
        }

        while (parentNode != null) {
            if (parentNode.getData() > x) {
                smallestNode = parentNode.getData();
                break;
            }
            parentNode = parentNode.getParent();
        }
        return smallestNode;
    }

    private TreeNode getNodeX(int x) {
        TreeNode nodeX = null;
        if (root.getData() == x) {
            nodeX = root;
            return nodeX;
        }
        if (root.getData() < x) {
            nodeX = root.getRightChild();
        }
        if (root.getData() > x) {
            nodeX = root.getLeftChild();
        }
        while (nodeX != null && nodeX != root) {
            if (nodeX.getData() == x) {
                break;
            }
            if (nodeX.getData() < x) {
                nodeX = nodeX.getRightChild();
            }
            if (nodeX.getData() > x) {
                nodeX = nodeX.getLeftChild();
            }
        }
        return nodeX;
    }
}
