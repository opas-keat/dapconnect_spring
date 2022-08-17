package com.praxis.dapconnect.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {
    final private DepartmentRepository repository;

    @Autowired
    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public Page<Department> getAllDepartment(Pageable pageable) {
        return repository.findAll(pageable);
    }

//    public Optional<NamesOnly> getAllDepartment2(Pageable pageable) {
//        return repository.findByName(pageable);
//    }

    public Optional<Department> getOneDepartment(Long id) {
//        Department department = repository.findById(id).get();
        Optional<Department> opt = Optional.ofNullable(repository.findById(id).get());
        return opt;
    }

    public Department createDepartment(Department department) {
        return repository.save(department);
    }


    public boolean deleteDepartment(Long id) {
        repository.deleteById(id);
        return true;
    }

}
