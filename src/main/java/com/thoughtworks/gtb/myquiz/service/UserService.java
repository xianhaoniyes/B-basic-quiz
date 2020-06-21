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

    public List<Education> getEducationList(Long userId) throws EducationNotFoundException, NoSuchUserException {
        return educationRepo.getEducationList(userId).getEducationList();
    }

    public Education putEducation(Long userId, Education education) throws NoSuchUserException{
        education = educationRepo.addEducation(userId,education);
        return education;

    }

    public User putUser(User user){
        User storedUser = userRepo.putUser(user);
        educationRepo.addUser(storedUser.getUserId());
        return storedUser;
    }

    public User getUser(Long userId) throws  NoSuchUserException{
        return userRepo.getUser(userId);
    }
}
