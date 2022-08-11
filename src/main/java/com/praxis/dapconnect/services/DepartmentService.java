package com.praxis.dapconnect.services;

import com.praxis.dapconnect.domain.model.entity.Department;

import java.util.List;

public interface DepartmentService {
    public List<Department> getAllDepartment();
    public Department getOneDepartment(Long id);
/*
    public Product createProduct(Product product);
    public boolean deleteProduct(Long id);
*/
}
