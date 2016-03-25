import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class FaceComponent extends JComponent
{
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		JFrame frame = new JFrame();
		frame.setSize(300, 400);
		frame.setTitle("This is a FUCKING FRAME!!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		//g2.setColor(Color.BLUE);
		//g2.drawString("Fuck you Braden! HAHA!", 5, 175);
	}
}
