package com.praxis.dapconnect.department;

import org.springframework.boot.ApplicationArguments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/version")
    public String version() {
        return "The actual version is 1.0.0";
    }

    @PostMapping(value = "/")
    public ResponseEntity<Department> createTutorial(@RequestBody Department department) {
        try {
//            Department _tutorial = service
//                    .save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
//            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/")
    Page<Department> getAllProduct(
            @PageableDefault(page = 0, size = 3) @NotNull
            Pageable pageable
    ) {
        Pageable paging = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        return service.getAllDepartment(paging);
    }

    @GetMapping(value = "/{id}")
    Department getDepartmentById(@PathVariable Long id) {
        Optional<Department> departmentOpt = service.findById(id);
        return departmentOpt.orElse(new Department());
    }

    @DeleteMapping("/{id}")
    void deleteDepartmentById(@PathVariable Long id) {
        service.deleteDepartment(id);
    }
}
