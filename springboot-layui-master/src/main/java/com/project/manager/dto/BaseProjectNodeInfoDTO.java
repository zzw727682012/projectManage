package com.project.manager.dto;


public class BaseProjectNodeInfoDTO {

    private Integer id;

    private String projectName;

    private Integer projectId;

    private String expirationTime;

    private String projectNodeFinish;

    private String projectManagerName;

    private String projectNodeName;

    private String nodeAttachment;

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

    public String getProjectNodeFinish() {
        return projectNodeFinish;
    }

    public void setProjectNodeFinish(String projectNodeFinish) {
        this.projectNodeFinish = projectNodeFinish;
    }

    public String getProjectManagerName() {
        return projectManagerName;
    }

    public void setProjectManagerName(String projectManagerName) {
        this.projectManagerName = projectManagerName;
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

    @Override
    public String toString() {
        return "BaseProjectNodeInfoDTO{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", projectId=" + projectId +
                ", expirationTime='" + expirationTime + '\'' +
                ", projectNodeFinish='" + projectNodeFinish + '\'' +
                ", projectManagerName='" + projectManagerName + '\'' +
                ", projectNodeName='" + projectNodeName + '\'' +
                ", nodeAttachment='" + nodeAttachment + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
