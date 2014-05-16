/**
 * boxjumperold.java  12/5/2014
 *
 * @author - Aaron Conn
 * @author - Chris Best
 * @author - Preeti Singh
 * @version 1.00 13/5/2014
 *
 */


import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;
import java.awt.Rectangle;
import java.awt.AWTEvent;
import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.JFrame;

public abstract class boxjumperold extends Canvas implements KeyListener
{
	private Timer timer; 
	private final static int SLEEP = 50;    //Delay in registering keypresses
	private int speed = 8;                  //Movement speed (units moved each interval)
	private int jumpHeight = 17;            //Jump height
	private int gravity = 2;                //Gravity
	private int level;                      //Level
	private int score;                      //Player score
	private int x;                          //x position
	private int y;                          //y position
	private int yVelocity;                  //y velocity
	private int key;                        //Key being pressed
	private boolean touchingPlatTop;        //If player is touching the top of the platform
	private boolean firstPaint;             //Used to decide if the player's x and y should be reset when redrawing level
	
	
    public boxjumper()
    {
    	      //work in progress
    	
    	//initialize variables
    	level = 1;
    	score = 0;
    	firstPaint = true;
    	x = 0;
		y = 0;
	    	
	    //window size
	    setSize(1000,650);
		setVisible(true);
		
		//background color
		Color skyblue = new Color(0,191,255);
		setBackground(skyblue);
		
		//timer
		ActionListener moveCaller = new ActionListener()
		{
			public void actionPerformed(ActionEvent event, Graphics window)
			{
				movementKeys();              //each time timer fires it will call movementKeys
				repaint();                   //redraw the player
				y += yVelocity;              //move up if you should be moving up
				touchingPlatformTop();       //check if you're touching a platform top
				if(!touchingPlatTop)         //gravity
				{
					yVelocity -= gravity;
				}
			}
		};
		timer = new Timer(SLEEP, moveCaller);
		timer.start();
    }
    
    //Player
    public void player(Graphics window)
    {
    	window.setColor(Color.RED);
    	window.fillRect(x,y,50,50);
    }
    
    public void redraw(Graphics window)
    {
    	player(window);
    }
    
    public void jump()
    {
    	if(touchingPlatTop)
    	{
    	    yVelocity = jumpHeight;
            while(!touchingPlatTop)
            {
            	yVelocity -= gravity;
            	y += yVelocity;
            }
    	}
    }
    
    public boolean touchingPlatformTop()
    {
    	Rectangle c = new Rectangle(x,y,50,50); //Player hitbox
    	
    	/*
    	 *
    	 * Make sure you add your platform tops as rectangles
    	 *
    	 */   
    	//Start of rectangle space
    	if(level == 1)
    	{
    		Rectangle r1 = new Rectangle(1,450,123,199);
    	}
    	//End of rectangle space
    	
    	if(c.intersects(r1))
    		touchingPlatTop = true;
    	else
    		touchingPlatTop = false;
    }
    
    public void levelOne(Graphics window)
    {
    	//Set player location if first render
    	if(firstPaint == true)
    	{
    		x = 25;
    		y = 400;
    	}
    	
    	//Draw starting platform
    	window.setColor(new Color(205,183,158));    //lower platform color
    	window.fillRect(0,451,125,198);             //draw lower platform
    	window.setColor(new Color(154,205,50));     //upper platform color
    	window.fillRect(1,450,123,199);             //draw upper platform
    }
    
    public void paint(Graphics window)
	{
		//redraw background
		window.setColor(new Color(0,191,255));      //skyblue
		window.fillRect(0,0,1000,250);
		
		//redraw HUD
		window.setColor(Color.BLACK);               
		window.drawString("Level "+level,25,50);
		window.drawString("Score: "+score,25,65);

		//redraw player
		window.setColor(Color.RED);
		window.fillRect(x,y+20,80,40);
		
		//redraw level
		if(level == 1)
			levelOne(window);
		/*
		 *  
		 * Add new levels to this as they are made
		 * If your level goes under the background, it's because you didn't do this
		 * 
		 */
	}
}
