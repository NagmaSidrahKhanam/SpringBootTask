package com.stackroute.muzix.repositories;

import com.stackroute.muzix.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//Spring @Repository annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.
public interface TrackRepository extends JpaRepository<Track,Integer> {
    @Query(value = "SELECT * FROM User u WHERE u.firstname = ?1",nativeQuery = true)
     List<Track> getUserbyName(String name);
}
