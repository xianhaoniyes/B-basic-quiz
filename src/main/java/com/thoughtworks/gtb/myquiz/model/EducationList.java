package com.thoughtworks.gtb.myquiz.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class EducationList {

    private List<Education> educationList;

    public EducationList(){
        educationList = new ArrayList<>();
    }

    public void addEducation(Education education){
        educationList.add(education);
    }

}
