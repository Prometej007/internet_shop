package com.web.edu.internetshop.service.impl;

import com.web.edu.internetshop.model.Category;
import com.web.edu.internetshop.model.utils.pattern.LastModification;
import com.web.edu.internetshop.repository.CategoryRepository;
import com.web.edu.internetshop.service.CategoryService;
import com.web.edu.internetshop.service.DictionaryService;
import com.web.edu.internetshop.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private ImageService imageService;


    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Category create(Category category) {
        return save(
                setLastModification(
                        setDefaultAvailable(
                                setDateCreate(
                                        category
                                                .setImage(imageService.create(category.getImage()))
                                                .setDescription(dictionaryService.create(category.getDescription()))
                                                .setName(dictionaryService.create(category.getName()))

                                )
                        )
                )
        );
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findOne(Category category) {
        return categoryRepository.findOne(category.getId());
    }

    @Override
    public Category findOne(Long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Category update(Category category) {
        return save(setLastModification(category));
    }

    @Override
    public Category lastModification(LastModification<Category> lastModification) {
        return save(setLastModification(findOne(lastModification.getId())));
    }
}
