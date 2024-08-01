package com.example.spring_boot_auditing.spring_boot_auditing.controllers;

import com.example.spring_boot_auditing.spring_boot_auditing.entities.PostEntity;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/audit")
public class AuditController {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @GetMapping(path = "/posts/{id}")
    List<PostEntity> getPostRevisions(@PathVariable Long id) {
        AuditReader reader = AuditReaderFactory.get(entityManagerFactory.createEntityManager());
        List<Number> revisions = reader.getRevisions(PostEntity.class, id);
        return revisions.stream().map(revisionNumber -> reader.find(PostEntity.class, id, revisionNumber)).collect(Collectors.toList());
    }
}
