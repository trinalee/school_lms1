package com.allstate.klass.service;

import com.allstate.enums.Department;
import com.allstate.klass.entity.Klass;
import com.allstate.teacher.entity.Teacher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class KlassServiceTest {
    @Autowired
    KlassService klassService;
//
//    @Autowired
//    Klass klass;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldFindKlassById() throws Exception {
        Klass klass = klassService.findById(2);
        Date expectedSemesterDate = new Date(118, 00, 25);

        assertEquals(2, klass.getId());
        assertEquals(3, klass.getCredits());
        assertEquals(Department.ENGINEERING, klass.getDepartment());
        assertEquals(550.0, klass.getFee(), 0);
        assertEquals("Electrical Engineering 101", klass.getName());
        assertEquals(expectedSemesterDate, klass.getSemester());
    }

    @Test
    @Transactional
    public void shouldFindKlassByName() throws Exception {
        Klass klass = klassService.findByName("Physics 101");
        Date expectedSemesterDate = new Date(117, 00, 25);

        assertEquals(1, klass.getId());
        assertEquals(4, klass.getCredits());
        assertEquals(Department.SCIENCE, klass.getDepartment());
        assertEquals(500.0, klass.getFee(),0);
        assertEquals("Physics 101", klass.getName());
        assertEquals(expectedSemesterDate, klass.getSemester());
    }

    @Test
    public void shouldFindKlassesByTeacherId() throws Exception {
        List<Klass> klassList = klassService.findKlassListByTeacherId(2);

        assertEquals(2, klassList.size());
    }

    @Test
    public void shouldFindTeacherNameByClass() throws Exception {
        Teacher teacher = klassService.findTeacherByClass("Physics 101");

        assertEquals("t1", teacher.getName());
    }
}