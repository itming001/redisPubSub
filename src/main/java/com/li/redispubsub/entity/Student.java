package com.li.redispubsub.entity;

import lombok.Data;

@Data
public class Student {
    /**
     * 姓名
     */
    private String name;
    /**
     * 爱好
     */
    private String hobby;
    /**
     * 年龄
     */
    private Integer age;
}
