package com.web.edu.internetshop.dto.model.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class ImageAddRequestDTO {

    @NotNull
    @NotEmpty
    private String path;
    @NotNull
    @NotEmpty
    private String content;
    @NotNull
    @NotEmpty
    private String alt;
    @NotNull
    @NotEmpty
    private String title;

    public String getPath() {
        return path;
    }

    public ImageAddRequestDTO setPath(String path) {
        this.path = path;
        return this;
    }

    public String getContent() {
        return content;
    }

    public ImageAddRequestDTO setContent(String content) {
        this.content = content;
        return this;
    }

    public String getAlt() {
        return alt;
    }

    public ImageAddRequestDTO setAlt(String alt) {
        this.alt = alt;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ImageAddRequestDTO setTitle(String title) {
        this.title = title;
        return this;
    }
}
