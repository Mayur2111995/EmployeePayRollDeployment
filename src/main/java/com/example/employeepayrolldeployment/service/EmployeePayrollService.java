package com.example.employeepayrolldeployment.service;

import com.example.employeepayrolldeployment.Dto.EmployeePayrollDTO;
import com.example.employeepayrolldeployment.Exception.EmployeePayrollException;
import com.example.employeepayrolldeployment.Model.EmployeePayrollData;
import com.example.employeepayrolldeployment.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class EmployeePayrollService implements IEmployeeRollService {

    @Autowired
    private EmployeePayrollRepository employeeRepository;

    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeeRepository.findAll();
    }

    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeeRepository
                .findById(empId)
                .orElseThrow(() -> new EmployeePayrollException("Employee with employeeId" + empId + "does ot exists...!!"));
    }

    @Override
    public List<EmployeePayrollData> getEmployeeByDepartments(String departments) {
        return employeeRepository.findEmployeeByDepartments((departments));
    }


    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(employeePayrollDTO);
        log.debug("Emp Data:" + empData.toString());
        return employeeRepository.save(empData);
    }

    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        empData.updateEmployeePayrollData(employeePayrollDTO);
        return employeeRepository.save(empData);
    }

    public void deleteEmployeePayrollData(int empId) {
        EmployeePayrollData empdata = this.getEmployeePayrollDataById(empId);
        employeeRepository.delete(empdata);
    }
}
