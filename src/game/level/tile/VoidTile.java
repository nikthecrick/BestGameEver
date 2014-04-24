/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.level.tile;

import game.graphics.Screen;
import game.graphics.Sprite;

/**
 *
 * @author Niklas
 */
class VoidTile extends Tile {

    public VoidTile(Sprite sprite) {
        super(sprite);
    }
    
    
    public void render(int x, int y, Screen screen) {
        
        screen.renderTile(x,y,Sprite.voidSprite);
    }
    
}
