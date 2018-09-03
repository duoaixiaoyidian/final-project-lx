package com.baizhi.entity;

import java.io.Serializable;
import java.util.Objects;

public class Chapter implements Serializable {
    private String id;
    private String title;
    private String duration;
    private String size;
    private String audioPath;
    private int album_id;

    public Chapter() {
    }

    public Chapter(String id, String title, String duration, String size, String audioPath, int album_id) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.size = size;
        this.audioPath = audioPath;
        this.album_id = album_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
    }

    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                ", size='" + size + '\'' +
                ", audioPath='" + audioPath + '\'' +
                ", album_id=" + album_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chapter chapter = (Chapter) o;
        return album_id == chapter.album_id &&
                Objects.equals(id, chapter.id) &&
                Objects.equals(title, chapter.title) &&
                Objects.equals(duration, chapter.duration) &&
                Objects.equals(size, chapter.size) &&
                Objects.equals(audioPath, chapter.audioPath);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, duration, size, audioPath, album_id);
    }
}
