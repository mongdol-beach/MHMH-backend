package com.mondol.mhmh.topic.schema;

import com.mondol.mhmh.situation.schema.SituationEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table
@Entity(name = "topic")
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class TopicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private SituationEntity situation;

    @OneToMany(mappedBy = "topic", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<TopicTipEntity> tips;
}
