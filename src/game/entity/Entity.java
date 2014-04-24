/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.entity;

import game.graphics.Screen;
import game.level.Level;
import java.util.Random;

/**
 *
 * @author Niklas
 */
public abstract class Entity {
    
    public int x, y;
    public boolean removed = false;
    protected Level level;
    protected final Random random = new Random();
    
    public void update(){
        
        
    }
    
    public void render(Screen screen){
        
        
        
    }
    
    public void remove(){
        
        //remove entity from level
        removed = true;
        
    }
    
    public boolean isRemoved(){
        
        return removed;
    }
    
    //initialize level
    public void init(Level level){
        
        this.level = level;
    }
}
