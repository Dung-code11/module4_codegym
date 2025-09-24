package com.codegym.student.controller;

import com.codegym.student.model.Student;
import com.codegym.student.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // --- List students ---
    @GetMapping
    public String list(
            @RequestParam(name="q", defaultValue="") String q,
            @RequestParam(name="sort", defaultValue="id") String sort,
            @RequestParam(name="dir", defaultValue="asc") String dir,
            @RequestParam(name="page", defaultValue="1") int page,
            @RequestParam(name="size", defaultValue="5") int size,
            Model model) {

        List<Student> students = service.findAll(q, sort, dir, page, size);
        model.addAttribute("students", students);
        model.addAttribute("q", q);
        model.addAttribute("sort", sort);
        model.addAttribute("dir", dir);
        model.addAttribute("page", page);
        return "students/index";
    }

    // --- Detail student ---
    @GetMapping("/{id}")
    public String detail(@PathVariable("id") String id, Model model) {
        Student s = service.findById(id);
        model.addAttribute("student", s);
        return "students/detail";
    }

    // --- Add student form ---
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("studentForm", new Student());
        return "students/add";
    }

    @PostMapping("/add")
    public String doAdd(@ModelAttribute("studentForm") Student studentForm,
                        Model model,
                        RedirectAttributes ra) {

        Map<String, String> errors = validateStudent(studentForm, true);
        if (!errors.isEmpty()) {
            model.addAttribute("errors", errors);
            return "students/add";
        }

        service.create(studentForm);
        ra.addFlashAttribute("message", "Thêm thành công!");
        return "redirect:/students";
    }

    // --- Edit student form ---
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("studentForm", service.findById(id));
        return "students/edit";
    }

    @PostMapping("/{id}/edit")
    public String doEdit(@PathVariable("id") String id,
                         @ModelAttribute("studentForm") Student studentForm,
                         Model model,
                         RedirectAttributes ra) {

        Map<String, String> errors = validateStudent(studentForm, false);
        if (!errors.isEmpty()) {
            model.addAttribute("errors", errors);
            return "students/edit";
        }

        service.update(studentForm);
        ra.addFlashAttribute("message", "Sửa thành công!");
        return "redirect:/students";
    }

    // --- Delete student ---
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") String id, RedirectAttributes ra) {
        service.delete(id);
        ra.addFlashAttribute("message", "Xóa thành công!");
        return "redirect:/students";
    }

    // --- Validate student ---
    private Map<String, String> validateStudent(Student s, boolean checkDuplicateId) {
        Map<String, String> errors = new HashMap<>();

        if (s.getId() == null || s.getId().trim().isEmpty()) {
            errors.put("id", "Mã số không được rỗng");
        } else if (s.getId().length() < 3 || s.getId().length() > 20) {
            errors.put("id", "Mã số 3-20 ký tự");
        } else if (checkDuplicateId && service.findById(s.getId()) != null) {
            errors.put("id", "Mã số đã tồn tại");
        }

        if (s.getName() == null || s.getName().trim().isEmpty()) {
            errors.put("name", "Họ tên không được rỗng");
        } else {
            s.setName(s.getName().trim().replaceAll("\\s+", " "));
        }

        if (s.getGpa() < 0 || s.getGpa() > 10) {
            errors.put("gpa", "Điểm phải từ 0 đến 10");
        }

        return errors;
    }

}
