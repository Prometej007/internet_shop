package com.web.edu.internetshop.service.impl;

import com.web.edu.internetshop.model.product.Materials;
import com.web.edu.internetshop.model.utils.pattern.LastModification;
import com.web.edu.internetshop.repository.MaterialsRepository;
import com.web.edu.internetshop.service.DictionaryService;
import com.web.edu.internetshop.service.ImageService;
import com.web.edu.internetshop.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialsRepository materialsRepository;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private ImageService imageService;

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Materials create(Materials materials) {
        return save(
                setLastModification(
                        setDefaultAvailable(
                                setDateCreate(
                                        materials
                                                .setDescription(dictionaryService.create(materials.getDescription()))
                                                .setImage(imageService.create(materials.getImage()))
                                                .setName(dictionaryService.create(materials.getName()))
                                )
                        )
                )
        );
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Materials save(Materials materials) {
        return materialsRepository.save(materials);
    }

    @Override
    public Materials findOne(Materials materials) {
        return findOne(materials.getId());
    }

    @Override
    public Materials findOne(Long id) {
        return materialsRepository.findOne(id);
    }

    @Override
    public List<Materials> findAll() {
        return materialsRepository.findAll();
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Materials update(Materials materials) {
        return save(setLastModification(materials));
    }

    @Override
    public Materials lastModification(LastModification<Materials> lastModification) {
        return save(setLastModification(findOne(lastModification.getId())));
    }

    @Override
    public Page<Materials> findAll(Pageable pageable) {
        return materialsRepository.findAll(pageable);
    }
}
