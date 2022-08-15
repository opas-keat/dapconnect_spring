package com.praxis.dapconnect.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    final private DepartmentService service;

    @Autowired
    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

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
