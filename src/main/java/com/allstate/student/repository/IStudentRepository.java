package com.allstate.student.repository;

import com.allstate.student.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface IStudentRepository extends CrudRepository<Student, Integer> {
    public Student findByEmail(String email);
}
