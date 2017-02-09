package com.allstate.student.service;

import com.allstate.student.entity.Student;
import com.allstate.student.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by localadmin on 2/9/17.
 */
@Service
public class StudentService {
    private IStudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student create(String email) {
        Student student = new Student();
        student.setEmail(email);
        return studentRepository.save(student);
    }

    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    public Student findById(int id) {
        return studentRepository.findOne(id);
    }

}
