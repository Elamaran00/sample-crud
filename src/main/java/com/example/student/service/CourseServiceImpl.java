package com.example.student.service;

import com.example.student.dao.CourseDAO;
import com.example.student.dao.CourseDAOImpl;
import com.example.student.entity.Course;
import java.util.List;

public class CourseServiceImpl implements CourseService {

    private CourseDAO courseDAO = new CourseDAOImpl();

    @Override
    public void saveCourse(Course course) {
        courseDAO.save(course);
    }

    @Override
    public void updateCourse(Course course) {
        courseDAO.update(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseDAO.delete(id);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseDAO.findById(id);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDAO.findAll();
    }
}
