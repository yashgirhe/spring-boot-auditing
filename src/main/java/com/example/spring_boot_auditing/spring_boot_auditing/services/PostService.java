package com.example.spring_boot_auditing.spring_boot_auditing.services;

import com.example.spring_boot_auditing.spring_boot_auditing.dto.PostDTO;

import java.util.List;

public interface PostService {

    List<PostDTO> getAllPosts();

    PostDTO createNewPost(PostDTO postDTO);

    PostDTO getPostById(Long id);
}
