package com.praxis.dapconnect.domain.service;

import com.praxis.dapconnect.domain.model.entity.Department;
import com.praxis.dapconnect.domain.model.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department create(Department department) {
        return departmentRepository.save(department);
    }

    public void remove(Long id){
        departmentRepository.deleteById(id);
    }

    public Iterable<Department> findAll(){
        return departmentRepository.findAll();
    }
}
