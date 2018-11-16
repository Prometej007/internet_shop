package com.web.edu.internetshop.model;

import com.web.edu.internetshop.model.utils.pattern.DateCreate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class Materials extends DateCreate<Materials> {

    @OneToOne
    private Dictionary name;
    @OneToOne
    private Dictionary description;
    @OneToOne
    private Image image;

    @Override
    public String toString() {
        return "Materials{" +
                "name=" + name +
                ", description=" + description +
                ", image=" + image +
                '}';
    }


}
