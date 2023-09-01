package ru.aston.tarakanov_aa.task1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SetTest {

	private TreeSet<String> set; 
	
	@BeforeEach
	public void initColletctionInstanse() {
		set = new TreeSet<String>();		
		set.add("Olga");
		set.add("Vera");
		set.add("Nastya");		
	}
	
	
	@Test
	public void sortTest() {		
		assertEquals(set.first(), "Nastya");		
	}
	
	@Test
	public void pollTest1() {
		String str = set.pollFirst();
		assertEquals(set.contains(str), false);		
	}
	
	@Test
	public void pollTest2() {
		String str = set.pollLast();
		assertEquals(set.contains(str), false);		
	}	
	
	@Test
	public void ceilingTest() {	
		String str = set.ceiling("Masha");
		assertEquals(str, "Nastya");		
	}
	
	
}
