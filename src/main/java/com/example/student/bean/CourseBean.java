package com.example.student.bean;

import com.example.student.entity.Course;
import com.example.student.entity.Department;
import com.example.student.service.CourseService;
import com.example.student.service.CourseServiceImpl;
import com.example.student.service.DepartmentService;
import com.example.student.service.DepartmentServiceImpl;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "courseBean")
@SessionScoped
public class CourseBean implements Serializable {

    private CourseService courseService = new CourseServiceImpl();
    private DepartmentService departmentService = new DepartmentServiceImpl();

    private List<Course> courses;
    private List<Department> departments;
    private Course currentCourse;
    private Long selectedDepartmentId;

    @PostConstruct
    public void init() {
        courses = courseService.getAllCourses();
        departments = departmentService.getAllDepartments();
        currentCourse = new Course();
    }

    public void prepareCreate() {
        currentCourse = new Course();
        selectedDepartmentId = null;
    }

    public void prepareEdit(Course course) {
        this.currentCourse = course;
        if (course.getDepartment() != null) {
            this.selectedDepartmentId = course.getDepartment().getId();
        }
    }

    public void save() {
        if (selectedDepartmentId != null) {
            Department dept = departmentService.getDepartmentById(selectedDepartmentId);
            currentCourse.setDepartment(dept);
        }
        
        if (currentCourse.getId() == null) {
            courseService.saveCourse(currentCourse);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Course created successfully."));
        } else {
            courseService.updateCourse(currentCourse);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Course updated successfully."));
        }
        courses = courseService.getAllCourses();
        currentCourse = new Course();
    }

    public void delete(Long id) {
        courseService.deleteCourse(id);
        courses = courseService.getAllCourses();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Course deleted successfully."));
    }

    // Getters and Setters
    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }

    public Course getCurrentCourse() { return currentCourse; }
    public void setCurrentCourse(Course currentCourse) { this.currentCourse = currentCourse; }

    public List<Department> getDepartments() { return departments; }
    public void setDepartments(List<Department> departments) { this.departments = departments; }

    public Long getSelectedDepartmentId() { return selectedDepartmentId; }
    public void setSelectedDepartmentId(Long selectedDepartmentId) { this.selectedDepartmentId = selectedDepartmentId; }
}
