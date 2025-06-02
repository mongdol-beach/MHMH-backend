package com.mondol.mhmh.topic.schema;

import com.mondol.mhmh.situation.schema.PersonSituationEntity;
import com.mondol.mhmh.situation.schema.SituationEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

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
    private TopicGroupType topicGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    private SituationEntity situation;

    @ManyToOne(fetch = FetchType.LAZY)
    private PersonSituationEntity personSituation;

    @OneToMany(mappedBy = "topic", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<TopicTipEntity> tips;
}
