package com.dataBaes.auctionSystem.User;

import jakarta.validation.constraints.*;

public class UserForm {

    private Integer userID;

    @NotBlank(message = "Username is required")
    @Size(max = 50)
    private String username;

    // Password might be optional on edit, so no @NotBlank here
    @Size(max = 50)
    private String password;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Size(max = 50)
    private String email;

    @NotNull(message = "User status is required")
    private UserEntity.UserStatus userStatus;

    private Boolean ifAdmin;

    @Size(max = 50)
    private String address;

    @Size(max = 15)
    private String contactNo;

    @Size(max = 50)
    private String name;

    @Size(max = 50)
    private String schoolName;

    @Size(max = 50)
    private String studentID;

    @Min(value = 0, message = "Age must be positive")
    private Integer age;

    @NotNull(message = "Sex is required")
    private UserEntity.Sex sex;

    @Size(max = 255)
    private String profileLocation;

    // Getters and Setters

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

    public UserEntity.UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserEntity.UserStatus userStatus) {
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

    public UserEntity.Sex getSex() {
        return sex;
    }

    public void setSex(UserEntity.Sex sex) {
        this.sex = sex;
    }

    public String getProfileLocation() {
        return profileLocation;
    }

    public void setProfileLocation(String profileLocation) {
        this.profileLocation = profileLocation;
    }
}
