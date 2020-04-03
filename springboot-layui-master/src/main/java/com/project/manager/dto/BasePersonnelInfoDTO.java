package com.project.manager.dto;

public class BasePersonnelInfoDTO {

    private Integer id;

    private String userName;

    private String userSex;

    private String userBirthday;

    private String userPoliticsStatus;

    private String userJoinTime;

    private String userGraduateInstitutions;

    private String userOrganization;

    private String userTeachingOffice;

    private String userHomeAddress;

    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserPoliticsStatus() {
        return userPoliticsStatus;
    }

    public void setUserPoliticsStatus(String userPoliticsStatus) {
        this.userPoliticsStatus = userPoliticsStatus;
    }

    public String getUserJoinTime() {
        return userJoinTime;
    }

    public void setUserJoinTime(String userJoinTime) {
        this.userJoinTime = userJoinTime;
    }

    public String getUserGraduateInstitutions() {
        return userGraduateInstitutions;
    }

    public void setUserGraduateInstitutions(String userGraduateInstitutions) {
        this.userGraduateInstitutions = userGraduateInstitutions;
    }

    public String getUserOrganization() {
        return userOrganization;
    }

    public void setUserOrganization(String userOrganization) {
        this.userOrganization = userOrganization;
    }

    public String getUserTeachingOffice() {
        return userTeachingOffice;
    }

    public void setUserTeachingOffice(String userTeachingOffice) {
        this.userTeachingOffice = userTeachingOffice;
    }

    public String getUserHomeAddress() {
        return userHomeAddress;
    }

    public void setUserHomeAddress(String userHomeAddress) {
        this.userHomeAddress = userHomeAddress;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BasePersonnelInfoDTO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBirthday='" + userBirthday + '\'' +
                ", userPoliticsStatus='" + userPoliticsStatus + '\'' +
                ", userJoinTime='" + userJoinTime + '\'' +
                ", userGraduateInstitutions='" + userGraduateInstitutions + '\'' +
                ", userOrganization='" + userOrganization + '\'' +
                ", userTeachingOffice='" + userTeachingOffice + '\'' +
                ", userHomeAddress='" + userHomeAddress + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
