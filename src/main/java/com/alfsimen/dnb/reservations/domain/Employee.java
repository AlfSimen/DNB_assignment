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
}