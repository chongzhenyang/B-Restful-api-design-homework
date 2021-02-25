package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student createStudent(Student student);
    void deleteStudent(Long id);
    Optional<Student> findStudentById(Long id);
    Student updateStudent(Long id, String name, String gender, String note);
    void reassignStudent();
    List<Student> getAllStudents();
}
