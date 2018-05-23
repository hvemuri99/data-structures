package com.ds.core.util;

import com.ds.core.dto.Node;

public class LinkedList {

    private Node head;
    private Node tail;

    public void add(String data) {
        if (head == null) {
            head = new Node();
            head.setData(data);
            return;
        }

        if (tail == null) {
            Node input = new Node();
            input.setData(data);
            head.setNode(input);
            tail = input;
            return;
        }

        Node input = new Node();
        input.setData(data);
        tail.setNode(input);
        tail = input;
    }

    public void add(String data, int index) throws Exception {
        if (head == null && index != 0) {
            throw new Exception("Invalid index");
        }

        if (head == null) {
            head = new Node();
            head.setData(data);
            return;
        }

        if (tail == null && index > 1) {
            throw new Exception("Invalid index");
        }

        Node nextNode = head.getNode();
        Node prevNode = head;
        int currentIndex = 1;

        while (nextNode != null) {
            if (currentIndex == index) {
                Node input = new Node();
                input.setData(data);
                input.setNode(nextNode);
                prevNode.setNode(input);
                return;
            }
            prevNode = nextNode;
            nextNode = nextNode.getNode();
            currentIndex++;
        }
    }

    public void delete(String data) throws Exception {
        if (head == null) {
            throw new Exception("Invalid operation");
        }
        Node nextNode = head.getNode();
        Node prevNode = head;
        int currentIndex = 1;
        while (nextNode != null) {
            if (nextNode.getData().equalsIgnoreCase(data)) {
                nextNode.setNode(prevNode);
            }
        }
    }
}
