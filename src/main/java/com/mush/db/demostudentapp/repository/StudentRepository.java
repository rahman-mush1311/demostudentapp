package com.mush.db.demostudentapp.repository;

import com.mush.db.demostudentapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
