package com.example.student.service;

import com.example.student.dao.DepartmentDAO;
import com.example.student.dao.DepartmentDAOImpl;
import com.example.student.entity.Department;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDAO departmentDAO = new DepartmentDAOImpl();

    @Override
    public void saveDepartment(Department department) {
        departmentDAO.save(department);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentDAO.update(department);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentDAO.delete(id);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentDAO.findById(id);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentDAO.findAll();
    }
}
