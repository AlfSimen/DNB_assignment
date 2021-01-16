package com.alfsimen.dnb.reservations.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "team")
    private List<Employee> employees;

    @OneToMany(mappedBy = "team")
    private List<Invoice> invoices;

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String name;
        private List<Employee> employees = new ArrayList<>();

        private Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder employees(List<Employee> employees) {
            this.employees = employees;
            return this;
        }

        public Team build() {
            Team team = new Team();
            team.employees = this.employees;
            team.name = this.name;
            return team;
        }
    }
}
