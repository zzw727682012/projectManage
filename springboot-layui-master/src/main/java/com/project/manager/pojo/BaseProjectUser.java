package com.project.manager.pojo;


import javax.persistence.*;
/**
 * 项目和人员关联表
 */
@Table(name = "base_project_user")
public class BaseProjectUser {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_sex")
    private String userSex;

    @Column(name = "user_birthday")
    private String userBirthday;

    @Column(name = "user_politics_status")
    private String userPoliticsStatus;

    @Column(name = "user_join_time")
    private String userJoinTime;

    @Column(name = "user_graduate_institutions")
    private String userGraduateInstitutions;

    @Column(name = "user_photo")
    private String userPhoto;

    @Column(name = "user_father_name")
    private String userFatherName;

    @Column(name = "user_father_age")
    private String userFatherAge;

    @Column(name = "user_father_job")
    private String userFatherJob;

    @Column(name = "user_mother_name")
    private String userMotherName;

    @Column(name = "user_mother_Age")
    private String userMotherAge;

    @Column(name = "user_mother_job")
    private String userMotherJob;

    @Column(name = "user_home_address")
    private String userHomeAddress;

    @Column(name = "create_time")
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

    @Override
    public String toString() {
        return "BaseProjectUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
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
}
