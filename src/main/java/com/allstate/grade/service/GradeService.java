package com.allstate.grade.service;

import com.allstate.grade.entity.Grade;
import com.allstate.grade.repository.IGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired
    private IGradeRepository gradeRepository;

    public List<Grade> findGradesByStudent(int studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    public List<Grade> findGradesByKlass(int klassId) {
        return gradeRepository.findByKlassId(klassId);
    }
}
