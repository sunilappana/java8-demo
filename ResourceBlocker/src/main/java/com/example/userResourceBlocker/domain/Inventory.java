package com.example.userresourceblocker.domain;

import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Resources{

    private Integer id;

    private String equipmentName;

    private String quantity;

    private String price;

    private String category;
}
