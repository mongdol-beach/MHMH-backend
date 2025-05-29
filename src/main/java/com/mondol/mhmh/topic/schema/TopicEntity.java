package com.mondol.mhmh.topic.schema;

import com.mondol.mhmh.situation.schema.PersonSituationEntity;
import com.mondol.mhmh.situation.schema.SituationEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Table
@Entity(name = "topic")
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class TopicEntity {
    @Id
    @Column(name = "topic_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    @ColumnDefault(value = "SITUATION")
    @Enumerated(EnumType.STRING)
    private TopicGroupType group;

    @ManyToOne(fetch = FetchType.LAZY)
    private SituationEntity situation;

    @ManyToOne(fetch = FetchType.LAZY)
    private PersonSituationEntity personSituation;

    @OneToMany(mappedBy = "topic", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<TopicTipEntity> tips;
}
