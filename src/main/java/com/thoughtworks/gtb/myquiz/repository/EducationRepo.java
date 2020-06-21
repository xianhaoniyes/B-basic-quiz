package com.thoughtworks.gtb.myquiz.repository;

import com.thoughtworks.gtb.myquiz.Exception.EducationNotFoundException;
import com.thoughtworks.gtb.myquiz.Exception.NoSuchUserException;
import com.thoughtworks.gtb.myquiz.model.Education;
import com.thoughtworks.gtb.myquiz.model.EducationList;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.HashMap;


@Repository
public class EducationRepo {

    private final HashMap<Long, EducationList> educationListHashMap;

    public EducationRepo(){

        //the hardcode  user1 is only for test use
        educationListHashMap = new HashMap<>();
        EducationList educationList = new EducationList();
        educationList.addEducation(new Education(1L,2013L,"Bachelor", "Born as the bright summer flowers" +
                                                "Do not withered undefeated fiery demon rule " +
                                                "Heart rate and breathing to bear the load of the cumbersome "));

        educationList.addEducation(new Education(1L,2017L,"Master", "I heard the music, from the moon and carcass " +
                                                "Auxiliary extreme aestheticism bait to capture misty " +
                                                "Filling the intense life, but also filling the pure " +
                                                "There are always memories throughout the earth " +
                                                "I believe I am"));

        educationList.addEducation(new Education(1L, 2019L,"Doctor","Died as the quiet beauty of autumn leaves " +
                                                "Sheng is not chaos, smoke gesture " +
                                                "Even wilt also retained bone proudly Qing Feng muscle"));

        educationListHashMap.put(1L,educationList);
    }

    public EducationList getEducationList(Long userId) throws EducationNotFoundException,NoSuchUserException {
        EducationList educationList = educationListHashMap.get(userId);
        if(educationList==null)
            throw new NoSuchUserException();
        else if(educationList.getEducationList().size()==0)
            throw new EducationNotFoundException();


        return educationList;

    }

    public Education addEducation(Long userId, Education education) throws NoSuchUserException{
        EducationList educationList = educationListHashMap.get(userId);
        if(educationList==null)
            throw new NoSuchUserException();

        education.setUserId(userId);
        educationListHashMap.get(userId).addEducation(education);
        return education;

    }

    public void addUser(Long userId){
        educationListHashMap.put(userId,new EducationList());
    }

}
