package com.example.projetosandroid.aula2;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ProjetosAndroid on 14/03/2018.
 */

public class AnimationImageGameObject extends GameObject {
    public Bitmap anin[];


    public Bitmap getbBtmap()
    {
        return anin[currentFrame];
    }

    int totalFrames;
    int currentFrame=0;

    public void loadImage(String filename, AssetManager manager, int framesW, int framesH) {
        {
            try {

                InputStream inputStream = manager.open(filename);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
                totalFrames = framesW * framesH;
                anin = new Bitmap[totalFrames];

                int width = bitmap.getWidth() / framesW;
                int height = bitmap.getHeight() / framesH;

                int index = 0;
                for (int i = 0; i < framesH; i++) {
                    for (int j = 0; j < framesW; j++) {
                        anin[index++] = bitmap.createBitmap(bitmap, j * width, i * height, width, height);
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    float starTime=0;
    @Override
    public void draw (Canvas canvas, Paint paint){
        float elapseTime=(System.nanoTime()-starTime)/1000000;
        if(elapseTime>200){
       currentFrame++;
       if(currentFrame>=totalFrames) {
           starTime=System.nanoTime();
           currentFrame = 0;
           if(currentFrame>=totalFrames)
           {
               currentFrame=0;
           }
       }
       }
       canvas.drawBitmap(anin[currentFrame],x,y,paint);
    }

    @Override
    public boolean isCollision(float x, float y)
    {

        boolean result= false;
        Bitmap bitmap = getbBtmap();

        if(bitmap !=null) {
            if (x >= this.x && x < (this.x + bitmap.getWidth()) && y >= this.y && y < (this.y + bitmap.getHeight())) {
                result = true;
            }
        }

        return result;
    }

}



