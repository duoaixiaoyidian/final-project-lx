package com.baizhi.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Album implements Serializable {
    private int id;
    private String title;
    private int count;
    private String corverImg;
    private double score;
    private String author;
    private String broadCast;
    private String brief;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    private String status;
    private List<Chapter> children;

    public Album() {
    }

    public Album(int id, String title, int count, String corverImg, double score, String author, String broadCast, String brief, Date publishDate, Date createDate, String status, List<Chapter> children) {
        this.id = id;
        this.title = title;
        this.count = count;
        this.corverImg = corverImg;
        this.score = score;
        this.author = author;
        this.broadCast = broadCast;
        this.brief = brief;
        this.publishDate = publishDate;
        this.createDate = createDate;
        this.status = status;
        this.children = children;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", count=" + count +
                ", corverImg='" + corverImg + '\'' +
                ", score=" + score +
                ", author='" + author + '\'' +
                ", broadCast='" + broadCast + '\'' +
                ", brief='" + brief + '\'' +
                ", publishDate=" + publishDate +
                ", createDate=" + createDate +
                ", status='" + status + '\'' +
                ", children=" + children +
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCorverImg() {
        return corverImg;
    }

    public void setCorverImg(String corverImg) {
        this.corverImg = corverImg;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadCast() {
        return broadCast;
    }

    public void setBroadCast(String broadCast) {
        this.broadCast = broadCast;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return id == album.id &&
                count == album.count &&
                Double.compare(album.score, score) == 0 &&
                Objects.equals(title, album.title) &&
                Objects.equals(corverImg, album.corverImg) &&
                Objects.equals(author, album.author) &&
                Objects.equals(broadCast, album.broadCast) &&
                Objects.equals(brief, album.brief) &&
                Objects.equals(publishDate, album.publishDate) &&
                Objects.equals(createDate, album.createDate) &&
                Objects.equals(status, album.status) &&
                Objects.equals(children, album.children);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, count, corverImg, score, author, broadCast, brief, publishDate, createDate, status, children);
    }
}
