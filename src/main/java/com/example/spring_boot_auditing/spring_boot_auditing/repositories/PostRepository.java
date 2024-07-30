package com.example.spring_boot_auditing.spring_boot_auditing.repositories;

import com.example.spring_boot_auditing.spring_boot_auditing.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
