package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/9/4.
 */
public class UserDto implements Serializable {
    private String name;
    private Integer value;

    public UserDto() {
    }

    public UserDto(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
