package com.stackroute.muzixassignment.repository;

import com.stackroute.muzixassignment.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
//Spring @Repository annotation is used to indicate that the class provides the mechanism for
// storage, retrieval, search, update and delete operation on objects.
public interface TrackRepository extends JpaRepository<Track,Integer> {
    @Query(value = "SELECT t FROM Track t WHERE t.name = ?1")
    public List<Track> getUserByName(String name);
}
