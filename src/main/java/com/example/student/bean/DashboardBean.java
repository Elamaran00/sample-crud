package com.example.student.bean;

import com.example.student.entity.Student;
import com.example.student.service.DepartmentService;
import com.example.student.service.DepartmentServiceImpl;
import com.example.student.service.StudentService;
import com.example.student.service.StudentServiceImpl;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean(name = "dashboardBean")
@RequestScoped
public class DashboardBean {

    private StudentService studentService = new StudentServiceImpl();
    private DepartmentService departmentService = new DepartmentServiceImpl();

    private int totalStudents;
    private int activeStudents;
    private int inactiveStudents;
    private int totalDepartments;
    private List<Student> recentStudents;

    @PostConstruct
    public void init() {
        List<Student> allStudents = studentService.getAllStudents();
        totalStudents = allStudents.size();
        activeStudents = (int) allStudents.stream().filter(s -> "Active".equalsIgnoreCase(s.getStatus())).count();
        inactiveStudents = totalStudents - activeStudents;
        
        totalDepartments = departmentService.getAllDepartments().size();
        
        // simple simulation of recent students (last 5)
        int fromIndex = Math.max(0, totalStudents - 5);
        recentStudents = allStudents.subList(fromIndex, totalStudents);
    }

    public int getTotalStudents() { return totalStudents; }
    public int getActiveStudents() { return activeStudents; }
    public int getInactiveStudents() { return inactiveStudents; }
    public int getTotalDepartments() { return totalDepartments; }
    public List<Student> getRecentStudents() { return recentStudents; }
}
