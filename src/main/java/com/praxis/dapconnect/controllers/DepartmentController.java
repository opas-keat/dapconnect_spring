package com.praxis.dapconnect.controllers;

import com.praxis.dapconnect.domain.model.entity.Department;
import com.praxis.dapconnect.services.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl service;

    @GetMapping(value = "/")
    public List<Department> getAllProduct(){
        return service.getAllDepartment();
    }

    @GetMapping(value = "/{id}")
    public Department getProductById(@PathVariable Long id){
        return service.getOneDepartment(id);
    }
}
