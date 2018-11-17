package com.web.edu.internetshop.service;

import com.web.edu.internetshop.model.buy.Bin;
import com.web.edu.internetshop.model.buy.BinStatus;
import com.web.edu.internetshop.model.enums.BinStatusType;

public interface BinStatusService extends GrudOperations<BinStatus> {
    BinStatus create(BinStatusType type);

    BinStatus create(BinStatusType type, Bin bin);
    BinStatus create(Bin bin);

    BinStatus create(BinStatusType type, String comment);

    BinStatus create(BinStatusType type, Bin bin, String comment);
}
