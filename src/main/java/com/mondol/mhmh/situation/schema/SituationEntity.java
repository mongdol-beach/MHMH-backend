package com.mondol.mhmh.situation.schema;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table
@Entity(name = "situation")
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class SituationEntity {
    @Id
    private String type;

    @Column
    private String title;

    @Column
    private String color;

    @Column
    private String textColor;
}
