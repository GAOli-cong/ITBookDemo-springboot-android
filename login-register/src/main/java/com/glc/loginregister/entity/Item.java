package com.glc.loginregister.entity;

public class Item {
    private Integer id;
    private String book_name;
    private String book_img;
    private String book_author;
    private String book_info;
    private String book_download;
    private String book_FileSize;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_img() {
        return book_img;
    }

    public void setBook_img(String book_img) {
        this.book_img = book_img;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getBook_info() {
        return book_info;
    }

    public void setBook_info(String book_info) {
        this.book_info = book_info;
    }

    public String getBook_download() {
        return book_download;
    }

    public void setBook_download(String book_download) {
        this.book_download = book_download;
    }

    public String getBook_FileSize() {
        return book_FileSize;
    }

    public void setBook_FileSize(String book_FileSize) {
        this.book_FileSize = book_FileSize;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", book_name='" + book_name + '\'' +
                ", book_img='" + book_img + '\'' +
                ", book_author='" + book_author + '\'' +
                ", book_info='" + book_info + '\'' +
                ", book_download='" + book_download + '\'' +
                ", book_FileSize='" + book_FileSize + '\'' +
                '}';
    }
}
