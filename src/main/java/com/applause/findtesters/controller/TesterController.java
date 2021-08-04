package com.applause.findtesters.controller;

import com.applause.findtesters.model.Tester;
import com.applause.findtesters.service.ITesterService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.json.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/testers")
public class TesterController {
    private final ITesterService testerService;

    public TesterController(ITesterService testerService) {
        this.testerService = testerService;
    }

    @GetMapping("/allCountries")
    public List<String> getAllCountries() {
        return testerService.getAllCountries();
    }

    @GetMapping(value="/findTesters")
    public List<Tester> findTesters(@RequestParam List<String> country, @RequestParam List<String> device) {

        return testerService.findTesters(country, device);
    }

}
