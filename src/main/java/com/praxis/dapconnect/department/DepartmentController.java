package com.praxis.dapconnect.department;

import com.praxis.dapconnect.department.Department;
import com.praxis.dapconnect.department.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl service;

    @GetMapping(value = "/")
    Page<Department> getAllProduct(
        @PageableDefault(page = 0, size = 3)
        Pageable pageable
    ) {
        Pageable paging = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        return service.getAllDepartment(paging);
    }

    @GetMapping(value = "/{id}")
    Department getProductById(@PathVariable Long id) {
        return service.getOneDepartment(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        service.deleteDepartment(id);
    }
}
