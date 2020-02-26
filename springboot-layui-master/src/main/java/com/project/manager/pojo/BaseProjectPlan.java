package com.project.manager.pojo;


import javax.persistence.*;

/**
 * 项目进度表
 */
@Table(name = "base_project_plan")
public class BaseProjectPlan {

    /**
     * ID
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
     * 项目id
     */
    @Column(name = "project_id")
    private Integer projectId;

    /**
     * 项目编号
     */
    @Column(name = "project_code")
    private String projectCode;


    @Column(name = "project_performance")
    private String projectPerformance;


    @Column(name = "expiration_time")
    private String expirationTime;

    /**
     * 项目主导人id
     */
    @Column(name = "project_manager_id")
    private Integer projectManagerId;

    /**
     * 项目结点名称
     */
    @Column(name = "project_node_name")
    private String projectNodeName;

    /**
     * 项目结点是否完成
     */
    @Column(name = "project_node_finish")
    private String projectNodeFinish;

    /**
     * 项目结点未完成原因
     */
    @Column(name = "project_node_delay_reason")
    private String projectNodeDelayReason;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String createTime;

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

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectPerformance() {
        return projectPerformance;
    }

    public void setProjectPerformance(String projectPerformance) {
        this.projectPerformance = projectPerformance;
    }

    public String getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(String expirationTime) {
        this.expirationTime = expirationTime;
    }

    public Integer getProjectManagerId() {
        return projectManagerId;
    }

    public void setProjectManagerId(Integer projectManagerId) {
        this.projectManagerId = projectManagerId;
    }

    public String getProjectNodeName() {
        return projectNodeName;
    }

    public void setProjectNodeName(String projectNodeName) {
        this.projectNodeName = projectNodeName;
    }

    public String getProjectNodeFinish() {
        return projectNodeFinish;
    }

    public void setProjectNodeFinish(String projectNodeFinish) {
        this.projectNodeFinish = projectNodeFinish;
    }

    public String getProjectNodeDelayReason() {
        return projectNodeDelayReason;
    }

    public void setProjectNodeDelayReason(String projectNodeDelayReason) {
        this.projectNodeDelayReason = projectNodeDelayReason;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BaseProjectPlan{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", projectId='" + projectId + '\'' +
                ", projectCode='" + projectCode + '\'' +
                ", projectPerformance='" + projectPerformance + '\'' +
                ", expirationTime='" + expirationTime + '\'' +
                ", projectManagerId='" + projectManagerId + '\'' +
                ", projectNodeName='" + projectNodeName + '\'' +
                ", projectNodeFinish='" + projectNodeFinish + '\'' +
                ", projectNodeDelayReason='" + projectNodeDelayReason + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
