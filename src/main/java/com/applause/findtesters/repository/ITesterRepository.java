package com.applause.findtesters.repository;

import com.applause.findtesters.model.Tester;

import java.util.List;

public interface ITesterRepository {
    List<String> getAllCountries();
    List<Tester> findTesters(String sql);
}
