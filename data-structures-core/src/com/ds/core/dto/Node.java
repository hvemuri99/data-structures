package com.ds.core.dto;

import java.io.Serializable;

public class Node implements Serializable {

    private static final long serialVersionUID = 1987180148047224598L;
    private String data;
    private Node node;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}
