package helloworld;

import static org.junit.Assert.*;

import org.junit.Test;

import helloworld.Tasks;

public class TasksTest {

	@Test
	public void test() {
		Tasks tasks = new Tasks();
		assertEquals(720, Tasks.doublefac(3));
	}
	
	
	
}
