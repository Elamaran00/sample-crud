package com.example.student.bean;

import com.example.student.entity.Department;
import com.example.student.entity.Student;
import com.example.student.service.DepartmentService;
import com.example.student.service.DepartmentServiceImpl;
import com.example.student.service.StudentService;
import com.example.student.service.StudentServiceImpl;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "studentBean")
@SessionScoped
public class StudentBean implements Serializable {

    private StudentService studentService = new StudentServiceImpl();
    private DepartmentService departmentService = new DepartmentServiceImpl();

    private List<Student> students;
    private List<Department> departments;
    private Student currentStudent;
    
    private Long selectedDepartmentId;

    @PostConstruct
    public void init() {
        students = studentService.getAllStudents();
        departments = departmentService.getAllDepartments();
        currentStudent = new Student();
    }

    public String prepareCreate() {
        currentStudent = new Student();
        return "student-form?faces-redirect=true";
    }

    public String prepareEdit(Student student) {
        this.currentStudent = student;
        if (student.getDepartment() != null) {
            this.selectedDepartmentId = student.getDepartment().getId();
        }
        return "student-form?faces-redirect=true";
    }

    public String prepareView(Student student) {
        this.currentStudent = student;
        return "student-details?faces-redirect=true";
    }

    public String save() {
        if (selectedDepartmentId != null) {
            Department dept = departmentService.getDepartmentById(selectedDepartmentId);
            currentStudent.setDepartment(dept);
        }
        
        if (currentStudent.getId() == null) {
            studentService.saveStudent(currentStudent);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Student created successfully."));
        } else {
            studentService.updateStudent(currentStudent);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Student updated successfully."));
        }
        students = studentService.getAllStudents(); // refresh list
        return "students?faces-redirect=true";
    }

    public String delete(Long id) {
        studentService.deleteStudent(id);
        students = studentService.getAllStudents();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Student deleted successfully."));
        return "students?faces-redirect=true";
    }

    public String cancel() {
        return "students?faces-redirect=true";
    }

    // Getters and Setters
    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> students) { this.students = students; }

    public Student getCurrentStudent() { return currentStudent; }
    public void setCurrentStudent(Student currentStudent) { this.currentStudent = currentStudent; }

    public List<Department> getDepartments() { return departments; }
    public void setDepartments(List<Department> departments) { this.departments = departments; }

    public Long getSelectedDepartmentId() { return selectedDepartmentId; }
    public void setSelectedDepartmentId(Long selectedDepartmentId) { this.selectedDepartmentId = selectedDepartmentId; }
}
