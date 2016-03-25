import javax.swing.*;
import java.awt.*;

//extends, so it draws on JCompenent//inhereting everything JCompoenent has
public class CarComponent extends JComponent {

    private CarShape m;
    private int x = 0;
    private int y = 0;
    
    public CarComponent(CarShape m) {
	   this.m = m;
	   setPreferredSize(m.getSize());
    }

    //overwriting paintComponent
    //says "If you need paintComponent, use my method"
    public void paintComponent(Graphics g) {

	Graphics2D g2 = (Graphics2D)g;
	m.draw(g2);

    }
}

    
