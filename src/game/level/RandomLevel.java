/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.level;

import java.util.Random;

/**
 *
 * @author Niklas
 */
public class RandomLevel extends Level {

    public static final Random random = new Random();
    public RandomLevel(int width, int height) {
        super(width, height);
    }
    
    protected void generateLevel() {
        for (int y =0; y < height; y++){
            for(int x=0;x < width; x++){
                //four Random numbers 0-3
                tilesInt[x+y*width] = random.nextInt(4);
                
            }
        }
    }    
}
