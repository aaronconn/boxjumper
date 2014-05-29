/**
 * Player.java  12/5/2014
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
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Player
{
	private String playerimage = "playerimage.png";   //player image name
	
	private int dx;            //x direction
    private boolean ifJumping; //if jumping
    private int x;             //x position
    private int y;             //y position
    private int width;         //image width
    private int height;        //image height
    private int level;
    private boolean visible;   //if visible
    private Image image;       //player image
    private Image levelImage;  //level image
	
	
	//player
    public Player()
    {
    	image = new ImageIcon(playerimage).getImage();
    	level = 1;
    	x = 25;
    	y = 400;
    }
    
    public void move()
    {
    	x += dx;
		
    }
    
    public updateLevelImage(int newLevel)
    {
    	level = newLevel;
    	if(level == 1)
    	{
    		
    	}
    }
    
    public int getX()
    {
    	return x;
    }
    
    public int getY()
    {
    	return y;
    }
    
    public Image getLevelImage()
    {
    	return levelImage;
    }
    
	public Image getImage()
	{
        return image;
    }
    
    public Rectangle getBounds()
    {
        return new Rectangle(x, y, width, height);
    }
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		//Left arrow
		if (key == KeyEvent.VK_LEFT)
		{
            dx = -2;
        }
		//Right arrow
        if (key == KeyEvent.VK_RIGHT)
        {
            dx = 2;
        }
		//Up arrow
        if (key == KeyEvent.VK_UP)
        {
            ifJumping = true;
        }
	}
	
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		//Left arrow
		if (key == KeyEvent.VK_LEFT)
		{
            dx = 0;
        }
		//Right arrow
        if (key == KeyEvent.VK_RIGHT)
        {
            dx = 0;
        }
		//Up arrow
        if (key == KeyEvent.VK_UP)
        {
            ifJumping = false;
        }
	}
}
