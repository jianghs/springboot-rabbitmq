package me.jianghs.producer.dto;

import lombok.Data;

import java.util.Date;

/**
 * @className: User
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/20 10:14
 * @version: 1.0
 */
@Data
public class User {
    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 出生日期
     */
    private Date birthday;
}
