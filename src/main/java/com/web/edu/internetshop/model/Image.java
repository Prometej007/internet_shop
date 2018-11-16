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

}


