package com.praxis.dapconnect.module.content;

import com.praxis.dapconnect.exception.RecordNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentController {

    private final ContentService service;

    ContentController(ContentService service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<List<Content>> getAllEmployees() {
        List<Content> list = service.findAll();
        return new ResponseEntity<List<Content>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Content> getEmployeeById(
            @PathVariable("id") Long id)
            throws RecordNotFoundException {
        Content entity = service.find(id);
        return new ResponseEntity<Content>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Content> createOrUpdateEmployee(
            @Valid @RequestBody Content employee)
            throws RecordNotFoundException {
        Content updated = service.createOrUpdate(employee);
        return new ResponseEntity<Content>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    HttpStatus deleteContentById(
            @PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.delete(id);
        return HttpStatus.FORBIDDEN;
    }
}
