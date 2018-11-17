package com.web.edu.internetshop.service.impl;

import com.web.edu.internetshop.model.buy.ItemBin;
import com.web.edu.internetshop.model.utils.pattern.LastModification;
import com.web.edu.internetshop.repository.ItemBinRepository;
import com.web.edu.internetshop.service.DictionaryService;
import com.web.edu.internetshop.service.ItemBinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBinServiceImpl implements ItemBinService {

    @Autowired
    ItemBinRepository itemBinRepository;

    @Autowired
    private DictionaryService dictionaryService;

    @Override
    public ItemBin create(ItemBin itemBin) {
        return save(
                setLastModification(
                        setDefaultAvailable(setDateCreate(itemBin))));
    }

    @Override
    public ItemBin save(ItemBin itemBin) {
        return itemBinRepository.save(itemBin);
    }

    @Override
    public ItemBin findOne(ItemBin itemBin) {
        return itemBinRepository.findOne(itemBin.getId());
    }

    @Override
    public ItemBin findOne(Long id) {
        return itemBinRepository.findOne(id);
    }

    @Override
    public List<ItemBin> findAll() {
        return itemBinRepository.findAll();
    }

    @Override
    public ItemBin update(ItemBin itemBin) {
        return save(setLastModification(itemBin));
    }

    @Override
    public ItemBin lastModification(LastModification<ItemBin> lastModification) {
        return save(setLastModification(findOne(lastModification.getId())));
    }
}
