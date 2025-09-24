package com.codegym.student.service;

import com.codegym.student.model.Student;
import java.util.List;

public interface StudentService {
    List<Student> findAll(String q, String sort, String dir, int page, int size);
    Student findById(String id);
    void create(Student s);
    void update(Student s);
    void delete(String id);
}
