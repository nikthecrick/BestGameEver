/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.level;

import game.entity.Entity;
import game.graphics.Screen;
import game.level.tile.Tile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Niklas
 */
public class Level {
    
   // protected Tile[] tiles;
    protected int width;
    protected int height;
    //protected int[] tiles;
    protected int[] tilesInt;
    protected int tiles[];
    public static Level spawn = new SpawnLevel("/levels/spawn.png");
    
    //ArrayList of all Entities
    private List <Entity> entities = new ArrayList<Entity>();
    
    public Level(int width, int height){
        
        this.width = width;
        this.height = height;
        tilesInt = new int[width * height];
        generateLevel();
        
    }
    
    public Level(String path){
        
        loadLevel(path);
        generateLevel();
    }
    
    protected void generateLevel(){
        
        
    }
    
     protected void loadLevel(String path){
         
         
     }
     
     
     
     public void update(){
         
         for(int i = 0; i < entities.size(); i++){
             
              entities.get(i).update();
         }
        
         
     }
     
     //Add entity to level
     public void add(Entity e){
         
         entities.add(e);
     }
     
     private void time(){
         
     }
     
     public void render(int xScroll, int yScroll, Screen screen){
         
         
         screen.setOffset(xScroll, yScroll);
         
         //Cornerpins  - edges of screen
         int x0 = xScroll >> 4;
         //prerendering 1 Tile
         int x1 = (xScroll + screen.width + 16) >> 4;
         int y0 = yScroll >> 4;
         //prerendering 1 Tile
         int y1 = (yScroll + screen.height + 16) >> 4;
         
         //cycling from top to bottom every pixelnumber
         //Tile positions
         for(int y = y0; y < y1; y++){
             
            for(int x = x0; x < x1; x++) {
                
                //render Tile on screen
                getTile(x, y).render(x, y, screen);
                
                //Get Tiles prom pixel map
                /*  if(x + y * 16 < 0 || x + y * 16 >= 256){
                      Tile.voidTile.render(x, y, screen);
                      continue;
                  }
                      */
            // else
               // tiles[x + y * 16].render(x, y, screen);
            }
             
         }
          for(int i = 0; i < entities.size(); i++){
              
              //render entities in Entity ArrayList
             
              entities.get(i).render(screen);
         }
     }
     //return the tile, which will be rendered
     public Tile getTile(int x, int y) {
         //prevent out of Bounds cause of bad values
         //random map
         if(x <0 || y < 0 || x >= width || y >= height)
             return Tile.voidTile;
        
         if(tiles[x+y*width] == Tile.col_spawn_floor)
             return Tile.spawn_floor;
         if(tiles[x+y*width] == Tile.col_spawn_grass)
             return Tile.spawn_grass;
         if(tiles[x+y*width] == Tile.col_spawn_hedge)
             return Tile.spawn_hedge;
          if(tiles[x+y*width] == Tile.col_spawn_wall1)
             return Tile.spawn_wall1;
           if(tiles[x+y*width] == Tile.col_spawn_wall2)
             return Tile.spawn_wall2;
           if(tiles[x+y*width] == Tile.col_spawn_water)
             return Tile.spawn_water;
           
         
         return Tile.voidTile;
     }
     
     
     
     
}
