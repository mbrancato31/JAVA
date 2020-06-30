package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject {

    private Handler handler;
    private int dir;
    private int dir2;
    Random r = new Random();
    private Color c;

    public MenuParticle(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        dir = r.nextInt(2);
        if (dir == 0) {
            velX = 40;
            velY = 70;
        } else if (dir == 1) {
            velX = 70;
            velY = 40;
        }
        // //difernt particle
        // velX = (r.nextInt(7 - -7) + -7);
        // velY = (r.nextInt(7 - -7) + -7);
        // if (velX == 0)
        // velX = 1;
        // if (velY == 0)
        // velY = 1;

        c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));

    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 32)
            velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 16)
            velX *= -1;

        handler.addObject(new Trail(x, y, ID.Trail, c, 16, 16, 0.05f, handler));

    }

    public void render(Graphics g) {
        g.setColor(c);
        g.fillRect((int) x, (int) y, 16, 16);

    }

}