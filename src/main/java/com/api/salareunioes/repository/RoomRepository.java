package com.api.salareunioes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.salareunioes.entity.Room;

/***
 * 
 * @author dionatan
 *
 */

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
	
}
