package com.example.student.bean;

import com.example.student.entity.Student;
import com.example.student.service.StudentService;
import com.example.student.service.StudentServiceImpl;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean(name = "reportBean")
@RequestScoped
public class ReportBean {

    private StudentService studentService = new StudentServiceImpl();
    private List<Student> students;

    @PostConstruct
    public void init() {
        students = studentService.getAllStudents();
    }

    public List<Student> getActiveStudents() {
        return students.stream().filter(s -> "Active".equalsIgnoreCase(s.getStatus())).collect(Collectors.toList());
    }

    public List<Student> getInactiveStudents() {
        return students.stream().filter(s -> "Inactive".equalsIgnoreCase(s.getStatus())).collect(Collectors.toList());
    }
}
