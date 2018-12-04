package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by M on 2018/8/28.
 */
public class User implements Serializable {
    private Integer id;
    private String photoImg;
    private String name;
    private String dharmaName;
    private String sex;
    private String province;
    private String city;
    private String sign;
    private String phoneNum;
    private String password;
    private String salt;
    private String status;
    private Date registDate;
    private int guru_id;

    public User() {
    }

    public User(Integer id, String photoImg, String name, String dharmaName, String sex, String province, String city, String sign, String phoneNum, String password, String salt, String status, Date registDate, int guru_id) {
        this.id = id;
        this.photoImg = photoImg;
        this.name = name;
        this.dharmaName = dharmaName;
        this.sex = sex;
        this.province = province;
        this.city = city;
        this.sign = sign;
        this.phoneNum = phoneNum;
        this.password = password;
        this.salt = salt;
        this.status = status;
        this.registDate = registDate;
        this.guru_id = guru_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhotoImg() {
        return photoImg;
    }

    public void setPhotoImg(String photoImg) {
        this.photoImg = photoImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDharmaName() {
        return dharmaName;
    }

    public void setDharmaName(String dharmaName) {
        this.dharmaName = dharmaName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    public int getGuru_id() {
        return guru_id;
    }

    public void setGuru_id(int guru_id) {
        this.guru_id = guru_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", photoImg='" + photoImg + '\'' +
                ", name='" + name + '\'' +
                ", dharmaName='" + dharmaName + '\'' +
                ", sex='" + sex + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", sign='" + sign + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", status='" + status + '\'' +
                ", registDate=" + registDate +
                ", guru_id=" + guru_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return guru_id == user.guru_id &&
                Objects.equals(id, user.id) &&
                Objects.equals(photoImg, user.photoImg) &&
                Objects.equals(name, user.name) &&
                Objects.equals(dharmaName, user.dharmaName) &&
                Objects.equals(sex, user.sex) &&
                Objects.equals(province, user.province) &&
                Objects.equals(city, user.city) &&
                Objects.equals(sign, user.sign) &&
                Objects.equals(phoneNum, user.phoneNum) &&
                Objects.equals(password, user.password) &&
                Objects.equals(salt, user.salt) &&
                Objects.equals(status, user.status) &&
                Objects.equals(registDate, user.registDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, photoImg, name, dharmaName, sex, province, city, sign, phoneNum, password, salt, status, registDate, guru_id);
    }
}
