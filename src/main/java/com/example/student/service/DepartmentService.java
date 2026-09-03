package com.example.student.service;

import com.example.student.entity.Department;
import java.util.List;

public interface DepartmentService {
    void saveDepartment(Department department);
    void updateDepartment(Department department);
    void deleteDepartment(Long id);
    Department getDepartmentById(Long id);
    List<Department> getAllDepartments();
}
