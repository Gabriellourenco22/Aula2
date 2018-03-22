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

    TextGameObject textp;
    TextGameObject textn;

    Random Posx= new Random();
    Random PosY= new Random();

    Random PosXT = new Random();
    Random PosYT= new Random();


    int RandomX = Posx.nextInt(400-200) + 200;
    int RandomY = PosY.nextInt(600-200) + 200;

    int RandomXT = PosXT.nextInt(400-200) + 200;
    int RandomYT = PosYT.nextInt(600-200) + 200;

    int score;
    int score2;



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

            textp = new TextGameObject();
            textn=new TextGameObject();
             textp.text="Pontos Positivos:";

             textp.x=50;
             textp.y=100;
             resourceManager.addObject(textp);


             textn.text="Pontos Negativos:";
             textn.x=50;
             textn.y=200;
             resourceManager.addObject(textn);
        }




    }




    @Override
    public boolean onTouchEvent(MotionEvent event){
        int action = event.getAction();
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch(action){
            case MotionEvent.ACTION_DOWN:
                if(imageGameObject !=null) {
                    if (imageGameObject.bitmap!= null) {
                        if (x >= imageGameObject.x && x < (imageGameObject.x + imageGameObject.bitmap.getWidth())
                                && y >= imageGameObject.y && y < (imageGameObject.y + imageGameObject.bitmap.getHeight())) {


//Cliquei nesta imagem

                            score++;
                            textp.text="Pontos Positivos: "+score;



                        }
                    }
                }

                break;
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
