package com.probal.springmysql.searchRequest;

import lombok.Data;

import java.util.Date;

@Data
public class UserSearchRequestDTO {
    private String username;
    private String email;
    private String phone;
    private Date fromDate;
    private Date toDate;
}
