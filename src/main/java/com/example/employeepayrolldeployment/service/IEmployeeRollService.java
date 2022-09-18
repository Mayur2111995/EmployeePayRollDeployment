package com.example.employeepayrolldeployment.service;

import com.example.employeepayrolldeployment.Dto.EmployeePayrollDTO;
import com.example.employeepayrolldeployment.Model.EmployeePayrollData;

import java.util.List;

public interface IEmployeeRollService {
    List<EmployeePayrollData> getEmployeePayrollData();
    EmployeePayrollData getEmployeePayrollDataById(int empId);
    List<EmployeePayrollData> getEmployeeByDepartments(String departments);
    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

    EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO);

    void deleteEmployeePayrollData(int empId);
}
