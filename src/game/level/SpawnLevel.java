/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.level;

import game.level.tile.Tile;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Niklas
 */
public class SpawnLevel extends Level {
    
   //private Tile[] tiles;
   // private int[] levelPixels;
    
    public SpawnLevel(String path){
        super(path);
         
         
     }
    
     protected void loadLevel(String path){
         
         try{
             
             //subclass to pretend from failing
             //loading imag from path
             BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
         
                 int w = width = image.getWidth();
                 int  h = height = image.getHeight();
                 tiles = new int[w*h];
                 //part of Tiles from Pixelmap
                // tiles = new Tile[w * h];
                 //put image in 
                 image.getRGB(0, 0, w, h, tiles, 0 , w);
                 
                 
         } catch (IOException e){
             e.printStackTrace();
             System.out.println("Exception! Could not load Level File");
         }
     }
     
     //Grass = 0xFF00FF00
     // Flower = 0xFFFFFF00
     //Rock = 0xFF7F7F00
     protected void generateLevel(){
        
       //converting Pixels into Tiles/ part from Tiles from pixelmap
         /*for(int i = 0; i < levelPixels.length; i++){
         if(levelPixels[i] == 0xFF00FF00) tiles[i] = Tile.grass;
         if(levelPixels[i] == 0xFFFFFF00) tiles[i] = Tile.flower;
         if(levelPixels[i] == 0xFF7F7F00) tiles[i] = Tile.rock;
             }*/
         
    }
}
