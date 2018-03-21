package com.example.projetosandroid.aula2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import java.util.Random;

/**
 * Created by ProjetosAndroid on 14/03/2018.
 */

public class RenderView extends View {
    Random Posx= new Random();
    Random PosY= new Random();

    Random PosXT = new Random();
    Random PosYT= new Random();


    int RandomX = Posx.nextInt(700) + 1;
    int RandomY = PosY.nextInt(500) + 1;

    int RandomXT = PosXT.nextInt(700) + 1;
    int RandomYT = PosYT.nextInt(500) + 1;



    int r=200,g=200,b=200;
    ResourceManager resourceManager= ResourceManager.getInstance();
    ImageGameObject imageGameObject;
    Paint paint=new Paint();
    public RenderView(Context context) {
        super(context);
         {
            imageGameObject = new ImageGameObject();
            imageGameObject.loadImage("bob.png", context.getAssets());
            imageGameObject.x = RandomX;
            imageGameObject.y = RandomY;
            resourceManager.addObject(imageGameObject);


            AnimationImageGameObject anin = new AnimationImageGameObject();

            anin.loadImage("spritestank.png", context.getAssets(), 1, 8);
            anin.x = RandomXT;
            anin.y = RandomYT;
            resourceManager.addObject(anin);
        }

        TextGameObject text= new TextGameObject();
        text.text="Score:";
        text.x=100;
        text.y=100;
        resourceManager.addObject(text);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_DOWN) {
            Random rx = new Random();
            int r1=rx.nextInt(500) + 1; // from 65, to 80
            imageGameObject.x=(int)event.getX();
            imageGameObject.y=(int)event.getY();


        }
        return super.onTouchEvent(event);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRGB(r,g,b);
        for(GameObject obj:resourceManager.gameObjects){
            obj.draw(canvas,paint);
    }
    invalidate();
}
}
