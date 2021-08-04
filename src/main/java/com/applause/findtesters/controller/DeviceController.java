package com.applause.findtesters.controller;

import com.applause.findtesters.service.IDeviceService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/devices")
public class DeviceController {
    private final IDeviceService deviceService;

    public DeviceController(IDeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/all")
    public List<String> getAllDevices() {
        return deviceService.getAllDevices();
    }

}
