package com.project.regap.domain;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UserDao {

    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "address")
    private String address;
    @Column(name = "age")
    private Integer age;

}
