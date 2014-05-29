/**
 * Level.java  12/5/2014
 *
 * @author - Aaron Conn
 * @author - Chris Best
 * @author - Preeti Singh
 * @version 1.00 13/5/2014
 *
 */
 
package boxjumper;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.ArrayList;

public class Level extends JPanel implements ActionListener
{
	private Timer timer;
	private Player player; 
	private int levelNumber;
	
    public Level()
    {
    	addKeyListener(new TAdapter());
    	setFocusable(true);
    	setBackground(new Color(0,191,255));   //sky blue
    	setDoubleBuffered(true);
    	
    	player = new Player();
    	levelNumber = 1;
    	
    	timer = new Timer(5,this);
    	timer.start();
    }
    
    public void paint(Graphics window)
    {
        super.paint(window);

        Graphics2D g2d = (Graphics2D)window;
        g2d.drawImage(player.getLevelImage(), 0, 0, this);
        g2d.drawImage(player.getImage(), player.getX(), player.getY(), this);
        Toolkit.getDefaultToolkit().sync();
        window.dispose();
    }
    
    public void actionPerformed(ActionEvent e)
    {
    	if((player.getY == 1) && player.getBounds.intersects(new Rectangle(0,451,125,200)))
    	{
    		
    	}
        player.move();
        repaint(); 
    }
    
    private class TAdapter extends KeyAdapter
    {
        public void keyReleased(KeyEvent e)
        {
            player.keyReleased(e);
        }

        public void keyPressed(KeyEvent e)
        {
            player.keyPressed(e);
        }
    }
}
