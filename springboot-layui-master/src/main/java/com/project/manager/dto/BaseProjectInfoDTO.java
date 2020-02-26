package com.project.manager.dto;

public class BaseProjectInfoDTO {

    private Integer id;

    private String projectName;

    private String projectCode;

    private Double projectBudgetAmount;

    private Double projectAccountAmount;

    private String projectManagerName;

    private String projectResearchers;

    private String projectResearchersName;

    private String createTime;

    private String expirationTime;

    private String finish;

    public String getProjectResearchersName() {
        return projectResearchersName;
    }

    public void setProjectResearchersName(String projectResearchersName) {
        this.projectResearchersName = projectResearchersName;
    }

    public String getProjectResearchers() {
        return projectResearchers;
    }

    public void setProjectResearchers(String projectResearchers) {
        this.projectResearchers = projectResearchers;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public Double getProjectBudgetAmount() {
        return projectBudgetAmount;
    }

    public void setProjectBudgetAmount(Double projectBudgetAmount) {
        this.projectBudgetAmount = projectBudgetAmount;
    }

    public Double getProjectAccountAmount() {
        return projectAccountAmount;
    }

    public void setProjectAccountAmount(Double projectAccountAmount) {
        this.projectAccountAmount = projectAccountAmount;
    }

    public String getProjectManagerName() {
        return projectManagerName;
    }

    public void setProjectManagerName(String projectManagerName) {
        this.projectManagerName = projectManagerName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(String expirationTime) {
        this.expirationTime = expirationTime;
    }

    @Override
    public String toString() {
        return "BaseProjectInfoDTO{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", projectCode='" + projectCode + '\'' +
                ", projectBudgetAmount=" + projectBudgetAmount +
                ", projectAccountAmount=" + projectAccountAmount +
                ", projectManagerName='" + projectManagerName + '\'' +
                ", projectResearchers='" + projectResearchers + '\'' +
                ", projectResearchersName='" + projectResearchersName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", expirationTime='" + expirationTime + '\'' +
                ", finish='" + finish + '\'' +
                '}';
    }
}
