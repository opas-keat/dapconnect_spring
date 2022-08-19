package com.praxis.dapconnect.module.content;

import com.praxis.dapconnect.exception.ResourceNotFoundException;
import com.praxis.dapconnect.model.ListResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/content")
public class ContentController {

    private final ContentService service;

    ContentController(ContentService service) {
        this.service = service;
    }

    @GetMapping
    Page<Content> getAllContents(
            @PageableDefault(page = 0, size = 3)
            @NotNull
            Pageable pageable
    ) {
        Pageable paging = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        return service.findAll(paging);
    }

    @GetMapping("/{id}")
    ResponseEntity<Content> getContentById(@PathVariable("id") Long id) {
        Content content = service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Content with ID :" + id + " Not Found!"));
        return ResponseEntity.ok().body(content);
    }

    @PostMapping
    ResponseEntity<Content> createOrUpdateContent(
            @Valid @RequestBody Content content
    ) {
        Content contentNew = service.createOrUpdate(content);
        return ResponseEntity.ok().body(contentNew);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteContentById(
            @PathVariable("id") Long id) {
        Content content = service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID :" + id + " Not Found!"));
        service.delete(content.getId());
        return ResponseEntity.ok().body("Content deleted with success!");
    }
}
