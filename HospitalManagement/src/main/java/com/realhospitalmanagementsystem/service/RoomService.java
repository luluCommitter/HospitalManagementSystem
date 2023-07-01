package com.realhospitalmanagementsystem.service;

import com.realhospitalmanagementsystem.entity.Room;

import java.util.List;

public interface RoomService {

    Room createRoom(Room room);

    List<Room> getAllRooms();

    Room getRoomById(Long id);

    Room updateRoom(Long id, Room updatedRoom);

    void deleteRoom(Long id);
}
