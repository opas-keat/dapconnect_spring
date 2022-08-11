package com.praxis.dapconnect.services;

import com.praxis.dapconnect.domain.model.entity.Department;
import com.praxis.dapconnect.domain.model.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository repository;

    @Override
    public List<Department> getAllDepartment() {
        return (List<Department>) repository.findAll();
    }

    @Override
    public Department getOneDepartment(Long id) {
        Department department = repository.findById(id).get();
        return department;
    }
}
