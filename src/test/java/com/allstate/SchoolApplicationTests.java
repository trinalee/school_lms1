package com.allstate;

import com.allstate.klass.service.KlassServiceTest;
import com.allstate.student.service.StudentServiceTest;
import com.allstate.teacher.service.TeacherServiceTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(Suite.class)
@SpringBootTest
@Suite.SuiteClasses({
		StudentServiceTest.class,
		KlassServiceTest.class,
		TeacherServiceTest.class
})
public class SchoolApplicationTests {

	@Test
	public void contextLoads() {
	}

}
