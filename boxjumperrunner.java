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

public class boxjumperrunner extends JFrame
{
    public boxjumperrunner()
    {
    	add(new Level());
						
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,650);
		setLocationRelativeTo(null);
		setTitle("Boxjumper");
		setResizable(false);
		setVisible(true);
    }
    
    public static void main(String[] args)
	{
		new boxjumperrunner();
	}
}
