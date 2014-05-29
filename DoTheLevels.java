/**
 * @(#)DoTheLevels.java
 *
 *
 * @author 
 * @version 1.00 2014/5/29
 */
package boxjumper;



import javax.swing.JFrame;

public class DoTheLevels extends JFrame
{
    public DoTheLevels()
    {
    	super("DoTheLevels");
		setSize(1000,650);
						
		getContentPane().add(new LevelOne());
				
		setVisible(true);
    }
    
    public static void main(String[] args)
    {
        DoTheLevels run = new DoTheLevels();
    }
}
