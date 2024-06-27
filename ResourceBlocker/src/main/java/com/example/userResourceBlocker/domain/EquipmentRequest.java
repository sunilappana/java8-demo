package com.example.userresourceblocker.domain;

import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentRequest {

    private Integer id;

    private Integer equipmentId;

    private Integer userId;

    private Integer status;

}
