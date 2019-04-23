package com.yhjp.service.impl;

import com.yhjp.dao.TestDao;
import com.yhjp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;
    public String getTestData() {
        return testDao.getTestInfo();


    }
}
