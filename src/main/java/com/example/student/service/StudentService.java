package com.example.student.service;

import com.example.student.entity.Student;
import java.util.List;

public interface StudentService {
    void saveStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Long id);
    Student getStudentById(Long id);
    List<Student> getAllStudents();
    List<Student> searchStudentsByDepartment(Long departmentId);
    List<Student> searchStudentsByStatus(String status);
}
