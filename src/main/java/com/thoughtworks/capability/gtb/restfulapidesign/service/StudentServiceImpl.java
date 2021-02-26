package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
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
    public Optional<Student> findStudentByName(String name) {
        return studentRepository.findStudentByName(name);
    }

    @Override
    public void reassignStudent() {
        long count = studentRepository.count();
        for (long i = 1, currGroup = 1; i <= count; i++, currGroup++) {
            Student student = studentRepository.findById(i).get();
            if (currGroup > 6) {
                currGroup = 1;
            }
            student.setGroupNumber(currGroup);
            studentRepository.save(student);
        }
    }

    @Override
    public List<Student> getAllStudentsByGender(String gender) {
        Student student = new Student();
        student.setGender(gender);
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("gender", ExampleMatcher.GenericPropertyMatchers
                .startsWith()).withIgnorePaths("id");
        Example<Student> ex = Example.of(student, matcher);
        return studentRepository.findAll(ex);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentsInaGroup(Long groupNumber) {
        return studentRepository.findStudentsByGroupNumber(groupNumber);
    }
}
