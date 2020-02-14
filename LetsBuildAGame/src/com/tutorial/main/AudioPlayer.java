package com.tutorial.main;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;


public class AudioPlayer {
	
	public static Map<String, Music> musicMap = new HashMap<String, Music>();
	
	public static void load() {
		
		try {
			musicMap.put("music", new Music("res/Not Giving Up.ogg"));
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static Music getMusic(String key) {
		return musicMap.get(key);
	}

}
