package com.allstate.student.service;

import com.allstate.klass.entity.Klass;
import com.allstate.klass.service.KlassService;
import com.allstate.student.entity.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

/**
 * Created by localadmin on 2/9/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class StudentServiceTest {
    @Autowired
    StudentService studentService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateStudent() throws Exception {
        Student actualStudent = studentService.create("abc@aol.com");

        assertEquals("abc@aol.com", actualStudent.getEmail());
        assertEquals(5, actualStudent.getId());
    }

    @Test
    public void shouldFindStudentByEmail() throws Exception {
        Student actualStudent = studentService.findByEmail("aaa@aol.com");

        assertEquals(1, actualStudent.getId());
        assertEquals("aaa@aol.com", actualStudent.getEmail());

    }

    @Test
    public void shouldFindStudentById() throws Exception {
        Student actualStudent = studentService.findById(3);

        assertEquals(3, actualStudent.getId());
        assertEquals("ccc@aol.com", actualStudent.getEmail());

    }

    @Ignore
    @Test
    @Transactional
    public void shouldFindAllStudentsInAClass() throws Exception {
        //size = 3
        KlassService klassService = new KlassService();
        Klass klass = klassService.findByName("Physics 101");
        System.out.println("this is the klass by physics 101: " + klass);
        assertEquals(3, klass.getStudents().size());

    }
}