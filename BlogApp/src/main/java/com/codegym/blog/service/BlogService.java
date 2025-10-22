package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    Blog findById(Long id);
    Blog save(Blog blog);
    void deleteById(Long id);
}
