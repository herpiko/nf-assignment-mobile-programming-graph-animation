package com.example.herpiko.bouncerexample;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

/**
 * Created by herpiko on 15-12-11.
 */
public class Ball {
    private Point p;
    private int c;
    private int r;
    private int dx;
    private int dy;
    private Paint paint;

    public Ball (int x, int y, int col, int radius) {
        p = new Point(x,y);
        c = col;
        r = radius;
        paint = new Paint();
        paint.setColor(c);
        dx = 0;
        dy = 0;
    }

    // getter
    public int getX() {
        return p.x;

    }

    public int getY() {
        return p.y;
    }
    public int getRadius() {
        return r;
    }
    public Paint getPaint() {
        return paint;
    }

    // setter
    public void setColor(int col) {
        c = col;
    }
    public void goTo(int x, int y) {
        p.x = x;
        p.y = y;
    }

    public void setDX(int speed) {
        dx = speed;
    }
    public void setDY(int speed) {
        dy = speed;
    }

    public void move() {
        p.x = p.x + dx;
        p.y = p.y + dy;
    }

    public void bounce(Canvas canvas) {
        move();
        if (p.x > canvas.getWidth() || p.x < 0) {
            dx = dx * -1;
        }
        if (p.y > canvas.getWidth() || p.y < 0) {
            dy = dy * -1;
        }
    }
    public void bouncerOff(Ball b) {
        if ((Math.abs(b.getX()- p.x) < b.getRadius() + r) && (Math.abs(b.getY() - p.y) < b.getRadius() + r)) {
            dx = dx * -1;
            dy = dy * 1;
        }
    }
}
