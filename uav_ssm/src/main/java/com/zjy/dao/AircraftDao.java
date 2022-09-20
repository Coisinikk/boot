package com.zjy.dao;

import com.zjy.entity.Aircraft;


import java.util.List;

public interface AircraftDao {
    //添加航空器
    int aircraftAdd(Aircraft aircraft);
    //查询航空器
    List aircraftFindAll();
    //删除航空器
    int aircraftDelete(Integer aircraft_id);
}
