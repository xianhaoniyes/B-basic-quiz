package com.thoughtworks.gtb.myquiz.repository;

import com.thoughtworks.gtb.myquiz.exception.NoSuchUserException;
import com.thoughtworks.gtb.myquiz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{

//    Optional<User> getOneById(Long id);


}
