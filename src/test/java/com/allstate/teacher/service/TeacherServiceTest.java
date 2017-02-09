package com.allstate.teacher.service;

import com.allstate.enums.Gender;
import com.allstate.teacher.entity.Teacher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by localadmin on 2/9/17.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Sql(value = "/sql/seed.sql")
public class TeacherServiceTest {
    @Autowired
    private TeacherService teacherService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateTeacher() throws Exception {
        Teacher teacher = new Teacher("t3", 40, Gender.MALE);

        Teacher createdTeacher = teacherService.create(teacher);

        assertEquals(4, createdTeacher.getId());
        assertEquals(Gender.MALE, createdTeacher.getGender());
        assertEquals("t3", createdTeacher.getName());
        assertEquals(40, createdTeacher.getAge());
    }

    @Test
    public void shouldFindTeacherById() throws Exception {
        Teacher teacher = teacherService.findById(2);

        assertEquals(2, teacher.getId());
        assertEquals("t2", teacher.getName());
        assertEquals(21, teacher.getAge());
        assertEquals(Gender.FEMALE, teacher.getGender());
    }

    @Test
    public void shouldFindTeachersByGender() throws Exception {
        List<Teacher> teacherList = teacherService.findTeachersByGender(Gender.FEMALE);

        assertEquals(2, teacherList.size());
    }

    @Test
    public void shouldFindTeachersOlderThan30() throws Exception {
        List<Teacher> teacherList = teacherService.findTeachersByAgeGreaterThan(30);

        assertEquals(2, teacherList.size());
    }


}