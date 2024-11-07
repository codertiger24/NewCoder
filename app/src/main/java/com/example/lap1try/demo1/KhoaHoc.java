package com.example.lap1try.demo1;

public class KhoaHoc {
    private int id;
    private String title;
    private String content;
    private String date;
    private int type;

    public KhoaHoc(int id, String title, String content, String date, int type) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.type = type;
    }

    public KhoaHoc() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
