package com.web.edu.internetshop.model;

import com.web.edu.internetshop.model.utils.pattern.DateCreate;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(indexes = {@Index(columnList = "id"), @Index(columnList = "path")})
@Getter
@Setter
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

<<<<<<< HEAD
}


=======
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

    public Dictionary getAlt() {
        return alt;
    }

    public Image setAlt(Dictionary alt) {
        this.alt = alt;
        return this;
    }

    public Dictionary getTitle() {
        return title;
    }

    public Image setTitle(Dictionary title) {
        this.title = title;
        return this;
    }
}
>>>>>>> 72ce0eff488ab759da7cda3172a31deff0509b41
