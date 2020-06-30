package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import main.Game.STATE;

public class Shop extends MouseAdapter {

    Handler handler;
    HUD hud;
    Game game;

    private int b1 = 1000;
    private int b2 = 1000;
    private int b3 = 1000;

    public Shop(Handler handler, HUD hud, Game game) {

        this.handler = handler;
        this.hud = hud;
        this.game = game;

    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("arial", 0, 48));
        g.drawString("Shop", Game.WIDTH / 2 - 100, 50);

        // box 1
        g.setFont(new Font("arial", 0, 12));
        g.drawString("Upgrade Health", 110, 120);
        g.drawString("Cost: " + b1, 110, 140);
        g.drawRect(100, 100, 100, 80);
        // box 2
        g.drawString("Upgrade Speed", 260, 120);
        g.drawString("Cost: " + b2, 260, 140);
        g.drawRect(250, 100, 100, 80);
        // box 3
        g.drawString("Refill Health", 410, 120);
        g.drawString("Cost: " + b3, 410, 140);
        g.drawRect(400, 100, 100, 80);

        g.drawString("SCORE: " + hud.getScore(), Game.WIDTH / 2 - 50, 300);
        g.drawString("Press Space to go back: ", Game.WIDTH / 2 - 50, 330);

    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (game.gameState == STATE.Shop) {

            // box 1
            if (mx >= 100 && mx <= 200) {
                if (my >= 100 && my <= 180) {

                    if (hud.getScore() >= b1) {
                        hud.setScore(hud.getScore() - b1);
                        b1 += 1000;
                        hud.bounds += 20;
                        hud.HEALTH = (100 + (hud.bounds / 2));
                    }

                }
            }
            // box 2
            if (mx >= 250 && mx <= 350) {
                if (my >= 100 && my <= 180) {
                    if (hud.getScore() >= b2) {
                        hud.setScore(hud.getScore() - b2);
                        b2 += 1000;
                        handler.spd++;
                    }

                }
            }
            // box 3
            if (mx >= 400 && mx <= 500) {
                if (my >= 100 && my <= 180) {

                    if (hud.getScore() >= b3) {
                        hud.setScore(hud.getScore() - b3);
                        hud.HEALTH = (100 + (hud.bounds / 2));

                    }
                }
            }
        }

    }

}