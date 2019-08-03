package com.stackroute.muzix.repositories;

import com.stackroute.muzix.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//Spring @Repository annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.
public interface UserRepository extends JpaRepository<User,Integer> {
}