package ru.aston.tarakanov_aa.task1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MapTest {

	private HashMap<Integer, String> map; 
	
	@BeforeEach
	public void initColletctionInstanse() {
		map = new HashMap<Integer, String>();		
		map.put(1, "Olga");
		map.put(2,"Vera");
		map.put(3, "Nastya");		
	}
	
	@Test
	public void keySetTest() {		
		assertEquals(map.keySet(), Set.of(1, 2, 3));		
	}
	
	@Test
	public void sizeTest() {		
		assertEquals(map.size(), 3);		
	}
	
	@Test
	public void emptyTest() {		
		assertEquals(map.isEmpty(), false);		
	}
	
	
}
