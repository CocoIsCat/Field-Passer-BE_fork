package com.example.fieldpasserbe.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "DISTRICT_LIST")
public class District {

    @Id
    @Column(name = "DISTRICT_ID")
    private int districtId;

    @Column(name = "DISTRICT")
    private String district;
}
