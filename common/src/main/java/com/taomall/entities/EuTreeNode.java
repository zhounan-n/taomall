package com.taomall.entities;

/**
 * Created by zhoun on 2018/3/19.
 **/
public class EuTreeNode {

    private long id;
    private String text;
    private String state;

    public EuTreeNode() {
        super();
    }

    public EuTreeNode(long id, String text, String state) {
        this.id = id;
        this.text = text;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        System.out.println();
        return "";
    }
}
