package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class ManagementSystemController {
    private final StudentService studentService;
    private final GroupService groupService;

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public void createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable("id") long id) {
        studentService.deleteStudent(id);
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String showAllStudentsByParam(@RequestParam(value = "gender", defaultValue = "") String gender,
                                         @RequestParam(value = "name", defaultValue = "") String name) {
        if (!"".equals(gender)) {
            return studentService.getAllStudentsByGender(gender).toString();
        } else if (!"".equals(name)) {
            return studentService.findStudentByName(name).toString();
        }
        return studentService.getAllStudents().toString();
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.PATCH)
    public String updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        Student originalStudent = studentService.findStudentById(id).orElseThrow(() -> new IllegalArgumentException("invalid id"));
        originalStudent.setId(id);
        if (student.getName() != null) {
            originalStudent.setName(student.getName());
        }
        if (student.getGender() != null) {
            originalStudent.setGender(student.getGender());
        }
        if (student.getNote() != null) {
            originalStudent.setNote(student.getNote());
        }
        studentService.createStudent(originalStudent);
        return originalStudent.toString();
    }

    @RequestMapping(value = "/groups/{id}", method = RequestMethod.PATCH)
    public String updateGroup(@PathVariable("id") Long id, @RequestBody Group group) {
        Group originalGroup = groupService.findGroupById(id).orElseThrow(() -> new IllegalArgumentException("invalid id"));
        originalGroup.setId(id);
        if (group.getName() != null) {
            originalGroup.setName(group.getName());
        }
        groupService.createGroup(originalGroup);
        return originalGroup.toString();
    }

    @RequestMapping(value = "/students/tasks/group", method = RequestMethod.GET)
    public void groupStudents() {
        studentService.reassignStudent();
    }

    @RequestMapping(value = "/groups/{id}", method = RequestMethod.GET)
    public String studentsInGroup(@PathVariable("id") Long groupNumber) {
        return studentService.getStudentsInaGroup(groupNumber).toString();
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome() {
        return "welcome";
    }
}
