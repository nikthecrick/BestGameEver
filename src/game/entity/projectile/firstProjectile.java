/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.entity.projectile;

import game.graphics.Screen;
import game.graphics.Sprite;


/**
 *
 * @author Niklas
 */
public class firstProjectile extends Projectile{

    public firstProjectile(int x, int y, int dir) {
        super(x, y, dir);
        range = 10;
        damage = 20;
        speed = 2;
        rateOfFire = 2;
        sprite = Sprite.projectile;
        nx = speed * Math.cos(angle);
        ny = speed * Math.sin(angle);
    }
    
    @Override
      public void update(){
       
        move();
    }

    public void move() {
        
        x += nx;
        y += ny;
        
        
        
    }
    
    public void render(Screen screen){
        
        screen.renderProjectile(x, y, this);
    }
}
