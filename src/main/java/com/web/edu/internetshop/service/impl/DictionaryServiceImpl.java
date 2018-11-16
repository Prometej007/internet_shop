package com.web.edu.internetshop.service.impl;

import com.web.edu.internetshop.model.Dictionary;
import com.web.edu.internetshop.model.utils.pattern.LastModification;
import com.web.edu.internetshop.repository.DictionaryRepository;
import com.web.edu.internetshop.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Dictionary create(Dictionary dictionary) {
        return save(
                setLastModification(
                        setDefaultAvailable(
                                setDateCreate(
                                        dictionary
                                )
                        )
                )
        );
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Dictionary save(Dictionary dictionary) {
        return dictionaryRepository.save(dictionary);
    }

    @Override
    public Dictionary findOne(Dictionary dictionary) {
        return findOne(dictionary.getId());
    }

    @Override
    public Dictionary findOne(Long id) {
        return dictionaryRepository.findOne(id);
    }

    @Override
    public List<Dictionary> findAll() {
        return dictionaryRepository.findAll();
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Dictionary update(Dictionary dictionary) {
        return save(setLastModification(dictionary));
    }

    @Override
    public Dictionary lastModification(LastModification<Dictionary> lastModification) {
        return save(setLastModification(findOne(lastModification.getId())));
    }

}
