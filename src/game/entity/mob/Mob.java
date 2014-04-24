/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.entity.mob;

import game.entity.Entity;
import game.entity.projectile.Projectile;
import game.entity.projectile.firstProjectile;
import game.graphics.Screen;
import game.graphics.Sprite;
import game.input.KeyInput;
import game.input.Mouse;
import game.level.tile.Tile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Niklas
 */
public abstract class Mob extends Entity {
    
    //only Mobs can access this sprite
    protected Sprite sprite;
    //direction

    /**
     *
     */
    protected int dir  = 0; //0 = north, 1 = east, 2 = south, 3 = west
    protected boolean moving = false;
    protected boolean walking = false;
    
    protected List<Projectile> projectiles = new ArrayList<Projectile>();
    //private KeyInput input;
   
    
    //moving any movable objects
    public void move(int xa, int ya){
       //System.out.println(xa + ", " + ya);
        if(xa != 0 && ya != 0){
            move(0 , ya);
            move(xa , 0);
            
            return;
        }
        
        //move direction
        if(xa > 0)dir = 1; // right
        if(xa < 0)dir = 3; // left
        if(ya > 0)dir = 2; // down
        if(ya < 0)dir = 0; // up
       
        //If there is no collision move forward(next tile has 
        //solid =true or not)
        if(!collision(xa, ya)){
             //x = -1(, 0, 1
        x += xa;
        y += ya;
        }
        
    }
    
    public void update() {

        
    }
    
    protected void shoot(int x, int y, double dir){
        //convert to degree value
        //dir *= 180 / Math.PI;
        //System.out.println("Shoot Angle: " + dir );
        
        Projectile p = new firstProjectile(x,y,(int)dir);
        projectiles.add(p);
        //Add projectile entity to level
        level.add(p);
       
    }
    
    public boolean collision(int xa, int ya){
        
        boolean solid = false;
        //get next Tile in moving direction
         for(int c = 0; c < 4; c++ ){
          //width of collision Area  
         int xt = ((x + xa) + c % 2 * 14 + 7) / 16;   
         //height
         int yt = ((y + ya) + c / 2 * 14 + 16) / 16 ;
         
        if(level.getTile(xt, yt).solid()) solid = true;
       System.out.println(x+ xa + ", " + y + ya);
         }
        return solid;
    }
    
    
    public void render(){
        
        
    }
}
