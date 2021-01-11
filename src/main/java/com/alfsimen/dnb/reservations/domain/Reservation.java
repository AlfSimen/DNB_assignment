package com.alfsimen.dnb.reservations.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
@Getter
public class Reservation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_generator")
    @SequenceGenerator(name = "reservation_generator", sequenceName = "reservation_sequence", allocationSize = 1)
    private Long id;

    @JoinColumn(name = "room", nullable = false)
    @ManyToOne
    private Room room;

    @JoinColumn(name = "employee", nullable = false, updatable = false)
    @ManyToOne
    private Employee employee;

    @Column(name = "reservedFrom")
    private LocalDateTime reservedFrom;

    @Column(name = "reservedTo")
    private LocalDateTime reservedTo;

    @Column(name = "confirmedArrival", nullable = false)
    private boolean confirmedArrival;

    @Column(name = "active", nullable = false)
    private boolean active;

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Room room;
        private Employee employee;
        private LocalDateTime reservedFrom;
        private LocalDateTime reservedTo;
        private boolean confirmedArrival;
        private boolean active;

        private Builder() {
        }

        public Builder room(Room room) {
            this.room = room;
            return this;
        }

        public Builder employee(Employee employee) {
            this.employee = employee;
            return this;
        }

        public Builder reservedFrom(LocalDateTime reservedFrom) {
            this.reservedFrom = reservedFrom;
            return this;
        }

        public Builder reservedTo(LocalDateTime reservedTo) {
            this.reservedTo = reservedTo;
            return this;
        }

        public Builder confirmedArrival(boolean confirmedArrival) {
            this.confirmedArrival = confirmedArrival;
            return this;
        }

        public Builder active(boolean active) {
            this.active = active;
            return this;
        }

        public Reservation build() {
            Reservation reservation = new Reservation();
            reservation.room = this.room;
            reservation.reservedFrom = this.reservedFrom;
            reservation.confirmedArrival = this.confirmedArrival;
            reservation.reservedTo = this.reservedTo;
            reservation.employee = this.employee;
            reservation.active = this.active;
            return reservation;
        }
    }
}
