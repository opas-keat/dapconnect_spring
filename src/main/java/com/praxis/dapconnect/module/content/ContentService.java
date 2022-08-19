package com.praxis.dapconnect.module.content;

import com.praxis.dapconnect.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentService {
    private final ContentRepository repository;

    ContentService(ContentRepository repository) {
        this.repository = repository;
    }

    Content createOrUpdate(Content entity) {
        Optional<Content> content = repository.findById(entity.getId());
        if (content.isPresent()) {
            Content newEntity = content.get();
            newEntity.setAttachment(content.get().getAttachment());
            newEntity.setDescription(content.get().getDescription());
            newEntity.setBookDate(content.get().getBookDate());
            newEntity.setBookNo(content.get().getBookNo());
            newEntity.setLetterStatus(content.get().getLetterStatus());
            newEntity.setReceiveDate(content.get().getReceiveDate());
            newEntity.setReference(content.get().getReference());
            newEntity.setReceiverDepartmentCode(content.get().getReceiverDepartmentCode());
            newEntity.setSendDate(content.get().getSendDate());
            newEntity.setReceiverStatus(content.get().getReceiverStatus());
            newEntity.setSubject(content.get().getSubject());
            newEntity.setSpeed(content.get().getSpeed());
            newEntity.setSendFrom(content.get().getSendFrom());
            newEntity.setSendTo(content.get().getSendTo());
            newEntity.setSenderDepartmentCode(content.get().getSenderDepartmentCode());
            newEntity.setCreatedBy(content.get().getCreatedBy());
            newEntity = repository.save(newEntity);
            return newEntity;
        } else {
            entity = repository.save(entity);
            return entity;
        }
    }

    List<Content> createAll(List<Content> contents) {
        return (List<Content>) repository.saveAll(contents);
    }

    Optional<Content> findById(Long id) {
        return repository.findById(id);
    }

//    Content findById(Long id){
//        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
//    }

    Page<Content> findAll(Pageable pageable) {
        return repository.findAll(pageable);
//        List<Content> list = new ArrayList<>();
//        Iterable<Content> items = repository.findAll();
//        items.forEach(list::add);
//        return list;
    }

    void delete(Long id) {
        Content content = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Content with ID :" + id + " Not Found!"));
        repository.deleteById(content.getId());
    }

}
