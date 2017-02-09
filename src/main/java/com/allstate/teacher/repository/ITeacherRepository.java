package com.allstate.teacher.repository;


import com.allstate.enums.Gender;
import com.allstate.teacher.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ITeacherRepository extends CrudRepository<Teacher, Integer> {

    public List<Teacher> findByGender(Gender gender);

    public List<Teacher> findByAgeGreaterThan(int age);

}
