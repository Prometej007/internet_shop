package com.web.edu.internetshop.service.impl;

import com.web.edu.internetshop.model.PromoCode;
import com.web.edu.internetshop.model.utils.pattern.LastModification;
import com.web.edu.internetshop.repository.PromoCodeRepository;
import com.web.edu.internetshop.service.ProductService;
import com.web.edu.internetshop.service.PromoCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromoCodeServiceImpl implements PromoCodeService {


    @Autowired
    private PromoCodeRepository promoCodeRepository;

    @Autowired
    private ProductService productService;

    @Override
    public PromoCode findByCode(String code) {
        return promoCodeRepository.findByCode(code);
    }

    @Override
    public PromoCode findByCode(PromoCode promoCode) {
        return findByCode(promoCode.getCode());
    }

    @Override
    public Page<PromoCode> findAll(Pageable pageable) {
        return promoCodeRepository.findAll(pageable);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public PromoCode create(PromoCode promoCode) {
        return
                save(setLastModification(promoCode.setProduct(promoCode.getProduct().stream().map(product -> productService.findOne(product)).collect(Collectors.toList()))));
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public PromoCode save(PromoCode promoCode) {
        return promoCodeRepository.save(promoCode);
    }

    @Override
    public PromoCode findOne(PromoCode promoCode) {
        return findOne(promoCode.getId());
    }

    @Override
    public PromoCode findOne(Long id) {
        return promoCodeRepository.findOne(id);
    }

    @Override
    public List<PromoCode> findAll() {
        return promoCodeRepository.findAll();
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public PromoCode update(PromoCode promoCode) {
        return save(setLastModification(promoCode));
    }

    @Override
    public PromoCode lastModification(LastModification<PromoCode> lastModification) {
        return save(setLastModification(findOne(lastModification.getId())));
    }


}
