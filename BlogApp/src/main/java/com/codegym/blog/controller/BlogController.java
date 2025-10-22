package com.codegym.blog.controller;


import com.codegym.blog.model.Blog;
import com.codegym.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    // Trang danh sách
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "list";
    }

    // Tạo bài viết
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/save")
    public String saveBlog(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }

    // Xem chi tiết
    @GetMapping("/detail/{id}")
    public String viewDetail(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "detail";
    }

    // Cập nhật
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }

    @PostMapping("/update/{id}")
    public String updateBlog(@PathVariable Long id, @ModelAttribute Blog blog) {
        blog.setId(id);
        blogService.save(blog);
        return "redirect:/";
    }

    // Xóa
    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Long id) {
        blogService.deleteById(id);
        return "redirect:/";
    }
}
