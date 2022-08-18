package com.praxis.dapconnect.module.content;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
//    List<Content> findByName(@Param("name") String name);
}
