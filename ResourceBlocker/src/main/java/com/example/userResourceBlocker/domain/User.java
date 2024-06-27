package com.example.userresourceblocker.domain;

import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;

    private String firstName;

    private String lastName;

    private String userEmail;

    private String userPassword;

    private String mobileNo;

    private String address;

    private String role;

}
