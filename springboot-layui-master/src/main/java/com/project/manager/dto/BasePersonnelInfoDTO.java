package com.project.manager.dto;

public class BasePersonnelInfoDTO {

    private Integer id;

    private String userName;

    private String userSex;

    private String userBirthday;

    private String userPoliticsStatus;

    private String userJoinTime;

    private String userGraduateInstitutions;

    private String userPhoto;

    private String userFatherName;

    private String userFatherAge;

    private String userFatherJob;

    private String userMotherName;

    private String userMotherAge;

    private String userMotherJob;

    private String userHomeAddress;

    private String createTime;

    @Override
    public String toString() {
        return "BasePersonnelInfoDTO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userSex=" + userSex +
                ", userBirthday='" + userBirthday + '\'' +
                ", userPoliticsStatus='" + userPoliticsStatus + '\'' +
                ", userJoinTime='" + userJoinTime + '\'' +
                ", userGraduateInstitutions='" + userGraduateInstitutions + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                ", userFatherName='" + userFatherName + '\'' +
                ", userFatherAge='" + userFatherAge + '\'' +
                ", userFatherJob='" + userFatherJob + '\'' +
                ", userMotherName='" + userMotherName + '\'' +
                ", userMotherAge='" + userMotherAge + '\'' +
                ", userMotherJob='" + userMotherJob + '\'' +
                ", userHomeAddress='" + userHomeAddress + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }

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

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserFatherName() {
        return userFatherName;
    }

    public void setUserFatherName(String userFatherName) {
        this.userFatherName = userFatherName;
    }

    public String getUserFatherAge() {
        return userFatherAge;
    }

    public void setUserFatherAge(String userFatherAge) {
        this.userFatherAge = userFatherAge;
    }

    public String getUserFatherJob() {
        return userFatherJob;
    }

    public void setUserFatherJob(String userFatherJob) {
        this.userFatherJob = userFatherJob;
    }

    public String getUserMotherName() {
        return userMotherName;
    }

    public void setUserMotherName(String userMotherName) {
        this.userMotherName = userMotherName;
    }

    public String getUserMotherAge() {
        return userMotherAge;
    }

    public void setUserMotherAge(String userMotherAge) {
        this.userMotherAge = userMotherAge;
    }

    public String getUserMotherJob() {
        return userMotherJob;
    }

    public void setUserMotherJob(String userMotherJob) {
        this.userMotherJob = userMotherJob;
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
}
