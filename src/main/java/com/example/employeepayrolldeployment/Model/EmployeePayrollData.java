package com.example.employeepayrolldeployment.Model;


import com.example.employeepayrolldeployment.Dto.EmployeePayrollDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "employee_payroll")
public class EmployeePayrollData {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employeeId")
    private int employeeId;
    @Column(name = "name")
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    @ElementCollection
    @CollectionTable(name = "employee_departments", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "departments")
    private List<String> departments;

    public EmployeePayrollData() {

    }
    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.updateEmployeePayrollData(employeePayrollDTO);
    }


    public void updateEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        this.name = empPayrollDTO.name;
        this.salary = empPayrollDTO.salary;
        this.gender = empPayrollDTO.gender;
        this.note = empPayrollDTO.note;
        this.startDate = empPayrollDTO.startDate;
        this.profilePic = empPayrollDTO.profilePic;
        this.departments = empPayrollDTO.departments;
    }
}
