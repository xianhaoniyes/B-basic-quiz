package com.thoughtworks.gtb.myquiz.service;

import com.thoughtworks.gtb.myquiz.exception.EducationNotFoundException;
import com.thoughtworks.gtb.myquiz.exception.NoSuchUserException;
import com.thoughtworks.gtb.myquiz.model.Education;
import com.thoughtworks.gtb.myquiz.model.User;
import com.thoughtworks.gtb.myquiz.repository.EducationRepo;
import com.thoughtworks.gtb.myquiz.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final EducationRepo educationRepo;
    private final UserRepo userRepo;

    public UserService(EducationRepo educationRepo, UserRepo userRepo){
        this.educationRepo = educationRepo;
        this.userRepo = userRepo;
    }

    public List<Education> getEducationList(Long userId) throws EducationNotFoundException {
        return educationRepo.findEducationsByUser(userRepo.getOne(userId)).orElseThrow(EducationNotFoundException::new);
    }

    public Education putEducation(Education education) throws NoSuchUserException {
        Education storedEducation;
        try{
        storedEducation= educationRepo.save(education);
        }catch (Exception e){
            throw new NoSuchUserException();
        }
        return storedEducation;
    }

    public User putUser(User user){
        return userRepo.save(user);
    }

    public User getUser(Long userId) throws NoSuchUserException{
        return userRepo.getOne(userId);
    }
}
