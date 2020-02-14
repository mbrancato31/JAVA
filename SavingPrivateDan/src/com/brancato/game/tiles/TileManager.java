package com.brancato.game.tiles;

import java.awt.Graphics2D;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.brancato.game.graphics.Sprite;



public class TileManager {
	
	public static ArrayList<TileMap> tm;
	
	public TileManager() {
		tm = new ArrayList<TileMap>();
	}//end constructor
	
	public TileManager(String path) {
		tm = new ArrayList<TileMap>();
		addTileMap(path, 64, 64);
	}//end tile manager
	
	private void addTileMap(String path, int blockWidth, int blockHeight) {
		String imagePath;
		int width = 0;
		int height = 0;
		int tileWidth;
		int tileHeight;
		int tileCount;
		int TileColumns;
		int layers = 0;
		Sprite sprite;
		String[] data = new String[10];
		
		try {
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document doc = builder.parse(new File(path));
			doc.getDocumentElement().normalize();
			
			NodeList list = doc.getElementsByTagName("tileset");
			Node node = list.item(0);
			org.w3c.dom.Element eElement = (Element) node;
			
			imagePath = eElement.getAttribute("name");
			tileWidth = Integer.parseInt(eElement.getAttribute("tilewidth"));
			tileHeight = Integer.parseInt(eElement.getAttribute("tileheight"));
			tileCount = Integer.parseInt(eElement.getAttribute("tilecount"));
			TileColumns = Integer.parseInt(eElement.getAttribute("columns"));
			sprite = new Sprite("C:/Users/Maurizio Brancato/Documents/Java/SavingPrivateDan/res/tiles/" + imagePath + ".png", tileWidth, tileHeight);
			
			list =  doc.getElementsByTagName("layer");
			layers = list.getLength();
			
			for(int i = 0; i < layers; i++) {
				node = list.item(i);
				eElement = (Element) node;
				if(i <= 0) {
					width = Integer.parseInt(eElement.getAttribute("width"));
					height = Integer.parseInt(eElement.getAttribute("height"));
				}//end if
				
				data[i] = eElement.getElementsByTagName("data").item(0).getTextContent();
				
				if(i >= 1) {
					tm.add(new TileMapNorm(data[i], sprite, width, height, blockWidth, blockHeight, TileColumns));
				}else {
					tm.add(new TileMapObj(data[i], sprite, width, height, blockWidth, blockHeight, TileColumns));
				}//end if else
				
			}//end for
			
			
		} catch (Exception e) {
			System.out.println("ERROR - TILEMANAGER: can not read tile map");
		}
	}//end add tile map
	
	public void render(Graphics2D g) {
		for(int i = 0; i < tm.size(); i++) {
			tm.get(i).render(g);
		}
	}//end render
	

}// end tile manager


























































































