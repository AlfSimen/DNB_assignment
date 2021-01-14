package com.alfsimen.dnb.reservations.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "employee")
@Getter
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")
    @SequenceGenerator(name = "employee_generator", sequenceName = "employee_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "username", nullable = false, updatable = false)
    private String username;

    @JoinColumn(name = "team", nullable = false)
    @ManyToOne
    private Team team;

    @OneToMany(mappedBy = "employee")
    private List<Reservation> reservation;

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String username;
        private Team team;
        private List<Reservation> reservation;

        private Builder() {
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder team(Team team) {
            this.team = team;
            return this;
        }

        public Builder reservation(List<Reservation> reservation) {
            this.reservation = reservation;
            return this;
        }

        public Employee build() {
            Employee employee = new Employee();
            employee.team = this.team;
            employee.username = this.username;
            employee.reservation = this.reservation;
            return employee;
        }
    }
}
