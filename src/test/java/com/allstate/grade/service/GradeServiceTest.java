package com.allstate.grade.service;

import com.allstate.grade.entity.Grade;
import com.allstate.klass.entity.Klass;
import com.allstate.klass.service.KlassService;
import com.allstate.student.entity.Student;
import com.allstate.student.service.StudentService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class GradeServiceTest {

    @Autowired
    private GradeService gradeService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private KlassService klassService;

    @Test
    @Transactional
    public void shouldFindGradesForAStudent() throws Exception {
        Student student = studentService.findByEmail("aaa@aol.com");
        List<Grade> grades = gradeService.findGradesByStudent(student.getId());
        assertEquals(3, grades.size());
        assertEquals(91, grades.get(0).getValue());
    }

    @Test
    @Transactional
    public void shouldFindAllGradesForClass() throws Exception {
        Klass klass = klassService.findByName("Physics 101");
        List<Grade> grades = gradeService.findGradesByKlass(klass.getId());
        assertEquals(3, grades.size());
        assertEquals(91, grades.get(0).getValue());
    }
}