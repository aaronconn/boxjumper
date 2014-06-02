/**
 * boxjumperrunner.java  12/5/2014
 *
 * @author - Aaron Conn
 * @author - Chris Best
 * @author - Preeti Singh
 * @version 1.00 12/5/2014
 *
 */

package boxjumper;

import javax.swing.JFrame;
import java.util.Scanner;

public class boxjumperrunner extends JFrame
{
    public boxjumperrunner()
    {
    	Scanner keyboard = new Scanner(System.in);
    	System.out.println("Choose difficulty (1-10)");
    	int givendifficulty = keyboard.nextInt();
    	keyboard.close();
    	
    	int difficulty = 0;
    	if(givendifficulty == 1)
    		difficulty = 10;
    	
    	if(givendifficulty == 2)
    		difficulty = 9;
    	
    	if(givendifficulty == 3)
    		difficulty = 8;
    	
    	if(givendifficulty == 4)
    		difficulty = 7;
    	
    	if(givendifficulty == 5)
    		difficulty = 6;
    	
    	if(givendifficulty == 6)
    		difficulty = 5;
    	
    	if(givendifficulty == 7)
    		difficulty = 4;
    	
    	if(givendifficulty == 8)
    		difficulty = 3; 
    	
    	if(givendifficulty == 9)
    		difficulty = 2;
    	
    	if(givendifficulty == 10)
    		difficulty = 1;
    	
    	
    	add(new Level(difficulty));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,650);
		setLocationRelativeTo(null);
		setTitle("boxjumper");
		setResizable(false);
		setVisible(true);
    }
    
    public static void main(String[] args)
	{
		new boxjumperrunner();
	}
}
