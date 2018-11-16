package com.web.edu.internetshop.model;

import com.web.edu.internetshop.model.utils.pattern.DateCreate;

import javax.persistence.*;

@Entity
@Table(indexes = {@Index(columnList = "id"), @Index(columnList = "path")})
public class Image extends DateCreate<Image> {

    private String path;
    @Column(columnDefinition = "LONGTEXT")
    private String content;

    @OneToOne
    private Dictionary alt;
    @OneToOne
    private Dictionary title;

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

    public void setPath(String path) {
        this.path = path;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Dictionary getAlt() {
        return alt;
    }

    public void setAlt(Dictionary alt) {
        this.alt = alt;
    }

    public Dictionary getTitle() {
        return title;
    }

    public void setTitle(Dictionary title) {
        this.title = title;
    }
}
