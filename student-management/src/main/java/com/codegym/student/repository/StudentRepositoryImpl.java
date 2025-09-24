package com.codegym.student.repository;

import com.codegym.student.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private Map<String, Student> db = new HashMap<>();

    public StudentRepositoryImpl() {
        db.put("SV01", new Student("SV01", "Nguyen Van A", 7.5));
        db.put("SV02", new Student("SV02", "Tran Thi B", 8.2));
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public Optional<Student> findById(String id) {
        return Optional.ofNullable(db.get(id));
    }

    @Override
    public void save(Student s) {
        db.put(s.getId(), s);
    }

    @Override
    public void update(Student s) {
        db.put(s.getId(), s);
    }

    @Override
    public void delete(String id) {
        db.remove(id);
    }
}
