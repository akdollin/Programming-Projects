//***************************************
// This is the GUI class for the Dijkstra GUI.
//This class constructs the frame and draws it using the 
//results from calling the Kruskal algorithm on the FileReader objects
//Akiva Dollin-acd2164
//****************************************
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class KruskalGUI
{
	public Kruskal k; //instance of Kruskal
	public JPanel cityPanel;
	public JTextField distance;
	public JTextField path;
	
	public KruskalGUI(FileReader reader)
	{
		//instantiate Kruskal to compute MST
		k = new Kruskal(reader);
		//new frame
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(800, 800));
		frame.setLayout(new BorderLayout());
		frame.setTitle("Kruskal MST");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//panel with info
		JPanel dataPanel = new JPanel(new GridLayout(1,2));
		//distance field with final distance computed
		distance = new JTextField(20); //text
		JTextArea distanceArea = new JTextArea(5,5);
		distance.setText("Final Weight of MST");
		distance.setFont(new Font("TimesRoman", Font.BOLD, 16));
		//label for text field
		JLabel distanceLabel = new JLabel("Final Weight");
		distanceLabel.setFont(new Font("TimesRoman", Font.BOLD, 16));
		distance.setText(""+k.getDistance());
		//add to panel
		dataPanel.add(distanceLabel,new BorderLayout().WEST);
		dataPanel.add(distance,new BorderLayout().WEST);
		//panel for graphic
		cityPanel = new JPanel();
		//border to see the edges of the map
		Border blueLine = BorderFactory.createLineBorder(Color.pink);
		cityPanel.setBorder(blueLine);
		cityPanel.setLayout(new BoxLayout(cityPanel, BoxLayout.PAGE_AXIS));
		//call component with paint()
		MSTComponent draw = new MSTComponent(reader,k);
		cityPanel.add(draw);
		//scroller to see whole graphic
        JScrollPane scroller = new JScrollPane(cityPanel);
        scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroller.setPreferredSize(new Dimension(200,200));
        scroller.setBackground(Color.BLUE);
		//add scroller and distance panels
        frame.add(scroller, BorderLayout.CENTER);
		frame.add(dataPanel, new BorderLayout().NORTH);

		frame.pack();
		frame.setVisible(true);
	}
}