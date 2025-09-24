package com.codegym.student.repository;

import com.codegym.student.model.Student;
import java.util.*;

public interface StudentRepository {
    List<Student> findAll();
    Optional<Student> findById(String id);
    void save(Student s);
    void update(Student s);
    void delete(String id);
}
