package com.example.projetosandroid.aula2;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by ProjetosAndroid on 14/03/2018.
 */

public class TextGameObject extends GameObject {
    int color= Color.BLACK;
            int size=30;
    String textn="";
    String textp="";

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(color);
        paint.setTextSize(size);
        canvas.drawText(textp,x,y,paint);
    }
    void UpadtScore()
    {


    }
}
