package com.matchresults.matchresults.domain;

import java.util.List;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PreRemove;

@Entity
public class Referee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long refereeId;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "referee")
    // @JsonIgnoreProperties(value = "matches")
    private List<Match> matches;

    @PreRemove
    public void checkDeletecondition() {
        if (!this.matches.isEmpty()) {
            throw new RuntimeException("Cannot be removed. This referee is listed as a referee in existing match.");
        }
    }

    public Referee() {

    }

    public Referee(String name) {
        super();
        this.name = name;
    }

    public Long getRefereeId() {
        return refereeId;
    }

    public void setRefereeId(Long refereeId) {
        this.refereeId = refereeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

}
