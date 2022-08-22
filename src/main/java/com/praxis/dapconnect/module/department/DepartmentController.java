package com.praxis.dapconnect.module.department;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

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

//    @GetMapping(value = "/{id}")
//    ResponseEntity getDepartmentById(@PathVariable Long id) {
//        Optional<Department> optional = service.findById(id);
//        if (optional.isPresent()) {
//            Department department = optional.get();
//            SuccessResponse<Department> response = new SuccessResponse<>();
//            response.setData(department);
//            response.setBusinessCode("-");
//            return ResponseEntity.ok(response);
//        }
//
////        new ResourceNotFoundException("User with ID :"+id+" Not Found!");
//        return optional.orElse(new Department());
//    }

    @DeleteMapping("/{id}")
    void deleteDepartmentById(@PathVariable Long id) {
        service.deleteDepartment(id);
    }
}
