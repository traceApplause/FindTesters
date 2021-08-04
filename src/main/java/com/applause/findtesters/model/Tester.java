package com.applause.findtesters.model;

import java.io.Serializable;

public class Tester implements Serializable {

    private static final long serialVersionUID = 1L;
    private String testerInfo;
    private Integer bugCount;

    public Tester(String testerInfo, Integer bugCount) {
        this.testerInfo = testerInfo;
        this.bugCount = bugCount;
    }

    public String getTesterInfo() {
        return testerInfo;
    }

    public void setTesterInfo(String testerInfo) {
        this.testerInfo = testerInfo;
    }

    public Integer getBugCount() {
        return bugCount;
    }

    public void setBugCount(Integer bugCount) {
        this.bugCount = bugCount;
    }
}
