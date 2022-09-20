package com.zjy.service;

import com.zjy.entity.Aircraft;
import org.springframework.stereotype.Service;

import java.util.List;
public interface AircraftService {
    //添加航空器
    int aircraftAdd(Aircraft aircraft);
    //查询航空器
    List aircraftFindAll();
    //删除航空器
    int aircraftDelete(Integer aircraft_id);
}
