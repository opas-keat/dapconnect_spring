package com.praxis.dapconnect.services;

import com.praxis.dapconnect.domain.model.entity.Department;
import com.praxis.dapconnect.domain.model.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository repository;

//    @Override
    public Page<Department> getAllDepartment(Pageable pageable) {
        return repository.findAll(pageable);
    }

//    public Optional<NamesOnly> getAllDepartment2(Pageable pageable) {
//        return repository.findByName(pageable);
//    }

    @Override
    public Department getOneDepartment(Long id) {
        Department department = repository.findById(id).get();
        return department;
    }

    @Override
    public Department createDepartment(Department department) {
        return repository.save(department);
    }

    @Override
    public boolean deleteDepartment(Long id) {
        repository.deleteById(id);
        return true;
    }
}
