package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import com.codegym.blog.respository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog not found"));
    }

    @Override
    public Blog save(Blog blog) {
        if (blog.getId() == null) {
            blog.setCreatedAt(LocalDateTime.now());
        }
        blog.setUpdatedAt(LocalDateTime.now());
        return blogRepository.save(blog);
    }

    @Override
    public void deleteById(Long id) {
        blogRepository.deleteById(id);
    }
}
