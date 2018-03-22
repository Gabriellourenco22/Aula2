package com.example.projetosandroid.aula2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

/**
 * Created by ProjetosAndroid on 14/03/2018.
 */

public class RenderView extends View {


    Random random = new Random();


    int score;
    int score2;

    int r=200,g=200,b=200;

    ResourceManager resourceManager= ResourceManager.getInstance();
    ImageGameObject go_bob;
    AnimationImageGameObject go_thank;
    TextGameObject txt_incressPoint;
    TextGameObject txt_decressPoint;

    Paint paint=new Paint();
    public RenderView(Context context) {
        super(context);
         {


            go_bob = new ImageGameObject();
            go_bob.loadImage("bob.png", context.getAssets());
            go_bob.x = random.nextInt(400-200) + 200;
            go_bob.y =  random.nextInt(400-200) + 200;
            resourceManager.addObject(go_bob);

            go_thank = new AnimationImageGameObject();
            go_thank.loadImage("spritestank.png", context.getAssets(), 1, 8);
            go_thank.x =  random.nextInt(400-200) + 200;
            go_thank.y =  random.nextInt(400-200) + 200;
            resourceManager.addObject(go_thank);

            txt_incressPoint = new TextGameObject();
            txt_incressPoint.text="Pontos Positivos:";
             txt_incressPoint.x=50;
             txt_incressPoint.y=100;
             resourceManager.addObject(txt_incressPoint);

             txt_decressPoint =new TextGameObject();
             txt_decressPoint.text="Pontos Negativos:";
             txt_decressPoint.x=50;
             txt_decressPoint.y=200;
             resourceManager.addObject(txt_decressPoint);
        }




    }




    @Override
    public boolean onTouchEvent(MotionEvent event){
        int action = event.getAction();
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch(action){
            case MotionEvent.ACTION_DOWN:


                boolean isClicked = false;
                if(go_bob.isCollision(x,y))
                {
                            score++;
                            txt_incressPoint.text="Pontos Positivos: "+score;
                            isClicked = true;

                }
                else if(go_thank.isCollision(x,y))
                {
                    score2 ++;
                    txt_decressPoint.text="Pontos Negativos: "+score2;
                    isClicked = true;
                }

                if(isClicked)
                {
                    go_bob.x =  random.nextInt(400-200) + 200;
                    go_bob.y =  random.nextInt(400-200) + 200;
                    go_thank.x = random.nextInt(400-200) + 200;
                    go_thank.y = random.nextInt(400-200) + 200;
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
