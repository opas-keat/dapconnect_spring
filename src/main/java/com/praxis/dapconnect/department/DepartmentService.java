package com.praxis.dapconnect.department;

import com.praxis.dapconnect.department.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartmentService {
    public Page<Department> getAllDepartment(Pageable pageable);

//    public Optional<NamesOnly> getAllDepartment2(Pageable pageable);

    public Department getOneDepartment(Long id);

    public Department createDepartment(Department department);
    public boolean deleteDepartment(Long id);

}
