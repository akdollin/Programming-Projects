import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComponentTester 
{

    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    
    public static CarComponent carPanel;
    public static CarShape carShape;
    private static JButton leftButton;
    private static JButton rightButton;
    private static JFrame frame;
    private static JPanel panel;
    private static int xmax = 80;
    
    public static void main(String[] args){
		frame = new JFrame();

		carShape = new CarShape(0,0,100);
		carPanel = new CarComponent(carShape);
	
		leftButton = new JButton("Go left");
		leftButton.addActionListener(new MovingButtonListener(LEFT,carShape,carPanel));
	
		rightButton = new JButton("Go right");
		rightButton.addActionListener(new MovingButtonListener(RIGHT,carShape,carPanel));
	
		panel = new JPanel();

		panel.setLayout(new FlowLayout());
	
		panel.add(leftButton);
		panel.add(rightButton);
	
		frame.setLayout(new BorderLayout());
		frame.add(carPanel,BorderLayout.CENTER);
		frame.add(panel,BorderLayout.SOUTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
    }
}
 
class MovingButtonListener implements ActionListener{
    
    int direction;
    CarShape carShape;
    CarComponent carPanel;

    public MovingButtonListener(int direction, CarShape carShape,CarComponent carPanel) {
		this.direction = direction;
		this.carShape = carShape;
		this.carPanel = carPanel;
    }

    public void actionPerformed(ActionEvent event) {
		if(direction==ComponentTester.LEFT) {
		    carShape.translate(-10,0);
		} else if(direction==ComponentTester.RIGHT) {
		    carShape.translate(10,0);
		}
		carPanel.repaint();
    }
}
