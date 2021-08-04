package com.applause.findtesters.service.impl;

import com.applause.findtesters.model.Tester;
import com.applause.findtesters.repository.ITesterRepository;
import com.applause.findtesters.service.ITesterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TesterServiceImpl implements ITesterService {

    private final ITesterRepository testerRepository;

    public TesterServiceImpl(ITesterRepository testerRepository) {
        this.testerRepository = testerRepository;
    }

    @Override
    public List<String> getAllCountries() {
        return testerRepository.getAllCountries();
    }

    @Override
    public List<Tester> findTesters(List<String> countryList, List<String> deviceList) {
        if(countryList.get(0).equals("ALL") && deviceList.get(0).equals("ALL")) return noFilter();
        else if(!countryList.get(0).equals("ALL") && !deviceList.get(0).equals("ALL")) return filterBoth(countryList, deviceList);
        else if(!countryList.get(0).equals("ALL") && deviceList.get(0).equals("ALL")) return filterCountry(countryList);
        else if(countryList.get(0).equals("ALL") && !deviceList.get(0).equals("ALL")) return filterDevice(deviceList);
        else return null;
    }

    private List<Tester> noFilter() {
        String sql = "SELECT t.firstName, t.lastName, t.country, count(b.bugId) as bugCount " +
                "FROM tester t " +
                "JOIN bug b ON t.testerId = b.testerId " +
                "JOIN device d ON b.deviceId = d.deviceId " +
                "GROUP BY b.testerId;";

        return testerRepository.findTesters(sql);
    }

    private List<Tester> filterBoth(List<String> countryList, List<String> deviceList) {
        StringBuilder countryFilter = new StringBuilder();
        for(int i=0; i<countryList.size(); i++) {
            countryFilter.append("'" + countryList.get(i) + "'");
            if(i != countryList.size() - 1) countryFilter.append(", ");
        }

        StringBuilder deviceFilter = new StringBuilder();
        for(int i=0; i<deviceList.size(); i++) {
            deviceFilter.append("'" + deviceList.get(i) + "'");
            if(i != deviceList.size() - 1) deviceFilter.append(", ");
        }

        String sql = "SELECT t.firstName, t.lastName, t.country, count(b.bugId) as bugCount " +
                "FROM tester t " +
                "JOIN bug b ON t.testerId = b.testerId " +
                "JOIN device d ON b.deviceId = d.deviceId " +
                "WHERE t.country IN (" + countryFilter + ") AND d.description IN (" + deviceFilter + ") " +
                "GROUP BY b.testerId;";

        return testerRepository.findTesters(sql);
    }

    private List<Tester> filterCountry(List<String> countryList) {

        StringBuilder countryFilter = new StringBuilder();
        for(int i=0; i<countryList.size(); i++) {
            countryFilter.append("'" + countryList.get(i) + "'");
            if(i != countryList.size() - 1) countryFilter.append(", ");
        }

        String sql = "SELECT t.firstName, t.lastName, t.country, count(b.bugId) as bugCount " +
                "FROM tester t " +
                "JOIN bug b ON t.testerId = b.testerId " +
                "JOIN device d ON b.deviceId = d.deviceId " +
                "WHERE t.country IN (" + countryFilter + ") " +
                "GROUP BY b.testerId;";

        return testerRepository.findTesters(sql);
    }

    private List<Tester> filterDevice(List<String> deviceList) {

        StringBuilder deviceFilter = new StringBuilder();
        for(int i=0; i<deviceList.size(); i++) {
            deviceFilter.append("'" + deviceList.get(i) + "'");
            if(i != deviceList.size() - 1) deviceFilter.append(", ");
        }

        String sql = "SELECT t.firstName, t.lastName, t.country, count(b.bugId) as bugCount " +
                "FROM tester t " +
                "JOIN bug b ON t.testerId = b.testerId " +
                "JOIN device d ON b.deviceId = d.deviceId " +
                "WHERE d.description IN (" + deviceFilter + ") " +
                "GROUP BY b.testerId;";

        return testerRepository.findTesters(sql);
    }

}
