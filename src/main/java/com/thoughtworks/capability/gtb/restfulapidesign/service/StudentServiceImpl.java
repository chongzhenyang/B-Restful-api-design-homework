package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Optional<Student> findStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student updateStudent(Long id, String name, String gender, String note) {
        Student originalStudent = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid id"));
        if(name != null){originalStudent.setName(name);}
        if(gender != null){originalStudent.setGender(gender);}
        if(note != null){originalStudent.setNote(note);}
        studentRepository.deleteById(id);
        studentRepository.save(originalStudent);
        return originalStudent;
    }

    @Override
    public void reassignStudent() {

    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
