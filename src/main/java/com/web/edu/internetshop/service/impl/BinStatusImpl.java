package com.web.edu.internetshop.service.impl;

import com.web.edu.internetshop.model.buy.BinStatus;
import com.web.edu.internetshop.model.utils.pattern.LastModification;
import com.web.edu.internetshop.repository.BinStatusRepository;
import com.web.edu.internetshop.service.BinStatusService;
import com.web.edu.internetshop.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class BinStatusImpl implements BinStatusService {

    @Autowired
    private BinStatusRepository binRepository;

    @Autowired
    private DictionaryService dictionaryService;

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public BinStatus create(BinStatus binStatus) {
        return save(
                setLastModification(
                        setDefaultAvailable(
                                setDateCreate(binStatus))));
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public BinStatus save(BinStatus binStatus) {
        return binRepository.save(binStatus);
    }

    @Override
    public BinStatus findOne(BinStatus binStatus) {
        return binRepository.findOne(binStatus.getId());
    }

    @Override
    public BinStatus findOne(Long id) {
        return binRepository.findOne(id);
    }

    @Override
    public List<BinStatus> findAll() {
        return binRepository.findAll();
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public BinStatus update(BinStatus binStatus) {
        return save(setLastModification(binStatus));
    }

    @Override
    public BinStatus lastModification(LastModification<BinStatus> lastModification) {
        return save(setLastModification(findOne(lastModification.getId())));
    }
}
