package com.thoughtworks.gtb.myquiz.exception;

public class EducationNotFoundException extends Exception {
    public EducationNotFoundException() {
        super("we did not find the user's education record,you can add one");
    }
}
