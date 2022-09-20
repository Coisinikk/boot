package com.zjy.service;

import com.zjy.dao.DriverDao;
import com.zjy.entity.Driver;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class DriverServiceImpl implements DriverService {
    @Resource
    private DriverDao driverDao;
    @Override
    public int driverAdd(Driver driver) {
        int num = driverDao.driverAdd(driver);
        return num;
    }

    @Override
    public List driverFindAll() {
        List<Driver> drivers = driverDao.driverFindAll();
        return drivers;
    }

    @Override
    public int driverDelete(Integer driver_id) {
        int num = driverDao.driverDelete(driver_id);
        return num;
    }
}
