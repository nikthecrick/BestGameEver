/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.entity.mob;

import game.Game;
import game.graphics.Screen;
import game.graphics.Sprite;
import game.input.KeyInput;
import game.input.Mouse;
import static game.input.Mouse.getX;
import static game.input.Mouse.getY;

/**
 *
 * @author Niklas
 */
public class Player extends Mob {
    
    final private KeyInput input;
    private int anim = 0;
    //boolean walking = false;
    

    public Player(KeyInput input){
        this.input = input;
        
       
        
        
    }
    
     public Player(int x, int y, KeyInput input){
        this.x = x;
        this.y = y;
        this.input = input;
         //to be save that sprite gets no bad value
        //sprite = Sprite.player_forward;
    }
     
    @Override
     public void update(){
         
         
         //Player movement with direction output for spritehandling
         int xa = 0, ya = 0;
         if(anim < 7500 )
             anim++;
   
         else anim = 0;
         
         
         if(input.up ){ya--;   } 
         if(input.down){ ya++; }
         if(input.left){xa--; }
         if(input.right){ xa++; }
         
       
        
         if(xa != 0 || ya != 0){
        
         
         move(xa,ya);
         walking = true;
         }else{
         walking = false;
         }
         
         updateShooting();
     }
     
    @Override
     public void render(Screen screen){
        
         int flip = 0;
         
         if(dir == 0) {
             
             //System.out.println(walking);
             sprite = Sprite.player_forward;
             if(walking){
                 if(anim % 20 < 10){
                    
                     sprite = Sprite.player_forward_1;
                 } else {
                     sprite = Sprite.player_forward_2;
                 
                 }
                 }
             }
         
        
        
         
         if(dir == 1){
             sprite = Sprite.player_side;
            
              if(walking){
                 if(anim % 20 < 10){
                    
                     sprite = Sprite.player_side_1;
                 } else {
                     sprite = Sprite.player_side_2;
                 
                     
                 }
             }
         }
         
          if(dir == 2) {
             sprite = Sprite.player_backward;
              if(walking){
                 if(anim % 20 < 10){
                    
                     sprite = Sprite.player_backward_1;
                 } else {
                     sprite = Sprite.player_backward_2;
                 
                 }
                 }
          }
              if(dir == 3){
                  sprite = Sprite.player_side;
                   if(walking){
                 if(anim % 20 < 10){
                    
                     sprite = Sprite.player_side_1;
                 } else {
                     sprite = Sprite.player_side_2;
                 
                    }
                 }
                  flip = 1;
              
             }
        
         screen.renderPlayer(x, y, sprite, flip);
         
     }

    private void updateShooting() {
        
        
        //get Angle of mouse to player
         if(Mouse.getButton() == 1){
            double dx = Mouse.getX() - Game.getWindowWidth() / 2;
            double dy = Mouse.getY() - Game.getWindowHeight() / 2;
            double dir = Math.atan2(dy, dx);
            shoot(x, y, dir);
        }
        
        
    }

}
