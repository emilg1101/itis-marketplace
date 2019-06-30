package com.github.emilg1101.marketplace.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String password;
    private String name;
    @Column(name = "reg_date")
    private Date regDate;
}
