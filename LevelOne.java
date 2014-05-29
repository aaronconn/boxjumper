/**
 * LevelOne.java  12/5/2014
 *
 * @author - Aaron Conn
 * @author - Chris Best
 * @author - Preeti Singh
 * @version 1.00 13/5/2014
 *
 */
 
package boxjumper;


import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;


public class LevelOne extends Canvas
{
    public LevelOne()
    {
    	setSize(1000,650);
        setBackground(new Color(0,191,255));
        setVisible(true);
    }
    
    public void paint( Graphics window )
    {
      levelOne(window);
    }
    
    public void levelOne(Graphics window)
    {
    	//Starting platform
    	window.setColor(new Color(155,118,83));     //lower platform color
    	window.fillRect(0,450,125,200);             //draw lower platform
    	window.setColor(new Color(154,205,50));     //upper platform color
    	window.fillRect(0,450,125,10);              //draw upper platform
    	
    	//Platform 1
    	window.setColor(new Color(155,118,83));     //lower platform
    	window.fillRect(200,425,100,25);
    	window.fillRect(225,450,50,25);
    	window.setColor(new Color(154,205,50));     //upper platform
    	window.fillRect(200,425,100,10);
    	
    	//Platform 2
    	window.setColor(new Color(155,118,83));     //lower platform
    	window.fillRect(400,425,50,25);
    	window.fillRect(375,450,75,25);
    	window.setColor(new Color(154,205,50));     //upper platform
    	window.fillRect(400,425,50,10);
    	window.fillRect(375,450,25,10);
    	
    	//Platform 3
    	window.setColor(new Color(155,118,83));     //lower platform
    	window.fillRect(500,425,75,25);
    	window.fillRect(500,450,25,25);
    	window.setColor(new Color(154,205,50));     //upper platform
    	window.fillRect(500,425,75,10);
    	
    	//Platform 4
    	window.setColor(new Color(155,118,83));     //lower platform
    	window.fillRect(625,425,50,25);
    	window.fillRect(600,450,100,25);
    	window.setColor(new Color(154,205,50));     //upper platform
    	window.fillRect(625,425,50,10);
    	window.fillRect(600,450,25,10);
    	window.fillRect(675,450,25,10);
    	
    	//Platform 5
    	window.setColor(new Color(155,118,83));     //lower platform
    	window.fillRect(750,425,50,25);
    	window.fillRect(775,450,50,25);
    	window.setColor(new Color(154,205,50));     //upper platform
    	window.fillRect(750,425,50,10);
    	window.fillRect(800,450,25,10);
    	
    	//Ending platform
    	window.setColor(new Color(155,118,83));     //lower platform
    	window.fillRect(875,450,125,200);
    	window.setColor(new Color(154,205,50));     //upper platform
    	window.fillRect(875,450,125,10);
    }
}
