package com.allstate.grade.repository;


import com.allstate.grade.entity.Grade;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IGradeRepository extends CrudRepository<Grade, Integer> {
    List<Grade> findByStudentId(int studentId);
    List<Grade>findByKlassId(int klassId);
}
