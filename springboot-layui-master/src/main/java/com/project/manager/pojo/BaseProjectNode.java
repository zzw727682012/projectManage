package com.project.manager.pojo;


import javax.persistence.*;

/**
 * 项目进度表
 */
@Table(name = "base_project_node")
public class BaseProjectNode {

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

    @Column(name = "expiration_time")
    private String expirationTime;

    @Column(name = "project_node_finish")
    private String projectNodeFinish;

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

    @Column(name = "project_node_attachment")
    private String nodeAttachment;

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

    public String getNodeAttachment() {
        return nodeAttachment;
    }

    public void setNodeAttachment(String nodeAttachment) {
        this.nodeAttachment = nodeAttachment;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getProjectNodeFinish() {
        return projectNodeFinish;
    }

    public void setProjectNodeFinish(String projectNodeFinish) {
        this.projectNodeFinish = projectNodeFinish;
    }

    @Override
    public String toString() {
        return "BaseProjectNode{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", projectId=" + projectId +
                ", expirationTime='" + expirationTime + '\'' +
                ", projectNodeFinish='" + projectNodeFinish + '\'' +
                ", projectManagerId=" + projectManagerId +
                ", projectNodeName='" + projectNodeName + '\'' +
                ", nodeAttachment='" + nodeAttachment + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
