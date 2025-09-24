package com.codegym.student.service;

import com.codegym.student.model.Student;
import com.codegym.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repo;

    public StudentServiceImpl(StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Student> findAll(String q, String sort, String dir, int page, int size) {
        List<Student> list = repo.findAll();

        // filter
        if (q != null && !q.isEmpty()) {
            list = list.stream()
                    .filter(s -> s.getId().contains(q) || s.getName().toLowerCase().contains(q.toLowerCase()))
                    .collect(Collectors.toList());
        }

        // sort
        Comparator<Student> cmp;
        switch (sort) {
            case "name": cmp = Comparator.comparing(Student::getName); break;
            case "gpa": cmp = Comparator.comparing(Student::getGpa); break;
            default: cmp = Comparator.comparing(Student::getId);
        }
        if ("desc".equals(dir)) cmp = cmp.reversed();
        list = list.stream().sorted(cmp).collect(Collectors.toList());

        // pagination
        int from = (page-1)*size;
        int to = Math.min(from+size, list.size());
        if (from > to) return Collections.emptyList();
        return list.subList(from, to);
    }

    @Override
    public Student findById(String id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void create(Student s) {
        repo.save(s);
    }

    @Override
    public void update(Student s) {
        repo.update(s);
    }

    @Override
    public void delete(String id) {
        repo.delete(id);
    }
}
