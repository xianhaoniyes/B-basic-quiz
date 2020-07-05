package com.thoughtworks.gtb.myquiz.repository;

import com.thoughtworks.gtb.myquiz.exception.EducationNotFoundException;
import com.thoughtworks.gtb.myquiz.exception.NoSuchUserException;
import com.thoughtworks.gtb.myquiz.model.Education;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EducationRepo extends JpaRepository<Education, Long>{



}
