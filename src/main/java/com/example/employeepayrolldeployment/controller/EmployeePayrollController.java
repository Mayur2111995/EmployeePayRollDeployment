package com.example.employeepayrolldeployment.controller;

import com.example.employeepayrolldeployment.Dto.EmployeePayrollDTO;
import com.example.employeepayrolldeployment.Dto.ResponseDTO;
import com.example.employeepayrolldeployment.Model.EmployeePayrollData;
import com.example.employeepayrolldeployment.service.IEmployeeRollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    private final IEmployeeRollService employeeRollService;

    public EmployeePayrollController(IEmployeeRollService employeeRollService) {
        this.employeeRollService = employeeRollService;
    }

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<EmployeePayrollData> empDataList;
        empDataList = employeeRollService.getEmployeePayrollData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Success", empDataList);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
        EmployeePayrollData empData;
        empData = employeeRollService.getEmployeePayrollDataById(empId);
        ResponseDTO respDTO = new ResponseDTO("Get Call for ID Successful", empData);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/department/{departments}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("departments")String departments){
        List<EmployeePayrollData> employeePayrollDataList;
        employeePayrollDataList= employeeRollService.getEmployeeByDepartments(departments);
        ResponseDTO responseDTO = new ResponseDTO("Get Call for Id successful", employeePayrollDataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData;
        empData = employeeRollService.createEmployeePayrollData(employeePayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data Successfully", empData);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId, @Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData;
        empData = employeeRollService.updateEmployeePayrollData(empId, employeePayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Employee Payroll Data Successfully", empData);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        employeeRollService.deleteEmployeePayrollData(empId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", " Deleted Id: " + empId);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }
}

