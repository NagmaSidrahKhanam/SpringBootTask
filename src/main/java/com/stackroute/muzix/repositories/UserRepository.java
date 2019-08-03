package com.stackroute.muzix.repositories;

import com.stackroute.muzix.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//Spring @Repository annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "SELECT * FROM User u WHERE u.firstname = ?1",nativeQuery = true)
     List<User> getUserbyName(String name);
}
