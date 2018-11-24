package com.web.edu.internetshop.repository;

import com.web.edu.internetshop.model.buy.BinStatus;
import com.web.edu.internetshop.model.enums.BinStatusType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BinRepositoryTest {
    @Autowired
    private BinRepository binRepository;


    @Test
    public void adminFilter() {
        binRepository.adminFilter(BinStatusType.NEW_ORDER.ordinal()).forEach(bin -> {
            System.out.println(bin.getId());
        });
    }


}