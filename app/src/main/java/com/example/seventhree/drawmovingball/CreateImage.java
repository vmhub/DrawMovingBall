package com.example.seventhree.drawmovingball;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Handler;
import android.util.Log;
import android.view.View;

/**
 * Created by SevenThree on 3.10.2015.
 */
public class CreateImage extends View {
    private Bitmap pic = BitmapFactory.decodeResource(getResources(), R.drawable.tennis);

    private Paint canvasPaint;
    private Paint createRekt;

    private int x;
    private int y;

    private int dx;
    private int dy;
    private final int FRAME_RATE;

    private int scene_width;
    private int scene_height;
    private int pic_w=pic.getWidth();
    private int pic_h=pic.getHeight();
    private Handler h;

    public CreateImage(Context context, int start_x, int start_y,int dx,int dy,int color,int frame) {
        super(context);
        x=start_x;
        y=start_y;
        this.dx=dx;
        this.dy=dy;
        FRAME_RATE=frame;


        canvasPaint = new Paint();
        canvasPaint.setStyle(Paint.Style.FILL);
        canvasPaint.setColor(color);

        createRekt = new Paint();
        createRekt.setColor(Color.BLACK);
        createRekt.setStyle(Paint.Style.STROKE);
        createRekt.setStrokeWidth(10);

        h = new Handler();
    }

    private Runnable r = new Runnable() {
        @Override        public void run() {
            invalidate();
        }
    };

    @Override    protected void onDraw(Canvas sceneCanvas) {
        super.onDraw(sceneCanvas);

        sceneCanvas.drawPaint(canvasPaint);
        scene_width =this.getWidth();
        scene_height = this.getHeight();
        sceneCanvas.drawRect(45,45,scene_width-45,scene_height-45,createRekt);
        sceneCanvas.drawBitmap(pic, x, y, null);
        x += dx;
        y += dy;


        if ((x > (scene_width-45) - pic_w) || (x <45)) {
            dx = dx*-1;

        }

        if ((y > (scene_height-45) - pic_h) || (y <45)) {
            dy = dy*-1;

        }

        h.postDelayed(r, FRAME_RATE);
    }



    public Point[] getXY() {
       Point[]  arr={new Point(x,y),new Point(dx,dy)};
       return arr;
    }



}
