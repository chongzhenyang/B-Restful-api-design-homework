package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ManagementSystemController {
    private final StudentService studentService;
    //private final GroupService groupService;

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public void createStudent(@RequestBody Student student){
        studentService.createStudent(student);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable("id") long id){
        studentService.deleteStudent(id);
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String showAllStudents(){
        List<Student> students = studentService.getAllStudents();
        return students.toString();
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(){
        return "welcome";
    }
}
