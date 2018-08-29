package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Banner implements Serializable {
    private int id;
    private String title;
    private String imgPath;
    private String description;
    private String status;
    private Date createDate;

    public Banner() {
    }

    public Banner(int id, String title, String imgPath, String description, String status, Date createDate) {
        this.id = id;
        this.title = title;
        this.imgPath = imgPath;
        this.description = description;
        this.status = status;
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banner banner = (Banner) o;
        return id == banner.id &&
                Objects.equals(title, banner.title) &&
                Objects.equals(imgPath, banner.imgPath) &&
                Objects.equals(description, banner.description) &&
                Objects.equals(status, banner.status) &&
                Objects.equals(createDate, banner.createDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, imgPath, description, status, createDate);
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}

