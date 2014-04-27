/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.graphics;

import game.level.tile.Tile;
import game.level.tile.spawn_level.SpawnGrassTile;

/**
 *
 * @author Niklas
 */
public class Sprite {
    
    public final int SIZE;
    private int x,y;
    public int[] pixels;
    private SpriteSheet sheet;
    
    //creating a Sprite
    public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
    public static Sprite flower = new Sprite(16, 1, 0, SpriteSheet.tiles);
    public static Sprite rock = new Sprite(16, 2, 0, SpriteSheet.tiles);
    public static Sprite voidSprite = new Sprite(16,0,4,SpriteSheet.tiles);
    /*public static Sprite player0 = new Sprite(16, 0, 5, SpriteSheet.tiles);
    public static Sprite player1 = new Sprite(16, 1, 5, SpriteSheet.tiles);
    public static Sprite player2 = new Sprite(16, 0, 6, SpriteSheet.tiles);
    public static Sprite player3 = new Sprite(16, 1, 6, SpriteSheet.tiles);*/
     
    
    //Spawnlevel Sprites:
    
    public static Sprite spawn_grass = new Sprite(16,0,0,SpriteSheet.spawn_level);
    public static Sprite spawn_hedge = new Sprite(16,1,0,SpriteSheet.spawn_level);
    public static Sprite spawn_water = new Sprite(16,2,0,SpriteSheet.spawn_level);
    public static Sprite spawn_wall1 = new Sprite(16,0,1,SpriteSheet.spawn_level);
     public static Sprite spawn_wall2 = new Sprite(16,0,2,SpriteSheet.spawn_level);
      public static Sprite spawn_floor = new Sprite(16,1,1,SpriteSheet.spawn_level);
    //Player Sprites:
    
    
    public static Sprite player_forward = new Sprite(32, 0, 5, SpriteSheet.tiles);
    public static Sprite player_backward = new Sprite(32, 2, 5, SpriteSheet.tiles);
    public static Sprite player_side = new Sprite(32, 1, 5, SpriteSheet.tiles);
    
    public static Sprite player_forward_1 = new Sprite(32, 0, 6, SpriteSheet.tiles);
    public static Sprite player_forward_2 = new Sprite(32, 0, 7, SpriteSheet.tiles);
  
    public static Sprite player_side_1 = new Sprite(32, 1, 6, SpriteSheet.tiles);
    public static Sprite player_side_2 = new Sprite(32, 1, 7, SpriteSheet.tiles);
    
    public static Sprite player_backward_1 = new Sprite(32, 2, 6, SpriteSheet.tiles);
    public static Sprite player_backward_2 = new Sprite(32, 2, 7, SpriteSheet.tiles);
    
    //Projectile Sprites
    
    
     public static Sprite projectile = new Sprite(16, 0, 0, SpriteSheet.projectile);
    
      public Sprite(int size, int x, int y, SpriteSheet sheet ){
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        this.x = x * size;
        this.y = y * size;
        this.sheet = sheet;
        load();
        
    }
    public Sprite(int size, int color){
        
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        setColor(color);
        
    }
    
    public void setColor(int color){
        for(int i = 0; i < SIZE * SIZE; i++){
            pixels[i] = color;
        }
    }
    
   public void load(){

    for(int y =0; y < SIZE; y++){
        for (int x = 0; x < SIZE; x++){
            
            //Accessing entire Sprtesheet and extracting the appropried sprite
            pixels[x+y*SIZE] = sheet.pixels[(x + this.x) + (y + this.y)*sheet.SIZE];
        }
      }
   }
}
