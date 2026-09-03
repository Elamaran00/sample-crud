package com.example.student.service;

import com.example.student.dao.StudentDAO;
import com.example.student.dao.StudentDAOImpl;
import com.example.student.entity.Student;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    public void saveStudent(Student student) {
        studentDAO.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentDAO.update(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentDAO.delete(id);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentDAO.findById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.findAll();
    }

    @Override
    public List<Student> searchStudentsByDepartment(Long departmentId) {
        return studentDAO.searchByDepartment(departmentId);
    }

    @Override
    public List<Student> searchStudentsByStatus(String status) {
        return studentDAO.searchByStatus(status);
    }
}
