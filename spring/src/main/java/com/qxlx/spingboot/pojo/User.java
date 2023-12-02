package com.qxlx.spingboot.pojo;

import lombok.Data;

import javax.persistence.*;
//wrk -t20 -c20 -d30s --latency http://localhost:8888/hiii

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String loginName;

    private String password;

}