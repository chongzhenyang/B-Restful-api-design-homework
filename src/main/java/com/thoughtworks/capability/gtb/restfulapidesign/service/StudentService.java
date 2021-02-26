package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student createStudent(Student student);

    void deleteStudent(Long id);

    Optional<Student> findStudentById(Long id);

    Optional<Student> findStudentByName(String name);

    void reassignStudent();

    List<Student> getAllStudentsByGender(String gender);

    List<Student> getAllStudents();

    List<Student> getStudentsInaGroup(Long groupNumber);
}
