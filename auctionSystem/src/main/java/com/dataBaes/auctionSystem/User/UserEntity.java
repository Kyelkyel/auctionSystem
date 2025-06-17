package com.dataBaes.auctionSystem.User;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Users")
public class UserEntity {

    public enum UserStatus {
        ONLINE, OFFLINE
    }

    public enum Sex {
        Male, Female, Prefer_Not_To_Say
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private Integer userID;

    @Column(length = 50)
    private String username;

    @Column(length = 50)
    private String password;

    @Column(length = 50)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "userStatus", nullable = false, length = 7)
    private UserStatus userStatus;

    @Column(name = "if_admin")
    private Boolean ifAdmin;

    @Column(length = 50)
    private String address;

    @Column(length = 15)
    private String contactNo;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String schoolName;

    @Column(length = 50)
    private String studentID;

    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 18)
    private Sex sex;

    @Column(length = 255)
    private String profile_location;

    // Getters and setters

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public Boolean getIfAdmin() {
        return ifAdmin;
    }

    public void setIfAdmin(Boolean ifAdmin) {
        this.ifAdmin = ifAdmin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getProfile_location() {
        return profile_location;
    }

    public void setProfile_location(String profile_location) {
        this.profile_location = profile_location;
    }

    // Optional: equals, hashCode, toString methods
}
