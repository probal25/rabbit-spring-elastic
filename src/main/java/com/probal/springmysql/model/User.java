package com.probal.springmysql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "user_details_tbl")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long userId;

    @Column(name = "user_name")
    private String username;

    @Column(name = "user_pass")
    private String userPassword;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_number")
    private Integer userNumber;

    @Column(name = "createdDate")
    private Date createdDate;


}
