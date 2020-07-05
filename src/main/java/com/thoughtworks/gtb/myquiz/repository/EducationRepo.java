package com.thoughtworks.gtb.myquiz.repository;

import com.thoughtworks.gtb.myquiz.model.Education;

import com.thoughtworks.gtb.myquiz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EducationRepo extends JpaRepository<Education, Long>{
    Optional<List<Education>> findEducationsByUser(User user);
}
