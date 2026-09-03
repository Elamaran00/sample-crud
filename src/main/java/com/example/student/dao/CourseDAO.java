package com.example.student.dao;

import com.example.student.entity.Course;
import java.util.List;

public interface CourseDAO {
    void save(Course course);
    void update(Course course);
    void delete(Long id);
    Course findById(Long id);
    List<Course> findAll();
}
