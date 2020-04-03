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

    @Column(name = "user_organization")
    private String userOrganization;

    @Column(name = "user_teaching_office")
    private String userTeachingOffice;

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

    public String getUserHomeAddress() {
        return userHomeAddress;
    }

    public void setUserHomeAddress(String userHomeAddress) {
        this.userHomeAddress = userHomeAddress;
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
                ", userOrganization='" + userOrganization + '\'' +
                ", userTeachingOffice='" + userTeachingOffice + '\'' +
                ", userHomeAddress='" + userHomeAddress + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
