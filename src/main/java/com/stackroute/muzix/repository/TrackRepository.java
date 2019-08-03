package com.stackroute.muzix.repository;

import com.stackroute.muzix.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//Spring @Repository annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.
public interface TrackRepository extends JpaRepository<Track,Integer> {

    @Query("SELECT t FROM Track t WHERE t.name = ?1")
    List<Track> getTrackbyName(String name);
}
