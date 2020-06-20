package com.thoughtworks.gtb.myquiz.Exception;

public class NoSuchUserException extends Exception{
    public NoSuchUserException() {
        super("We don't have this user in our database");
    }
}
