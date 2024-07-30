package com.example.spring_boot_auditing.spring_boot_auditing.services;

import com.example.spring_boot_auditing.spring_boot_auditing.dto.PostDTO;
import com.example.spring_boot_auditing.spring_boot_auditing.entities.PostEntity;
import com.example.spring_boot_auditing.spring_boot_auditing.exceptions.ResourceNotFoundException;
import com.example.spring_boot_auditing.spring_boot_auditing.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity, PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO createNewPost(PostDTO inputPost) {
        PostEntity postEntity = modelMapper.map(inputPost, PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity),PostDTO.class);
    }

    @Override
    public PostDTO getPostById(Long id) {
        PostEntity postEntity = postRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Post not found"));
        return modelMapper.map(postEntity,PostDTO.class);
    }

    @Override
    public PostDTO updatePost(PostDTO inputPost, Long postId) {
        PostEntity existingPost = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post not found"));
        inputPost.setId(postId);
        modelMapper.map(inputPost, existingPost);
        PostEntity savedPostEntity = postRepository.save(existingPost);
        return modelMapper.map(savedPostEntity, PostDTO.class);
    }
}
