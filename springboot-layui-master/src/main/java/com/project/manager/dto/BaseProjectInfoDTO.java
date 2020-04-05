package com.project.manager.dto;

public class BaseProjectInfoDTO {

    private Integer id;

    private String projectName;

    private String projectSource;

    private Double projectBudgetAmount;

    private Double projectAccountAmount;

    private String projectManagerName;

    private String projectResearchers;

    private String projectResearchersName;

    private Integer nodeCount;

    private String startTime;

    private String expirationTime;

    private String finish;

    public String getProjectSource() {
        return projectSource;
    }

    public void setProjectSource(String projectSource) {
        this.projectSource = projectSource;
    }

    public String getProjectResearchersName() {
        return projectResearchersName;
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

    public String getProjectResearchers() {
        return projectResearchers;
    }

    public void setProjectResearchers(String projectResearchers) {
        this.projectResearchers = projectResearchers;
    }

    public void setProjectResearchersName(String projectResearchersName) {
        this.projectResearchersName = projectResearchersName;
    }

    public Integer getNodeCount() {
        return nodeCount;
    }

    public void setNodeCount(Integer nodeCount) {
        this.nodeCount = nodeCount;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(String expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    @Override
    public String toString() {
        return "BaseProjectInfoDTO{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", projectSource='" + projectSource + '\'' +
                ", projectBudgetAmount=" + projectBudgetAmount +
                ", projectAccountAmount=" + projectAccountAmount +
                ", projectManagerName='" + projectManagerName + '\'' +
                ", projectResearchers='" + projectResearchers + '\'' +
                ", projectResearchersName='" + projectResearchersName + '\'' +
                ", nodeCount=" + nodeCount +
                ", startTime='" + startTime + '\'' +
                ", expirationTime='" + expirationTime + '\'' +
                ", finish='" + finish + '\'' +
                '}';
    }
}
