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
    Bitmap bitmap;

    public void loadImage(String filename, AssetManager manager) {
        try {
            InputStream inputStream = manager.open(filename);
            bitmap = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawBitmap(bitmap, x, y, paint);
    }
}


