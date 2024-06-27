package com.example.userresourceblocker.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "equipmentRequest")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer equipmentId;

    @Column(nullable = false)
    private Integer userId;

    @Column(nullable = false)
    private Integer status;

}
