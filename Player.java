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
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player
{
	private String playerimage = "res/image/playerimage.png";   //player image name

	private int dx;            //x direction
    private boolean ifJumping; //if jumping
    private int x;             //x position
    private int y;             //y position
    private Image image;       //player image


	//player
    public Player()
    {
    	image = new ImageIcon(playerimage).getImage();
    	ifJumping = false;
    	x = 25;
    	y = 400;
    }
    
    public void move(int yVelocity)
    {
    	x += dx;
    	y -= yVelocity;
    }
    
    public int getX()
    {
    	return x;
    }
    
    public int getY()
    {
    	return y;
    }
    
    public boolean getJumping()
    {
    	return ifJumping;
    }
    
	public Image getImage()
	{
        return image;
    }
    
    public void receiveCoords(int newX, int newY)
    {
    	x = newX;
    	y = newY;
    }

	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();

		//Left arrow
		if (key == KeyEvent.VK_LEFT)
		{
            dx = -3;
        }
		//Right arrow
        if (key == KeyEvent.VK_RIGHT)
        {
            dx = 3;
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
