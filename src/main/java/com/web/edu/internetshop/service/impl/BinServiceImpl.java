package com.web.edu.internetshop.service.impl;

import com.web.edu.internetshop.model.PromoCode;
import com.web.edu.internetshop.model.buy.Bin;
import com.web.edu.internetshop.model.buy.BinStatus;
import com.web.edu.internetshop.model.buy.ItemBin;
import com.web.edu.internetshop.model.utils.pattern.LastModification;
import com.web.edu.internetshop.repository.BinRepository;
import com.web.edu.internetshop.service.*;
import com.web.edu.internetshop.service.utils.GenerateUuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Optional.ofNullable;

@Service
public class BinServiceImpl implements BinService {

    @Autowired
    private BinRepository binRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private GenerateUuid generateUuid;
    @Autowired
    private UserService userService;
    @Autowired
    private BinStatusService binStatusService;

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Bin create(Bin bin) {
        bin.setId(save(bin).getId());
        generateUuid.generateOrder(bin)
                .setPrice(price(bin));
        bin.setUser(userService.autoCreate(bin.getUser()));
        binStatusService.create(bin);
        return save(
                setLastModification(
                        setDateCreate(
                                setDefaultAvailable(
                                        bin
                                )
                        )
                )
        );
    }

    private BigDecimal price(Bin bin) {
        AtomicReference<BigDecimal> reference = new AtomicReference<>(new BigDecimal(0));

        bin.getItemBins().forEach(itemBin -> {
            reference.updateAndGet(bigDecimal -> bigDecimal.add(price(itemBin, bin.getPromoCode())));
        });

        return reference.get();
    }

    private BigDecimal price(ItemBin itemBin, PromoCode promoCode) {
        AtomicReference<BigDecimal> reference = new AtomicReference<>(new BigDecimal(0));

        itemBin.setPricePerOne(productService.findOne(itemBin.getProduct()).getPrice());

        if (ofNullable(promoCode).isPresent()) {
            itemBin.setPricePerOne(
                    itemBin.getPricePerOne()
                            .remainder(
                                    itemBin.getPricePerOne()
                                            .divide(new BigDecimal(100)
                                                    .multiply(new BigDecimal(promoCode.getDiscount())), 2, 0))
            );
        }
        reference.updateAndGet(bigDecimal -> bigDecimal.multiply(new BigDecimal(itemBin.getCount())));

        return reference.get().setScale(2, 0);
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
