package com.web.edu.internetshop.service.impl;

import com.web.edu.internetshop.model.PromoCode;
import com.web.edu.internetshop.model.buy.Bin;
import com.web.edu.internetshop.model.buy.BinStatus;
import com.web.edu.internetshop.model.buy.ItemBin;
import com.web.edu.internetshop.model.product.Product;
import com.web.edu.internetshop.model.utils.pattern.LastModification;
import com.web.edu.internetshop.repository.BinRepository;
import com.web.edu.internetshop.service.*;
import com.web.edu.internetshop.service.utils.GenerateUuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

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
    @Autowired
    private PromoCodeService promoCodeService;
    @Autowired
    private ItemBinService itemBinService;

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Bin create(Bin bin, Principal principal) {
        if (ofNullable(principal).isPresent())
            if (ofNullable(principal.getName()).isPresent())
                bin.getUser().setEmail(principal.getName());
        return create(bin);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Bin create(Bin bin) {
        bin.setId(save(new Bin()).getId());
        bin.setPromoCode(promoCodeService.findByCode(bin.getPromoCode()));
        generateUuid.generateOrder(bin)
                .setPrice(price(bin));
        if(!ofNullable(userService.findByEmail(bin.getUser())).isPresent())
        bin.setUser(userService.autoCreate(bin.getUser()));
        else
            bin.setUser(userService.findByEmail(bin.getUser()));
        bin.setItemBins(bin.getItemBins().stream().map(itemBin -> itemBinService.create(itemBin.setPricePerOne(price(itemBin.getProduct(), promoCodeService.findByCode(bin.getPromoCode()))), bin)).collect(toList()));
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

    @Override
    public BigDecimal getPrice(Bin bin) {
        return price(bin);
    }

    private BigDecimal price(Bin bin) {
        AtomicReference<BigDecimal> reference = new AtomicReference<>(new BigDecimal(0));

        bin.getItemBins().forEach(itemBin -> {
            reference.updateAndGet(bigDecimal -> bigDecimal.add(price(itemBin, promoCodeService.findByCode(bin.getPromoCode()))));
        });

        return reference.get();
    }

    private BigDecimal price(ItemBin itemBin, PromoCode promoCode) {
        AtomicReference<BigDecimal> reference = new AtomicReference<>(new BigDecimal(0));

        itemBin.setPricePerOne(productService.findOne(itemBin.getProduct()).getPrice());

        if (ofNullable(promoCode).isPresent()) {
            itemBin.setPricePerOne(
                    price(productService.findOne(itemBin.getProduct()), promoCode)
            );
        }
        reference.updateAndGet(bigDecimal -> bigDecimal.add(itemBin.getPricePerOne()));
        reference.updateAndGet(bigDecimal -> bigDecimal.multiply(new BigDecimal(itemBin.getCount())));

        return reference.get().setScale(2, 0);
    }

    private BigDecimal price(Product product, PromoCode promoCode) {
        if (ofNullable(promoCode).isPresent()) {
            if (promoCode.getProduct().stream().anyMatch(product1 -> product1.getId().equals(product.getId())))
                return product.getPrice()
                        .remainder(
                                product.getPrice()
                                        .divide(new BigDecimal(100)
                                                .multiply(new BigDecimal(promoCode.getDiscount())), 2, 0));
        }

        return product.getPrice();
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
