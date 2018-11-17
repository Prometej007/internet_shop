package com.web.edu.internetshop.service.impl;

import com.web.edu.internetshop.model.PromoCode;
import com.web.edu.internetshop.model.buy.Bin;
import com.web.edu.internetshop.model.buy.ItemBin;
import com.web.edu.internetshop.model.utils.pattern.LastModification;
import com.web.edu.internetshop.repository.BinRepository;
import com.web.edu.internetshop.service.BinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BinServiceImpl implements BinService {

    @Autowired
    private BinRepository binRepository;

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Bin create(Bin bin) {
        return save(setLastModification(bin));
    }

    private BigDecimal price(Bin bin) {
        return null;
    }

    private BigDecimal price(ItemBin itemBin, PromoCode promoCode) {
        return null;
    }


    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Bin save(Bin bin) {
        return binRepository.save(bin);
    }

    @Override
    public Bin findOne(Bin bin) {
        return findOne(bin.getId());
    }

    @Override
    public Bin findOne(Long id) {
        return binRepository.findOne(id);
    }

    @Override
    public List<Bin> findAll() {
        return binRepository.findAll();
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Bin update(Bin bin) {
        return save(setLastModification(bin));
    }

    @Override
    public Bin lastModification(LastModification<Bin> lastModification) {
        return save(setLastModification(findOne(lastModification.getId())));
    }


}
