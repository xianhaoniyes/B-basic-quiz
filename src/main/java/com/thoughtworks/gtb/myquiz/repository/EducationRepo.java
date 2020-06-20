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

        //the hardcode  user0 is only for test use
        educationListHashMap = new HashMap<>();
        EducationList educationList = new EducationList();
        educationList.addEducation(new Education(1L,2017L,"Bachelor","xianhao studied in south west jiaotong university"));
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
