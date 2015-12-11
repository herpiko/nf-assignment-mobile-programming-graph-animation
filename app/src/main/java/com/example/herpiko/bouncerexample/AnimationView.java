package com.example.herpiko.bouncerexample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

import java.util.jar.Attributes;

/**
 * Created by herpiko on 15-12-11.
 */
public class AnimationView extends View {

    private final int FRAME_RATE = 15;
    private Paint paint;
    private Handler h;

    Ball myBall;
    Ball greenBall;
    Ball redBall;


    public AnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);

        h = new Handler();

        paint = new Paint();
        paint.setColor(Color.BLUE);
        myBall = new Ball(100,100,Color.BLUE, 50);
        myBall.setDX(10);
        myBall.setDY(10);

        greenBall = new Ball(100,100,Color.GREEN, 50);
        greenBall.setDX(-20);
        greenBall.setDY(-15);

        redBall = new Ball(100,100,Color.RED, 50);
        redBall.setDX(5);
        redBall.setDY(-5);
    }

    private Runnable r = new Runnable() {
        @Override
        public void run() {
            invalidate();
        }
    };
    protected void onDraw(Canvas c) {
        myBall.bounce(c);
        c.drawCircle(myBall.getX(), myBall.getY(), myBall.getRadius(), myBall.getPaint());

        redBall.bounce(c);
        c.drawCircle(redBall.getX(), redBall.getY(), redBall.getRadius(), redBall.getPaint());

        greenBall.bounce(c);
        c.drawCircle(greenBall.getX(),greenBall.getY(), greenBall.getRadius(), greenBall.getPaint());

        h.postDelayed(r, FRAME_RATE);
    }
}
