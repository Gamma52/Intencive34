package ru.aston.tarakanov_aa.task10.ConfigDefenitionBeans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
	
	private String playerModel = "Walkman";
	
	private Album album;
	
//	public Player(Album album) {
//		this.album = album;
//	}
}
