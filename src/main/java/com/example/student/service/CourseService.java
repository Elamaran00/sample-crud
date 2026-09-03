package com.example.student.service;

import com.example.student.entity.Course;
import java.util.List;

public interface CourseService {
    void saveCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(Long id);
    Course getCourseById(Long id);
    List<Course> getAllCourses();
}
