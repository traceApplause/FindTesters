package com.applause.findtesters.service.impl;

import com.applause.findtesters.repository.IDeviceRepository;
import com.applause.findtesters.service.IDeviceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements IDeviceService {
    private final IDeviceRepository deviceRepository;

    public DeviceServiceImpl(IDeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public List<String> getAllDevices() {
        return deviceRepository.getAllDevices();
    }
}
