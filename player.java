/**
 * boxjumper.java  12/5/2014
 *
 * @author - Aaron Conn
 * @author - Chris Best
 * @author - Preeti Singh
 * @version 1.00 13/5/2014
 *
 */
package boxjumper;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList
import java.swing.ImageIcon;

public abstract class player
{
	private String playerimage = "playerimage.png";   //player image name
	
	private int dx;            //
    private int dy;            //
    private int x;             //x position
    private int y;             //y position
    private int width;         //image width
    private int height;        //image height
    private boolean visible;   //if visible
    private Image image;       //player image
	
	
	//player
    public player()
    {
    	ImageIcon ii = new ImageIcon(this.getClass().getResource(playerimage));
    	image = ii.getImage();
    	x = 0;
    	y = 0;
    }
    
    public moving()
    {
    	x += dx;
    	y += dx;
    }
    
    public getX()
    {
    	return x;
    }
    
    public getY()
    {
    	return y;
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
