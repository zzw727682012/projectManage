package com.project.manager.dto;


public class ProjectSearchDTO {

    private String s_projectName;

    private String s_projectManagerName;

    private String s_projectUserName;

    private Integer s_dateRange;

    private String s_expirationTime;

    public String getS_projectName() {
        return s_projectName;
    }

    public void setS_projectName(String s_projectName) {
        this.s_projectName = s_projectName;
    }

    public String getS_projectManagerName() {
        return s_projectManagerName;
    }

    public void setS_projectManagerName(String s_projectManagerName) {
        this.s_projectManagerName = s_projectManagerName;
    }

    public String getS_projectUserName() {
        return s_projectUserName;
    }

    public void setS_projectUserName(String s_projectUserName) {
        this.s_projectUserName = s_projectUserName;
    }

    public Integer getS_dateRange() {
        return s_dateRange;
    }

    public void setS_dateRange(Integer s_dateRange) {
        this.s_dateRange = s_dateRange;
    }

    public String getS_expirationTime() {
        return s_expirationTime;
    }

    public void setS_expirationTime(String s_expirationTime) {
        this.s_expirationTime = s_expirationTime;
    }

    @Override
    public String toString() {
        return "ProjectSearchDTO{" +
                "s_projectName='" + s_projectName + '\'' +
                ", s_projectManagerName='" + s_projectManagerName + '\'' +
                ", s_projectUserName='" + s_projectUserName + '\'' +
                ", s_dateRange=" + s_dateRange +
                ", s_expirationTime='" + s_expirationTime + '\'' +
                '}';
    }
}
