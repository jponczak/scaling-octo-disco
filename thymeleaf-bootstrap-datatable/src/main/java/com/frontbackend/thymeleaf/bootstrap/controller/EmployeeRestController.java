package com.frontbackend.thymeleaf.bootstrap.controller;

import com.frontbackend.thymeleaf.bootstrap.model.paging.PageArray;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frontbackend.thymeleaf.bootstrap.model.Employee;
import com.frontbackend.thymeleaf.bootstrap.model.paging.Page;
import com.frontbackend.thymeleaf.bootstrap.model.paging.PagingRequest;
import com.frontbackend.thymeleaf.bootstrap.service.EmployeeService;

@RestController
@RequestMapping("employees")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Page<Employee> list(@RequestBody PagingRequest pagingRequest) {
        return employeeService.getEmployees(pagingRequest);
    }

    @PostMapping("/array")
    public PageArray array(@RequestBody PagingRequest pagingRequest) {
        return employeeService.getEmployeesArray(pagingRequest);
    }
}
