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
@Table(name = "room")
@Getter
public class Room {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_generator")
    @SequenceGenerator(name = "room_generator", sequenceName = "room_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "floor")
    @ManyToOne
    private Floor floor;

    @OneToMany(mappedBy = "room")
    private List<Reservation> reservations;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "videoConference")
    private boolean videoConference;

    @Column(name = "drawingBoard")
    private boolean drawingBoard;
}
