package com.applause.findtesters.repository.impl;

import com.applause.findtesters.repository.IDeviceRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeviceRepositoryImpl implements IDeviceRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DeviceRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<String> getAllDevices() {
        return namedParameterJdbcTemplate.query(SELECT_ALL_DEVICES, (rs, rowNum) -> rs.getString("description"));
    }

    //queries
    private static final String SELECT_ALL_DEVICES = "SELECT description FROM device";
}
