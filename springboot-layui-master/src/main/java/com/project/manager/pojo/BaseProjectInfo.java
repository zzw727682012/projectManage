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
     * 项目类型
     */
    @Column(name = "project_type")
    private String projectType;

    /**
     * 项目来源
     */
    @Column(name = "project_source")
    private String projectSource;

    /**
     * 项目编号
     */
    @Column(name = "project_code")
    private String projectCode;

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
     * 项目合同
     */
    @Column(name = "project_accessory")
    private String projectAccessory;

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

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectSource() {
        return projectSource;
    }

    public void setProjectSource(String projectSource) {
        this.projectSource = projectSource;
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

    public String getProjectResearchers() {
        return projectResearchers;
    }

    public void setProjectResearchers(String projectResearchers) {
        this.projectResearchers = projectResearchers;
    }

    public Integer getProjectManagerId() {
        return projectManagerId;
    }

    public void setProjectManagerId(Integer projectManagerId) {
        this.projectManagerId = projectManagerId;
    }

    public String getProjectAccessory() {
        return projectAccessory;
    }

    public void setProjectAccessory(String projectAccessory) {
        this.projectAccessory = projectAccessory;
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
                ", projectType='" + projectType + '\'' +
                ", projectSource='" + projectSource + '\'' +
                ", projectCode='" + projectCode + '\'' +
                ", projectBudgetAmount=" + projectBudgetAmount +
                ", projectAccountAmount=" + projectAccountAmount +
                ", projectManagerId=" + projectManagerId +
                ", projectResearchers='" + projectResearchers + '\'' +
                ", projectAccessory='" + projectAccessory + '\'' +
                ", createTime='" + createTime + '\'' +
                ", expirationTime='" + expirationTime + '\'' +
                ", finish='" + finish + '\'' +
                '}';
    }
}
