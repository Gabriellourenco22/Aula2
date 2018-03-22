package com.example.projetosandroid.aula2;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by ProjetosAndroid on 14/03/2018.
 */

public abstract class GameObject {
    public int x=0, y=0;
    public int layer=0;
    String textt= "";


    public void draw(Canvas canvas, Paint paint){

    }

    public void update(float deltaTime){


    }
}
