package com.mush.db.demostudentapp.resources;

import com.mush.db.demostudentapp.exception.StudentNotFoundException;
import com.mush.db.demostudentapp.model.Student;
import com.mush.db.demostudentapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentResources {

    @Autowired
    StudentRepository studentRepository;

    //get all the students
    @GetMapping("/rest/student")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    //insert new student
    @PostMapping("/rest/student")
    public List<Student> persistStudent(@Valid @RequestBody Student newStudents) {
        List<Student> student = studentRepository.findAll();
        for (Student allStudents : student) {
            if ( (allStudents.getName().equals(newStudents.getName())) &&(allStudents.getAge().equals(newStudents.getAge())) && (allStudents.getDob().equals(newStudents.getDob()))) {
                return studentRepository.findAll();
            }
        }
        studentRepository.save(newStudents);
        return studentRepository.findAll();
    }
    //get a single student by id
    @GetMapping("/rest/student/{id}")
    public Student showStudent(@PathVariable String id) throws StudentNotFoundException {
        int Id=Integer.parseInt(id);
        return studentRepository.findOne(Id);
    }
    //update a single student
    @PutMapping("/rest/student/{id}")
    public Student updateStudent(@PathVariable(value = "id") int Id,
                            @Valid @RequestBody Student updatedStudent) throws StudentNotFoundException {

        Student currentStudent = studentRepository.findOne(Id);
        currentStudent.setDob(updatedStudent.getDob());
        currentStudent.setAge(updatedStudent.getAge());
        currentStudent.setName(updatedStudent.getName());
        currentStudent.setAddress(updatedStudent.getAddress());
        return studentRepository.save(currentStudent);

    }
    //delete a single student
    @DeleteMapping("/rest/student/{id}")
    public List<Student> deleteStudent(@PathVariable String id)throws StudentNotFoundException{
        int Id = Integer.parseInt(id);
        studentRepository.delete(Id);
        return studentRepository.findAll();
    }
}
