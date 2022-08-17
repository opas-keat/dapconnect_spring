package com.praxis.dapconnect.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    final private DepartmentService service;

    @Autowired
    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/version")
    public String version() {
        return "The actual version is 1.0.0";
    }

    @GetMapping(value = "/")
    Page<Department> getAllProduct(
            @PageableDefault(page = 0, size = 3) @NotNull
            Pageable pageable
    ) {
        Pageable paging = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        Page<Department> departments = service.getAllDepartment(paging);
        return departments;
    }

    @GetMapping(value = "/{id}")
    Department getProductById(@PathVariable Long id) {
        Department department = service.getOneDepartment(id);
        return department;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        service.deleteDepartment(id);
    }
}
