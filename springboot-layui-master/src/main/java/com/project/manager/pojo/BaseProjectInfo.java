package com.project.manager.pojo;


import javax.persistence.*;
/**
 * 项目基本信息表
  */
@Table(name = "base_project_info")
public class BaseProjectInfo {

    /**
     * 项目ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 项目名称
     */
    @Column(name = "project_name")
    private String projectName;

    /**
     * 项目来源
     */
    @Column(name = "project_source")
    private String projectSource;

    /**
     * 预算总经费
     */
    @Column(name = "project_budget_amount")
    private Double projectBudgetAmount;

    /**
     * 到账经费
     */
    @Column(name = "project_account_amount")
    private Double projectAccountAmount;

    /**
     * 项目主导人id
     */
    @Column(name = "project_manager_id")
    private Integer projectManagerId;

    /**
     * 项目参研人员id
     */
    @Column(name = "project_researchers")
    private String projectResearchers;
    /**
     * 技术报告
     */
    @Column(name = "technical_report")
    private String technicalReport;

    /**
     * 总结报告
     */
    @Column(name = "final_report")
    private String finalReport;


    /**
     * 总结报告
     */
    @Column(name = "project_report")
    private String projectReport;

    /**
     * 节点数量
     */
    @Column(name = "node_count")
    private Integer nodeCount;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String createTime;

    /**
     * 更新时间
     */
    @Column(name = "expiration_time")
    private String expirationTime;

    /**
     * 开始时间
     */
    @Column(name = "start_time")
    private String startTime;

    /**
     * 1：有效
     0：无效
     */
    @Column(name = "if_finish")
    private String finish;

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

    public String getProjectSource() {
        return projectSource;
    }

    public void setProjectSource(String projectSource) {
        this.projectSource = projectSource;
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

    public String getProjectReport() {
        return projectReport;
    }

    public void setProjectReport(String projectReport) {
        this.projectReport = projectReport;
    }

    public Integer getProjectManagerId() {
        return projectManagerId;
    }

    public void setProjectManagerId(Integer projectManagerId) {
        this.projectManagerId = projectManagerId;
    }

    public String getProjectResearchers() {
        return projectResearchers;
    }

    public void setProjectResearchers(String projectResearchers) {
        this.projectResearchers = projectResearchers;
    }

    public String getTechnicalReport() {
        return technicalReport;
    }

    public void setTechnicalReport(String technicalReport) {
        this.technicalReport = technicalReport;
    }

    public String getFinalReport() {
        return finalReport;
    }

    public void setFinalReport(String finalReport) {
        this.finalReport = finalReport;
    }

    public Integer getNodeCount() {
        return nodeCount;
    }

    public void setNodeCount(Integer nodeCount) {
        this.nodeCount = nodeCount;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    @Override
    public String toString() {
        return "BaseProjectInfo{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", projectSource='" + projectSource + '\'' +
                ", projectBudgetAmount=" + projectBudgetAmount +
                ", projectAccountAmount=" + projectAccountAmount +
                ", projectManagerId=" + projectManagerId +
                ", projectResearchers='" + projectResearchers + '\'' +
                ", technicalReport='" + technicalReport + '\'' +
                ", finalReport='" + finalReport + '\'' +
                ", nodeCount=" + nodeCount +
                ", createTime='" + createTime + '\'' +
                ", expirationTime='" + expirationTime + '\'' +
                ", startTime='" + startTime + '\'' +
                ", finish='" + finish + '\'' +
                '}';
    }
}
