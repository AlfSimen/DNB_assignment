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
import java.util.List;

@Entity
@Table(name = "floor")
@Getter
public class Floor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "floor_generator")
    @SequenceGenerator(name = "floor_generator", sequenceName = "floor_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "floorNumber")
    private Integer floorNumber;

    @OneToMany(mappedBy = "floor")
    private List<Room> rooms;
}