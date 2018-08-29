package com.baizhi.entity;

import javax.xml.crypto.Data;
import java.io.Serializable;

/**
 * Created by M on 2018/8/28.
 */
public class User implements Serializable {
    private Integer id;
    private String photoImg;
    private String name;
    private String dharmaName;
    private Integer sex;
    private String province;
    private String city;
    private String sign;
    private String phoneNum;
    private String password;
    private String salt;
    private Integer status;
    private Data registDate;
}
