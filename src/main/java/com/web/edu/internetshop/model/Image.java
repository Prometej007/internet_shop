package com.web.edu.internetshop.model;

import com.web.edu.internetshop.model.utils.pattern.DateCreate;

import javax.persistence.*;

@Entity
@Table(indexes = {@Index(columnList = "id"), @Index(columnList = "path")})
public class Image extends DateCreate<Image> {

    private String path;
    @Column(columnDefinition = "LONGTEXT")
    private String content;

    private String alt;
    private String title;

    @Override
    public String toString() {
        return "Image{" +
                "path='" + path + '\'' +
                ", content='" + content + '\'' +
                ", alt=" + alt +
                ", title=" + title +
                '}';
    }

    public String getPath() {
        return path;
    }

    public Image setPath(String path) {
        this.path = path;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Image setContent(String content) {
        this.content = content;
        return this;
    }

    public String getAlt() {
        return alt;
    }

    public Image setAlt(String alt) {
        this.alt = alt;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Image setTitle(String title) {
        this.title = title;
        return this;
    }

}
