package com.example.userresourceblocker.domain;

import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangePassword {

    private Integer id;

    private String oldPassword;

    private String newPassword;
}
