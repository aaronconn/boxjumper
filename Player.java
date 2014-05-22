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
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Player
{
	private String playerimage = "playerimage.gif";   //player image name
	
	private int dx;            //x direction
    private int dy;            //if jumping
    private int x;             //x position
    private int y;             //y position
    private int width;         //image width
    private int height;        //image height
    private boolean visible;   //if visible
    private Image image;       //player image
	
	
	//player
    public Player()
    {
    	image = (this.getClass().getResource(playerimage)).getImage;
    	x = 0;
    	y = 0;
    }
    
    public void move()
    {
    	x += dx;
    }
    
    public int getX()
    {
    	return x;
    }
    
    public int getY()
    {
    	return y;
    }
    
	public Image getImage()
	{
        return image;
    }
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		//Left arrow
		if (key == KeyEvent.VK_LEFT)
		{
            dx = -8;
        }
		//Right arrow
        if (key == KeyEvent.VK_RIGHT)
        {
            dx = 8;
        }
		//Up arrow
        if (key == KeyEvent.VK_UP)
        {
            dy = 1;
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
            dy = 0;
        }
	}
}
