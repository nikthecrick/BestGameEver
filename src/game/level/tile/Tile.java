/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.level.tile;


import game.graphics.Screen;
import game.graphics.Sprite;
import game.level.tile.spawn_level.SpawnFloorTile;
import game.level.tile.spawn_level.SpawnGrassTile;
import game.level.tile.spawn_level.SpawnHedgeTile;
import game.level.tile.spawn_level.SpawnWall1Tile;
import game.level.tile.spawn_level.SpawnWall2Tile;
import game.level.tile.spawn_level.SpawnWaterTile;

/**
 *
 * @author Niklas
 */
public class Tile {
    
    //koordinates
    public int x, y;
    
    public Sprite sprite;
    public static Tile grass = new GrassTile(Sprite.grass);
    public static Tile flower = new FlowerTile(Sprite.flower);
    public static Tile rock = new RockTile(Sprite.rock);
    public static Tile voidTile = new VoidTile(Sprite.voidSprite);
    
    public static Tile spawn_grass = new SpawnGrassTile(Sprite.spawn_grass);
    public static Tile spawn_hedge = new SpawnHedgeTile(Sprite.spawn_hedge);
    public static Tile spawn_water = new SpawnWaterTile(Sprite.spawn_water);
    public static Tile spawn_wall1 = new SpawnWall1Tile(Sprite.spawn_wall1);
    public static Tile spawn_wall2 = new SpawnWall2Tile(Sprite.spawn_wall2);
    public static Tile spawn_floor = new SpawnFloorTile(Sprite.spawn_floor);
    
    public final static int col_spawn_grass = 0xff00ff00;
    public final static int col_spawn_hedge = 0; //unused
    public final static int col_spawn_water = 0; //unused
    public final static long col_spawn_wall1 = 0xff808080;
    public final static int col_spawn_wall2 = 0xff303030;
    public final static int col_spawn_floor = 0xffffa538;
    
    public Tile(Sprite sprite){
        
        this.sprite = sprite;
    }
    
    public void render(int x, int y, Screen screen){
        
        
        
    }
    
    //collidability
    public boolean solid(){
        
        return false;
    }
}
