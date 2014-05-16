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
    	super("Box Jumper Runner");
						
		getContentPane().add(new boxjumper());			
		setVisible(true);
    }
    
    public static void main( String args[] )
	{
		boxjumper run = new boxjumper();
	}
}
