package com.mondol.mhmh.topic.schema;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table
@Entity(name = "topic_tip")
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class TopicTipEntity {
    @Id
    private Integer id;

    @Column
    private String title;

    @Column
    @ElementCollection
    private List<String> contents;
}
