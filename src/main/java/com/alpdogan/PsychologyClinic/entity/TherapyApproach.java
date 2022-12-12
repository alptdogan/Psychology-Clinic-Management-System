package com.alpdogan.PsychologyClinic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "therapy_approach")
public class TherapyApproach {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private int id;

    @Column(name = "approach_name")
    private String approachName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    })
    @JoinTable(name = "therapist_and_approaches",
            joinColumns = { @JoinColumn(name = "fk_approach") },
            inverseJoinColumns = { @JoinColumn(name = "fk_therapist") })
    private Set<Therapist> therapist = new HashSet<>();

}
