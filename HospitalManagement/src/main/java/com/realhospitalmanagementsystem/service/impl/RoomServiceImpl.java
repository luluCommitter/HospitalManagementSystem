package com.realhospitalmanagementsystem.service.impl;

import com.realhospitalmanagementsystem.entity.Room;
import com.realhospitalmanagementsystem.repository.RoomRepository;
import com.realhospitalmanagementsystem.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Room not found"));
    }

    @Override
    public Room updateRoom(Long id, Room updatedRoom) {
        Room existingRoom = roomRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Room not found"));

        existingRoom.setRoomNumber(updatedRoom.getRoomNumber());
        existingRoom.setCapacity(updatedRoom.getCapacity());

        return roomRepository.save(existingRoom);
    }

    @Override
    public void deleteRoom(Long id) {
        Room existingRoom = roomRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Room not found"));

        roomRepository.delete(existingRoom);
    }
}

