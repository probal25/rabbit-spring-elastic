package com.probal.springmysql.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UserDto implements Serializable {

    private String name;

    private String email;

    private String number;
}
