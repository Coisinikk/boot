package com.zjy.service;

import com.zjy.entity.Driver;

import java.util.List;

public interface DriverService {
    //增加驾驶员
    int driverAdd(Driver driver);
    //查询驾驶员
    List driverFindAll();
    //删除驾驶员
    int driverDelete(Integer driver_id);
}
