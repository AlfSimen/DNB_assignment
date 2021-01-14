package com.alfsimen.dnb.reservations.repository;

import com.alfsimen.dnb.reservations.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> getAllByFloor_Id(Long id);
}
