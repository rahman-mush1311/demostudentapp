package com.mush.db.demostudentapp.exception;

public class StudentNotFoundException extends Exception {
    private int id;
    public StudentNotFoundException(int id) {
        super(String.format("Can not find student with id : '%s'", id));
    }
}
