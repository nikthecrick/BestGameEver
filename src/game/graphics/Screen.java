/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.graphics;

import static game.Game.title;
import game.entity.projectile.Projectile;
import game.level.tile.Tile;
import java.util.Random;



/**
 *
 * @author Niklas
 */
public class Screen {
    public int width, height;
    
    public int[] pixels;
    public final int MAP_SIZE = 64;
     public final int MAP_SIZE_MASK = MAP_SIZE - 1;
     public int xOffset, yOffset;
    //Array keeps track of each tile
    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
    
    private Random random = new Random();

    
    public Screen(int width, int height){
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
        
        for(int i = 0; i < MAP_SIZE * MAP_SIZE; i++){
        
            //chooses every color between black and white
        tiles[i] = random.nextInt(0xffffff);
        
    }
        
    }
    
    public void clear(){
        
       for(int i = 0; i < pixels.length; i++) {
           
           pixels[i] = 0;
       }
    }
    
    /*public void render(int xOffset, int yOffset){
            ---OLD---OLD---OLD---OLD---OLD---OLD
        for(int y = 0; y < height; y++){
            int yp = y + yOffset;
            //int yy = y + yOffset;
            //if(yy > height || y >= height) break;
            if(yp < 0 || yp >= height) continue;
         for(int x = 0; x < width; x++){
             int xp = x + xOffset;
              if(xp < 0 || xp >= width) continue;
            //int xx = x + xOffset;
             //if(xx > width || xx >= width) break;
             
             //Resolution Tile index(find correct tile for coordinate on screen )
            // int tileIndex = ((xx >> 4) & MAP_SIZE_MASK) + ((yy >> 4) & MAP_SIZE_MASK) * MAP_SIZE;
             
             // loading textures(grass example)
             pixels[(x + xOffset) + (y + yOffset)*width] = Sprite.grass.pixels[(x&15)+(y&15) * Sprite.grass.SIZE]; //tiles[tileIndex]; loops color
             
         }
        
       }
        
    }*/
    
     public void renderTile(int xp, int yp, Tile tile){
         
         //offsetting only the player
          xp -= xOffset;
          yp -= yOffset;
          for (int y = 0; y < tile.sprite.SIZE; y++){
              //offset y
              int ya = y + yp;
               for (int x = 0; x < tile.sprite.SIZE; x++){
              //offset x
              int xa = x + xp;
              //only render tiles visable on map
              if(xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height){
                  break;
                  }
              //procerality
                    if ( xa < 0) xa = 0;
                   pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
              
                  
                      
            }
          }
      }
     
    
     public void renderTile(int xp, int yp, Sprite sprite){
         
         //offsetting only the player
          xp -= xOffset;
          yp -= yOffset;
          for (int y = 0; y < sprite.SIZE; y++){
              //offset y
              int ya = y + yp;
               for (int x = 0; x < sprite.SIZE; x++){
              //offset x
              int xa = x + xp;
              //only render tiles visable on map
              if(xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height){
                  break;
                  }
              //procerality
                    if ( xa < 0) xa = 0;
                   pixels[xa + ya * width] = sprite.pixels[x + y * sprite.SIZE];
              
                  
                      
            }
          }
      }
     
      public void renderProjectile(int xp, int yp, Projectile p){
         
         //offsetting only the player
          xp -= xOffset;
          yp -= yOffset;
          for (int y = 0; y < p.getSpriteSize(); y++){
              //offset y
              int ya = y + yp;
               for (int x = 0; x < p.getSpriteSize(); x++){
              //offset x
              int xa = x + xp;
              //only render tiles visable on map
              if(xa < -p.getSpriteSize() || xa >= width || ya < 0 || ya >= height){
                  break;
                  }
              //procerality
                    if ( xa < 0) xa = 0;
                    int col =  p.getSprite().pixels[x + y * p.getSpriteSize()];
                    
                    if(col != 0xffff00ff) pixels[xa + ya * width] = col;
                 
              
                  
                      
            }
          }
      }
     
        public void renderPlayer(int xp, int yp, Sprite sprite, int flip){
            
            //offsetting only the player
          xp -= xOffset;
          yp -= yOffset;
          
          for (int y = 0; y < 32; y++){
              //offset y
              
              int ya = y + yp;
              int ys = y;
              if(flip == 2 || flip == 3){
                   ys = 31 - y;
              }
               for (int x = 0; x < 32; x++){
              //offset x
              int xa = x + xp;
              int xs = x;
              //only render tiles visable on map
              if(flip == 1 || flip == 3){
                  xs = 31 - x;
              }
              if(xa < -32 || xa >= width || ya < 0 || ya >= height){
                  break;
                  }
              //procerality
                    if ( xa < 0) xa = 0;
                    //takes sprite pixels and renders them
                    int col = sprite.pixels[xs + ys * 32];
                    
                    //transparency of srite(deleting purple)
                    if(col != 0xFFFF00FF ) 
                    pixels[xa + ya *width] = col;
                   //pixels[xa + ya * width] = sprite.pixels[x + y * 16];
               }
               
          }
            
        }
    
    //setting Offsets of tiles
    public void setOffset(int xOffset, int yOffset){
        
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        
    }
}
