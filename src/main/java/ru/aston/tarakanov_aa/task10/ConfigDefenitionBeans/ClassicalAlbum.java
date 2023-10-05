package ru.aston.tarakanov_aa.task10.ConfigDefenitionBeans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class ClassicalAlbum implements Album{
	
	private String singer = "Hans zimmer";
	
	private String[] songs = {"Now we are free", "Day One", "Time"};
	
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
		System.out.println("Classical init method");
	}
	
	@PreDestroy
	public void doDestroy() {
		System.out.println("Classical destroy method");
	}

}
