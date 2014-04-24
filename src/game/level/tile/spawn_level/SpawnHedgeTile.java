/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.level.tile.spawn_level;

import game.graphics.Screen;
import game.graphics.Sprite;
import game.level.tile.Tile;

/**
 *
 * @author Niklas
 */
public class SpawnHedgeTile extends Tile {

    public SpawnHedgeTile(Sprite sprite) {
        
        super(sprite);
    }
    
    public void render(int x, int y, Screen screen){
        
        //multiply by 16
          screen.renderTile(x << 4, y <<4, Sprite.spawn_hedge);
        
    }
    
    public boolean solid(){
        
        return true;
    }
    
    public boolean breakable(){
        
        return false;
    }
    
}
