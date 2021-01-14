package com.alfsimen.dnb.reservations.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "team")
@Getter
public class Team {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_generator")
    @SequenceGenerator(name = "team_generator", sequenceName = "team_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    // TODO ALF: fee invoces?

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String name;

        private Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Team build() {
            Team team = new Team();
            team.name = this.name;
            return team;
        }
    }
}
