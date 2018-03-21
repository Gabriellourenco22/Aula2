package com.example.projetosandroid.aula2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ProjetosAndroid on 14/03/2018.
 */

class ResourceManager {
    private static final ResourceManager ourInstance = new ResourceManager();

    static ResourceManager getInstance() {
        return ourInstance;
    }

    private ResourceManager() {
    }
    public List<GameObject> gameObjects = new ArrayList<>();

    public void addObject(GameObject obj){
        for(int i=0; i<gameObjects.size();i++)
        {
            if(obj.layer<=gameObjects.get(i).layer){
                gameObjects.add(i,obj);
                        return;
            }
        }
        gameObjects.add(obj);
    }
}
