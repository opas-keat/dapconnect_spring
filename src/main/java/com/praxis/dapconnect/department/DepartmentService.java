package com.praxis.dapconnect.department;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {
    final private DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public Page<Department> getAllDepartment(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Department getOneDepartment(Long id) {
        Optional<Department> opt = Optional.ofNullable(repository.findById(id).get());
        if (opt.isPresent()) {
            return opt.get();
        }
        return new Department();
    }

    public Department createDepartment(Department department) {
        return repository.save(department);
    }


    public boolean deleteDepartment(Long id) {
        repository.deleteById(id);
        return true;
    }

}
