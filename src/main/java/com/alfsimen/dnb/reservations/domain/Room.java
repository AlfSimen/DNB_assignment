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
import java.util.ArrayList;
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

    @Column(name = "video_conference")
    private boolean videoConference;

    @Column(name = "drawing_board")
    private boolean drawingBoard;

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String name;
        private Floor floor;
        private List<Reservation> reservations = new ArrayList<>();
        private Integer capacity;
        private boolean videoConference;
        private boolean drawingBoard;

        private Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder floor(Floor floor) {
            this.floor = floor;
            return this;
        }

        public Builder reservations(List<Reservation> reservations) {
            this.reservations = reservations;
            return this;
        }

        public Builder capacity(Integer capacity) {
            this.capacity = capacity;
            return this;
        }

        public Builder videoConference(boolean videoConference) {
            this.videoConference = videoConference;
            return this;
        }

        public Builder drawingBoard(boolean drawingBoard) {
            this.drawingBoard = drawingBoard;
            return this;
        }

        public Room build() {
            Room room = new Room();
            room.floor = this.floor;
            room.reservations = this.reservations;
            room.capacity = this.capacity;
            room.name = this.name;
            room.drawingBoard = this.drawingBoard;
            room.videoConference = this.videoConference;
            return room;
        }
    }
}
