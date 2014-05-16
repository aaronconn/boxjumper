/**
 * move.java  16/5/2014
 *
 * @author - Aaron Conn
 * @author - Chris Best
 * @author - Preeti Singh
 * @version 1.00 16/5/2014
 *
 */

package boxjumper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class move implements keyListener
{
	private int x;      //x position
	private int y;      //y position
	
    public move()
    {
    	addKeyListener(new )
    }
    
    public void movementKeys()
    {
	   	if (event.getKeyCode() == KeyEvent.VK_UP)
	   	{
	   		jump(); //jump
	   	}
	   	if (event.getKeyCode() == KeyEvent.VK_LEFT)
	   	{
	   		x -= speed; //move left
	   	}
	   	if (event.getKeyCode() == KeyEvent.VK_RIGHT)
	   	{
	   		x += speed; //move right
	   	}
    }
    
    private class TAdapter extends KeyAdapter
    {
    	public void keyReleased(KeyEvent e)
    	{
    		boxjumper
    	}
    	
    	public void keyPressed(KeyEvent e)
    	{
    		
    	}
    }
}
