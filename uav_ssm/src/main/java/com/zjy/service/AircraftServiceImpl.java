package com.zjy.service;

import com.zjy.dao.AircraftDao;
import com.zjy.entity.Aircraft;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AircraftServiceImpl implements AircraftService {
    @Resource
    private AircraftDao aircraftDao;
    @Override
    public int aircraftAdd(Aircraft aircraft) {
        int num = aircraftDao.aircraftAdd(aircraft);
        return num;
    }

    @Override
    public List aircraftFindAll() {
        List<Aircraft> aircrafts = aircraftDao.aircraftFindAll();
        return aircrafts;
    }

    @Override
    public int aircraftDelete(Integer aircraft_id) {
        int num = aircraftDao.aircraftDelete(aircraft_id);
        return num;
    }
}
