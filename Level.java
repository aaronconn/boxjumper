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
import java.awt.Image;
import java.awt.Font;
import java.awt.geom.Rectangle2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Level extends JPanel implements ActionListener
{
	private Timer timer;
	private Player player; 
	private int yVelocity;
	private int score;
	private int time;
	private boolean touching = true;
	private boolean tp0;
	private boolean tp1;
	private boolean tp2;
	private boolean tp2a;
	private boolean tp2b;
	private boolean tp3;
	private boolean tp4;
	private boolean tp4a;
	private boolean tp4b;
	private boolean tp4c;
	private boolean tp5;
	private boolean tp6;
	private boolean tgf;
	private Image goalsquare;
	private Image platformzero;
	private Image platformone;
	private Image platformtwo;
	private Image platformthree;
	private Image platformfour;
	private Image platformfive;
	

    public Level(int diff)
    {
    	addKeyListener(new TAdapter());
    	setFocusable(true);
    	setBackground(new Color(0,191,255));   //sky blue
    	setDoubleBuffered(true);
    	
    	player = new Player();
    	yVelocity = 0;
    	
    	//import images
    	goalsquare = new ImageIcon("res/image/goalsquareimage.png").getImage();
    	platformzero = new ImageIcon("res/image/PlatformZero.png").getImage();
    	platformone = new ImageIcon("res/image/PlatformOne.png").getImage();
    	platformtwo = new ImageIcon("res/image/PlatformTwo.png").getImage();
    	platformthree = new ImageIcon("res/image/PlatformThree.png").getImage();
    	platformfour = new ImageIcon("res/image/PlatformFour.png").getImage();
    	platformfive = new ImageIcon("res/image/PlatformFive.png").getImage();
    	
    	//start timer
    	timer = new Timer(diff,this);
    	timer.start();
    	
    	if(diff <= 5)
    		time = 999;
    	else
    		time = -8;
    }
    
    public void paint(Graphics window)
    {
        super.paint(window);
        Graphics2D g2d = (Graphics2D)window;
        
        //write score
        window.setColor(new Color(255,215,0));
        window.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
		window.drawString("Score: "+score,25,75);
		if(time > 0)
		{
			window.drawString("Time: "+time,25,90);
			time -= 1;
		}
		if(time == 0)
		{
			die();
			time = 999;
		}
			
		
		//draw platforms
        g2d.drawImage(platformzero, 1, 450, this);
        g2d.drawImage(platformone, 200, 425, this);
        g2d.drawImage(platformtwo, 375, 425, this);
        g2d.drawImage(platformthree, 500, 425, this);
        g2d.drawImage(platformfour, 625, 425, this);
        g2d.drawImage(platformfive, 750, 425, this);
        g2d.drawImage(platformzero, 875, 450, this);
        
        //draw goalsquare
        g2d.drawImage(goalsquare, 929, 401, this);
        
        //draw player
        g2d.drawImage(player.getImage(), player.getX(), player.getY(), this);
        
        Toolkit.getDefaultToolkit().sync();
        window.dispose();
    }
    
    public void collision()
    {
    	Rectangle2D hitbox = new Rectangle(player.getX(), (player.getY() + 20), 25, 5);
    	Rectangle2D r0 = new Rectangle(0,450,125,10);
    	Rectangle2D r1 = new Rectangle(200,425,100,10);
    	Rectangle2D r2a = new Rectangle(400,425,50,10);
    	Rectangle2D r2b = new Rectangle(375,450,25,10);
    	Rectangle2D r3 = new Rectangle(500,425,75,10);
    	Rectangle2D r4a = new Rectangle(625,425,50,10);
    	Rectangle2D r4b = new Rectangle(600,450,25,10);
    	Rectangle2D r4c = new Rectangle(675,450,25,10);
    	Rectangle2D r5a = new Rectangle(750,425,50,10);
    	Rectangle2D r5b = new Rectangle(800,450,25,10);
    	Rectangle2D r6 = new Rectangle(875,450,125,10);
    	Rectangle2D goal = new Rectangle(929,401,49,49);
    	
    	if(hitbox.intersects(r0))
    		tp0 = true;
    	else
    		tp0 = false;
    	
    	if(hitbox.intersects(r1))
    		tp1 = true;
    	else
    		tp1 = false;
    		
    	if(hitbox.intersects(r2a) || hitbox.intersects(r2b))
    	{
    		tp2 = true;
    		if(hitbox.intersects(r2a))
    			tp2a = true;
    		if(hitbox.intersects(r2b))
    			tp2b = true;
    	}
    	else
    	{
    		tp2 = false;
    		tp2a = false;
    		tp2b = false;
    	}
    	
    	if(hitbox.intersects(r3))
    		tp3 = true;
    	else
    		tp3 = false;
    	
    	if(hitbox.intersects(r4a) || hitbox.intersects(r4b) || hitbox.intersects(r4c))
    	{
    		tp4 = true;
    		if(hitbox.intersects(r4a))
    			tp4a = true;
    		if(hitbox.intersects(r4b))
    			tp4b = true;
    		if(hitbox.intersects(r4c))
    			tp4c = true;
    	}
    	else
    	{
    		tp4 = false;
    		tp4a = false;
    		tp4b = false;
    		tp4c = false;
    	}
    	
    	if(hitbox.intersects(r5a) || hitbox.intersects(r5b))
    	{
    		tp5 = true;
    	}
    	else
    	{
    		tp5 = false;
    	}
    			
    	if(hitbox.intersects(r6))
    		tp6 = true;
    	else
    		tp6 = false;
    	
    	if(hitbox.intersects(goal))
    		tgf = true;
    	else
    		tgf = false;
    	
    	if(tp0 || tp1 || tp2 || tp3 || tp4 || tp5 || tp6)
    	{
    		touching = true;
    	}
    	else
    	{
    		touching = false;
    	}
    	if((player.getY() > 450) && (tp0 || tp2b || tp4b || tp6))
    		player.receiveCoords(player.getX(), 450);
    	if((player.getY() > 425) && (tp1 || tp2a || tp4a || tp4c))
    		player.receiveCoords(player.getX(), 425);
    	if((player.getY() > 450) && tp5)
    		player.receiveCoords(player.getX(), 450);
    }
    
    public void actionPerformed(ActionEvent e)
    {
    	collision();
    	if(touching)
    	{
    		player.receiveCoords(player.getX(), (player.getY() + 5));
    		yVelocity = 20;
    	}
    	if(!touching)
    		yVelocity -= 1;
    	
    	if(tgf)
    	{
    		score += 1;
    		yVelocity = 0;
    		player.receiveCoords(25,400);
    	}
    	
    	if(player.getX() <= 1)
    		player.receiveCoords(2, player.getY());
    	if(player.getX() >= 949)
    		player.receiveCoords(948, player.getY());
    	if(player.getY() <= 1)
    	{
    		player.receiveCoords(player.getX(), 2);
    	}
    	if(player.getY() >= 599)
    	{
    		die();
    	}
    	
    	if(yVelocity <= -15)
    		yVelocity = -15;
        player.move(yVelocity);
        repaint(); 
    }
    
    public void die()
    {
    	yVelocity = 0;
		score = 0;
		player.receiveCoords(25, 400);
		if(time > 0)
			time = 999; 
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
