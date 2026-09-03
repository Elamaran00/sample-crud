package com.example.student.dao;

import com.example.student.entity.Student;
import java.util.List;

public interface StudentDAO {
    void save(Student student);
    void update(Student student);
    void delete(Long id);
    Student findById(Long id);
    List<Student> findAll();
    List<Student> searchByDepartment(Long departmentId);
    List<Student> searchByStatus(String status);
}
