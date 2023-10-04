package ru.aston.tarakanov_aa.task10.ConfigDefenitionBeans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class RockAlbum implements Album{
	
	private String singer = "Scorpions";
	
	private String[] songs = {"Wind of change", "Rock You Like A Hurricane", "Crazy World"};
	
	private int cnt = 0;
	
	@Override
	public String getSinger() {
		return singer;
	}

	@Override
	public String nextSong() {
		cnt++;
		if (cnt > 2) cnt = 0;		
		return songs[cnt];
	}
	
	@PostConstruct
	public void doInit() {
		System.out.println("Rock init method");
	}
	
	@PreDestroy
	public void doDestroy() {
		System.out.println("Rock destroy method");
	}

}
