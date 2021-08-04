package com.applause.findtesters.service;

import com.applause.findtesters.model.Tester;

import java.util.List;

public interface ITesterService {
    List<String> getAllCountries();
    List<Tester> findTesters(List<String> countryList, List<String> deviceList);
}
