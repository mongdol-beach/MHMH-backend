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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_tip_id")
    private Integer id;

    @Column
    private String title;

    @Column
    @CollectionTable(
            name = "topic_tip_contents",
            joinColumns = @JoinColumn(name = "c_topic_tip_id")
    )
    @ElementCollection
    private List<String> contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    private TopicEntity topic;
}
