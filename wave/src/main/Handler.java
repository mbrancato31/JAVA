package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.Graphics;

public class Handler {

    ArrayList<GameObject> object = new ArrayList<GameObject>();
    public int spd = 5;

    public void tick() {

        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }

    }

    public void render(Graphics g) {

        try {
            for (int i = 0; i < object.size(); i++) {
                GameObject tempObject = object.get(i);
                tempObject.render(g);
            }
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }

    public void clearEnemys() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            if (tempObject.getId() == ID.Player) {
                object.clear();
                if (Game.gameState != Game.STATE.End)
                    addObject(new Player(tempObject.getX(), tempObject.getY(), ID.Player, this));
            }

        }
    }

}