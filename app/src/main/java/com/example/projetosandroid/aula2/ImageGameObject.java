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

public class ImageGameObject extends GameObject {
   public Bitmap bitmap;

    public void loadImage(String filename, AssetManager manager) {
        try {

            InputStream inputStream = manager.open(filename);
            bitmap = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  public int GetBitmapWidht()
  {
return bitmap.getWidth();
  }

    public int GetBitmapHeight()
    {
        return bitmap.getHeight();
    }
    @Override
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawBitmap(bitmap, x, y, paint);
    }

    @Override
    public boolean isCollision(float x, float y)
    {

        boolean result= false;

        if(bitmap !=null) {
            if (x >= this.x && x < (this.x + this.bitmap.getWidth()) && y >= this.y && y < (this.y + this.bitmap.getHeight())) {
                result = true;
            }
        }

        return result;
    }
}


