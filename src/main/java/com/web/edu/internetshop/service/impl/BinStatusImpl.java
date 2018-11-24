package com.web.edu.internetshop.service.impl;

import com.web.edu.internetshop.model.buy.Bin;
import com.web.edu.internetshop.model.buy.BinStatus;
import com.web.edu.internetshop.model.enums.BinStatusType;
import com.web.edu.internetshop.model.utils.pattern.LastModification;
import com.web.edu.internetshop.repository.BinStatusRepository;
import com.web.edu.internetshop.service.BinService;
import com.web.edu.internetshop.service.BinStatusService;
import com.web.edu.internetshop.service.DictionaryService;
import com.web.edu.internetshop.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BinStatusImpl implements BinStatusService {

    @Autowired
    private BinStatusRepository binRepository;

    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private MailService mailService;
    @Autowired
    private BinService binService;

    @Override
    public BinStatus create(BinStatusType type) {
        return create(
                setDateCreate(
                        setDefaultAvailable(
                                setLastModification(
                                        new BinStatus().setType(type)
                                )
                        )
                )
        );
    }

    @Override
    public BinStatus create(BinStatusType type, Bin bin) {
        return create(new BinStatus().setType(type).setBin(bin));
    }

    @Override
    public BinStatus create(Bin bin) {
        return create(BinStatusType.NEW_ORDER, bin);
    }

    @Override
    public BinStatus create(BinStatusType type, Bin bin, String comment) {
        return create(new BinStatus().setType(type).setBin(bin).setComment(comment));
    }

    @Override
    public BinStatus create(BinStatusType type, Long bin, String comment) {
        return create(type, binService.findOne(bin), comment);
    }

    @Override
    public BinStatus create(BinStatusType type, String comment) {
        return create(new BinStatus().setType(type).setComment(comment));
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public BinStatus create(BinStatus binStatus) {
        BinStatus status = save(
                setLastModification(
                        setDefaultAvailable(
                                setDateCreate(
                                        binStatus
                                )
                        )
                )
        );
        mailService.sendInfoNewBinStatus(binStatus.getBin());
        return status;
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
