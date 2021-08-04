package com.applause.findtesters.repository.impl;

import com.applause.findtesters.model.Tester;
import com.applause.findtesters.repository.ITesterRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TesterRepositoryImpl implements ITesterRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public TesterRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<String> getAllCountries() {
        return namedParameterJdbcTemplate.query(SELECT_ALL_COUNTRIES, (rs, rowNum) -> rs.getString("country"));
    }

    @Override
    public List<Tester> findTesters(String sql) {
        return namedParameterJdbcTemplate.query(sql, (rs, rowNum) -> new Tester(rs.getString("firstName")
                                                                                        + " " + rs.getString("lastName") + "("
                                                                                        + rs.getString("country") + ")"
                                                                                        ,rs.getInt("bugCount")));
    }

    //queries
    private static final String SELECT_ALL_COUNTRIES = "SELECT DISTINCT country FROM tester";


}
