/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;
import game.entity.mob.Player;
import game.graphics.Screen;
import game.input.KeyInput;
import game.input.Mouse;
import game.level.Level;
import game.level.RandomLevel;
import game.level.SpawnLevel;
import game.level.TileCoordinate;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;
/**
 *
 * @author Niklas
 */
public class Game extends Canvas implements Runnable {

    private static int width = 300;
    private static int height = width /16 * 9;
    private static int scale = 3;
    public static String title = "Best Game Ever";
    
    private Player player;
    private Thread thread;
    private JFrame frame;
    private KeyInput Key;
    private boolean running = false;
    
    private Screen screen;
    //Level Object
    private Level level;
    private BufferedImage image= new BufferedImage(width, height, 
            BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
    
    public Game(){
        Dimension size = new Dimension(width*scale,height*scale);
        setPreferredSize(size);
        frame = new JFrame();
        screen = new Screen(width, height);
        
        Key = new KeyInput();
        
        //Spawnpoint
        
        level = Level.spawn;
        TileCoordinate Player_Spawn = new TileCoordinate(19, 62);
        player = new Player(Player_Spawn.x(), Player_Spawn.y(), Key);
        player.init(level);
        addKeyListener(Key);
        Mouse mouse = new Mouse();
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
        
    }
    
    public synchronized void start(){
    
    running = true;
    thread = new Thread(this, "Display");
    thread.start();
    
    
    }
    
    public synchronized void stop(){
        
        running = false;
        try{
        thread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    
    public void run(){
        
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0;
        double delta = 0;
        
        //counts how many frames to render
        int frames = 0;
        
        //counts times updates
        int updates = 0;
        requestFocus();
      
        while(running){
            //calculate Time
            long now = System.nanoTime();
              delta += (now - lastTime) / ns;
              lastTime = now;
              while(delta >= 1){
                  update();
                  updates++;
                  delta--;
                  
          //  System.out.println("running...");
              }
                  
            render();
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
               
                
                //print out updates and frams per sec
                System.out.println(updates + " ups, " + frames + " fps");
                frame.setTitle(title + " | " + updates + " ups, " + frames + " fps");
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }
    
    public void update(){
        
        // check which key is pressed
        Key.update();
        player.update();
        level.update();
        // navigate
        /*if (Key.up) y--;
        if (Key.down) y++;
        if (Key.left) x--;
        if (Key.right) x++;*/
        
        
        //x++;
        //y++;
        
    }
    
    public static int getWindowWidth(){
        
        return width * scale;
    }
    
     public static int getWindowHeight(){
        
        return height * scale;
    }
    
    public void render(){
        BufferStrategy bs = getBufferStrategy();
        if (bs == null){
            createBufferStrategy(3);
            return;
        }
        screen.clear();
        
        int xScroll = player.x - screen.width / 2;
        int yScroll = player.y - screen.height / 2;
        
        level.render(xScroll, yScroll, screen);
        player.render(screen);
        
        for(int i = 0; i< pixels.length; i++){
        
        pixels[i] = screen.pixels[i];
        
      }
        Graphics g = bs.getDrawGraphics();
        
      
        //g.fillRect(0, 0, getWidth(), getHeight());
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Verdana", 0, 50));
        //showing position on Screen
       // g.drawString("X: " + player.x + ", Y: " + player.y, 450, 400);
        g.drawString("MouseButton: " + Mouse.getButton(), 80, 80);
        g.fillRect(Mouse.getX()-32, Mouse.getY()-32, 64, 64);
        g.dispose();
        bs.show();
    }
    
    public static void main(String[] args) {
       
        Game game = new Game();
        game.frame.setResizable(false);
        game.frame.setTitle("Loading...");
        game.frame.add(game);
        game.frame.pack();
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);
        
        game.start();
    }
    
}
