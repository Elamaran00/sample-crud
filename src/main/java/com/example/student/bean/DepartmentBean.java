package com.example.student.bean;

import com.example.student.entity.Department;
import com.example.student.service.DepartmentService;
import com.example.student.service.DepartmentServiceImpl;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "departmentBean")
@SessionScoped
public class DepartmentBean implements Serializable {

    private DepartmentService departmentService = new DepartmentServiceImpl();
    private List<Department> departments;
    private Department currentDepartment;

    @PostConstruct
    public void init() {
        departments = departmentService.getAllDepartments();
        currentDepartment = new Department();
    }

    public void prepareCreate() {
        currentDepartment = new Department();
    }

    public void prepareEdit(Department department) {
        this.currentDepartment = department;
    }

    public void save() {
        if (currentDepartment.getId() == null) {
            departmentService.saveDepartment(currentDepartment);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Department created successfully."));
        } else {
            departmentService.updateDepartment(currentDepartment);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Department updated successfully."));
        }
        departments = departmentService.getAllDepartments();
        currentDepartment = new Department();
    }

    public void delete(Long id) {
        departmentService.deleteDepartment(id);
        departments = departmentService.getAllDepartments();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Department deleted successfully."));
    }

    // Getters and Setters
    public List<Department> getDepartments() { return departments; }
    public void setDepartments(List<Department> departments) { this.departments = departments; }

    public Department getCurrentDepartment() { return currentDepartment; }
    public void setCurrentDepartment(Department currentDepartment) { this.currentDepartment = currentDepartment; }
}
