/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.entity.projectile;

import game.entity.Entity;
import game.graphics.Sprite;

/**
 *
 * @author Niklas
 */
public abstract class Projectile extends Entity {
    
   protected final int xOrigin, yOrigin;
   protected double angle;
   protected Sprite sprite;
   
   //new x, new y
   protected double nx, ny;
   protected double speed, rateOfFire, range, damage;

           
           
    
    public Projectile(int x, int y, int dir){
        xOrigin = x;
        yOrigin = y;
        angle = dir;
        this.x = x;
        this.y = y;
        
        
    }
    
   protected void move(){
       
       
   }
   
   public Sprite getSprite(){
       
       return sprite;
   }
   
   public int getSpriteSize(){
       
       return sprite.SIZE;
   }
}
