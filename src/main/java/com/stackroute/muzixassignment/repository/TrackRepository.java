package com.stackroute.muzixassignment.repository;

import com.stackroute.muzixassignment.model.Track;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;

public interface TrackRepository extends MongoRepository<Track,Integer> {
//    @Query(value = "SELECT t FROM Track t WHERE t.name = ?1")
//    public List<Track> getUserByName(String name);
}
