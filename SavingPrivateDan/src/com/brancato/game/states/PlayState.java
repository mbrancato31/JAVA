package com.brancato.game.states;

import java.awt.Graphics2D;
import com.brancato.game.GamePanel;
import com.brancato.game.entity.Enemy;
import com.brancato.game.entity.Player;
import com.brancato.game.graphics.Font;
import com.brancato.game.graphics.Sprite;
import com.brancato.game.tiles.TileManager;
import com.brancato.game.util.KeyHandler;
import com.brancato.game.util.MouseHandler;
import com.brancato.game.util.Vector2f;

public class PlayState extends GameState {
	
	private Font font;
	private Player player;
	private Enemy enemy;
	private TileManager tm;
	public static Vector2f map;
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
		map = new Vector2f();
		Vector2f.setWorldVar(map.x, map.y);
		tm = new TileManager("C:/Users/Maurizio Brancato/Documents/vscode/SavingPrivateDan/res/tiles/tilemap.xml");
		font = new Font("C:/Users/Maurizio Brancato/Documents/vscode/SavingPrivateDan/res/font/font.png", 10, 10);		
		player = new Player(new Sprite("C:/Users/Maurizio Brancato/Documents/vscode/SavingPrivateDan/res/entity/linkformatted.png"),
				new Vector2f(0 + (GamePanel.width / 2) - 32, 0 + (GamePanel.height / 2) - 32), 64);
		enemy = new Enemy(new Sprite("C:/Users/Maurizio Brancato/Documents/vscode/SavingPrivateDan/res/entity/littlegirl.png", 48, 48),
				new Vector2f(0 + (GamePanel.width / 2) - 32 + 150, 0 + (GamePanel.height / 2) - 32 + 150), 64);
	}// end constructor
	
	public void update() {
		Vector2f.setWorldVar(map.x, map.y);
		player.update();
		enemy.update(player.getBounds());
	}//end update
	
	public void input(MouseHandler mouse, KeyHandler key) {
		player.input(mouse, key);
	}//end input
	
	public void render(Graphics2D g) {
		tm.render(g);
		Sprite.drawArray(g, font, GamePanel.oldFrameCount + " FPS", new Vector2f(GamePanel.width - 192, 32), 32, 32, 24, 0);
		player.render(g);
		enemy.render(g);
	}//end render
	

}//end play state
