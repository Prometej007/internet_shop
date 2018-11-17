package com.web.edu.internetshop.dto.model;

import com.web.edu.internetshop.model.product.Dictionary;
import com.web.edu.internetshop.model.product.Image;

public class MaterialsDto {

    private DictionaryDto name;
    private DictionaryDto description;
    private Image image;

    public DictionaryDto getName() {
        return name;
    }

    public void setName(DictionaryDto name) {
        this.name = name;
    }

    public DictionaryDto getDescription() {
        return description;
    }

    public void setDescription(DictionaryDto description) {
        this.description = description;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
