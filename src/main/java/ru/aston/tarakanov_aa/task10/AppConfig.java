package ru.aston.tarakanov_aa.task10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.annotation.Qualifier;

import ru.aston.tarakanov_aa.task10.ConfigDefenitionBeans.Album;
import ru.aston.tarakanov_aa.task10.ConfigDefenitionBeans.ClassicalAlbum;
import ru.aston.tarakanov_aa.task10.ConfigDefenitionBeans.Player;
import ru.aston.tarakanov_aa.task10.ConfigDefenitionBeans.RockAlbum;
import ru.aston.tarakanov_aa.task10.XmlBeans.*;

@Configuration
@ComponentScan("ru.aston.tarakanov_aa.task10.JavaBeans")
public class AppConfig {
	
//	@Bean
//	public Player getPlayer() {
//		return new Player();
//	}

	@Bean
	@Scope("singleton")
	public ClassicalAlbum classicalAlbum() {
		return new ClassicalAlbum();
	}
	
	@Bean
	@Scope("prototype")
	public RockAlbum rockAlbum() {
		return new RockAlbum();
	}
}
