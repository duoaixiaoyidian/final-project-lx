package com.baizhi.entity;

import java.util.Objects;

public class UserBo {
    private int uid;
    private String phoneNum;
    private String password;

    public UserBo() {
    }

    public UserBo(int uid, String phoneNum, String password) {
        this.uid = uid;
        this.phoneNum = phoneNum;
        this.password = password;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

    @Override
    public String toString() {
        return "UserBo{" +
                "uid=" + uid +
                ", phoneNum='" + phoneNum + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBo userBo = (UserBo) o;
        return uid == userBo.uid &&
                Objects.equals(phoneNum, userBo.phoneNum) &&
                Objects.equals(password, userBo.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uid, phoneNum, password);
    }
}
