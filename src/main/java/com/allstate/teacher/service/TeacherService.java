package com.allstate.teacher.service;

import com.allstate.enums.Gender;
import com.allstate.teacher.entity.Teacher;
import com.allstate.teacher.repository.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    ITeacherRepository teacherRepository;

    public Teacher create(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher findById(int id) {
        return teacherRepository.findOne(id);
    }

    public List<Teacher> findTeachersByGender(Gender gender) {
        return teacherRepository.findByGender(gender);
    }

    public List<Teacher> findTeachersByAgeGreaterThan(int age){
        return teacherRepository.findByAgeGreaterThan(age);
    }
}
