package com.web.edu.internetshop.service;


import com.web.edu.internetshop.model.utils.pattern.Available;
import com.web.edu.internetshop.model.utils.pattern.DateCreate;
import com.web.edu.internetshop.model.utils.pattern.LastModification;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public interface GrudOperations<T extends DateCreate<T>> extends LastModificationService<T> {

    T create(T t);

    T save(T t);

    T findOne(T t);

    T findOne(Long id);

    List<T> findAll();

    T update(T t);

    default T setDateCreate(DateCreate<T> dateCreate){
        return dateCreate.setDateCreate(Timestamp.valueOf(LocalDateTime.now()));
    }
    default T setDefaultAvailable(Available<T> available){
        return available.setAvailable(false);
    }

}
