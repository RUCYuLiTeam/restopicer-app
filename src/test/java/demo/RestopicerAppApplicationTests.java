package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import restopicerapp.RestopicerAppApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestopicerAppApplication.class)
@WebAppConfiguration
public class RestopicerAppApplicationTests {

	@Test
	public void contextLoads() {
	}

}
