package com.api.salareunioes.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.salareunioes.entity.Room;
import com.api.salareunioes.exception.ResourceNotFoundException;
import com.api.salareunioes.repository.RoomRepository;

/***
 * 
 * @author dionatan
 *
 */

@RestController
@RequestMapping("/rooms")
@CrossOrigin(origins="http://localhost:4200")
public class RoomController {
	
	@Autowired
	private RoomRepository roomRepository;
	
	@GetMapping
	public List<Room> getAllRooms() {
		return roomRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Room> getRoomById(@PathVariable(value= "id") Long id) throws ResourceNotFoundException {
			Room room = roomRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Room not found: " + id));
		
			return ResponseEntity.ok().body(room);		
	}
	
	@PostMapping
	public Room createRoom(@Valid @RequestBody Room room) {
		return roomRepository.save(room);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Room> updateRoom(@PathVariable(value="id") Long id, 
										   @Valid @RequestBody Room roomDetails) throws ResourceNotFoundException {
		Room room = roomRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Room not found: " + id));
		room.setName(roomDetails.getName());
		room.setDate(roomDetails.getDate());
		room.setStartHour(roomDetails.getStartHour());
		room.setEndHour(roomDetails.getEndHour());
		final Room updateRoom = roomRepository.save(room);
		
		return ResponseEntity.ok(updateRoom);
	}
	
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteRoom(@PathVariable(value="id") Long id) throws ResourceNotFoundException {
		Room room = roomRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Room not found: " + id));
		
		roomRepository.delete(room);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
}
