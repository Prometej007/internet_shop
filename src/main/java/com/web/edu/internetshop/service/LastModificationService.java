package com.web.edu.internetshop.service;


import com.web.edu.internetshop.model.utils.pattern.LastModification;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public interface LastModificationService<T extends LastModification<T>> {

     T lastModification(LastModification<T> lastModification);

    default T setLastModification(LastModification<T> lastModification){
        return lastModification.setLastModified(Timestamp.valueOf(LocalDateTime.now()));
    }

}
