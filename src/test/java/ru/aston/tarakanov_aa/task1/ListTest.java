package ru.aston.tarakanov_aa.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class ListTest {
	
	private List<String> arrayList; 
	
	@BeforeEach
	public void initColletctionInstanse() {
		arrayList = new ArrayList<String>();		
		arrayList.add("Olga");
		arrayList.add("Vera");
		arrayList.add("Nastya");				
	}
	
	@Test
	public void equalsTest1() {
		List<String> list = new ArrayList<String>();
		list.add("Olga");
		list.add("Nastya");
		list.add("Vera");		
		assertEquals(list.equals(arrayList), false);		
	}
	
	@Test
	public void equalsTest2() {
		ArrayList<String> list = new ArrayList<String>();		
		list.add("Olga");
		list.add("Nastya");
		list.add("Vera");
		Collections.sort(list);
		Collections.sort(arrayList);
		assertEquals(list.equals(arrayList), true);		
	}
	
	@Test
	public void indexOfTest1() {			
		assertEquals(arrayList.indexOf("Vera"), 1);		
	}
	
	@Test
	public void indexOfTest2() {			
		assertEquals(arrayList.indexOf("Masha"), -1);		
	}
	
	@Test
	public void containTest1() {
		ArrayList<String> list = new ArrayList<String>();		
		list.add("Olga");
		list.add("Nastya");
		list.add("Vera");
		assertEquals(arrayList.containsAll(list), true);		
	}
	
	@Test
	public void containTest2() {
		assertEquals(arrayList.contains("Msha"), false);		
	}
	
}
