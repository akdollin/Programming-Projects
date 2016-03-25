//***************************************
// This is the DijkstraGUI class.
//This class creates a frame with button, fields,
//combo boxes, and one panel for the map.a
//Akiva Dollin-acd2164
//****************************************
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.*;
import javax.swing.border.Border;

public class DijkstraGUI  implements ActionListener
{
	//instance of CityReader
	public Dijkstra d;
	public CityReader cr;
	public JTextField distance,path;
	public JPanel cityPanel;
	public JButton pathReset;

	public DijkstraGUI(CityReader reader)
	{
		cr = reader;
		//create frame
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(800, 800));
		frame.setLayout(new BorderLayout());
		frame.setTitle("Dijkstra's Algorithm");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//labels for comboBoxes
		JLabel sourceLabel = new JLabel("Source");
		sourceLabel.setFont(new Font("TimesRoman", Font.BOLD, 14));
		JLabel targetLabel = new JLabel("Target");
		targetLabel.setFont(new Font("TimesRoman", Font.BOLD, 14));

		//put names in combo boxes
		Set<String> setCities = cr.getMap().keySet();
		String[] targetCities = 
				setCities.toArray(new String[setCities.size()]);
		//combo box for target
		JComboBox targetList = new JComboBox(targetCities);
		targetList.setSelectedIndex(-1);
		targetList.addActionListener((ActionListener) this);
		targetList.setActionCommand("Target");
		//comboBox for source
		JComboBox sourceList = new JComboBox(targetCities);
		sourceList.setSelectedIndex(-1);
		sourceList.addActionListener((ActionListener) this);
		sourceList.setActionCommand("Source");

		//panel for boxes
		JPanel buttonPanel = new JPanel(new GridLayout(2,1));
		buttonPanel.setFocusable(true);
		buttonPanel.add(sourceLabel,new BorderLayout().WEST);
		buttonPanel.add(sourceList,new BorderLayout().EAST);
		buttonPanel.add(targetLabel,new BorderLayout().WEST);
		buttonPanel.add(targetList,new BorderLayout().EAST);
		buttonPanel.setBackground(Color.GREEN);

		//panel for the TextFields
		JPanel dataPanel = new JPanel(new GridLayout(3,2));
		//too print distance 
		distance = new JTextField(20); //text
		JTextArea distanceArea = new JTextArea(5,5);
		distance.setText("Choose two cities");
		//to print path
		path = new JTextField(20); 
		JTextArea pathArea = new JTextArea(50,5);
		path.setText("Choose two cities");
		//label textFields
		JLabel distanceLabel = new JLabel("Final Distance");
		distanceLabel.setFont(new Font("TimesRoman", Font.BOLD, 14));
		//label textFields
		JLabel pathLabel = new JLabel("Path");
		pathLabel.setFont(new Font("TimesRoman", Font.BOLD, 14));

		//button to show Dijkstra path
		String buttonText = "Show Updated Map";
		pathReset = new JButton(buttonText);
		pathReset.addActionListener(this);
		pathReset.setActionCommand(buttonText);
		//reset map to full map
		String reset = "Reset";
		JButton resetMap = new JButton (reset);
		resetMap.addActionListener(this);
		resetMap.setActionCommand(reset);

		dataPanel.add(pathReset,new BorderLayout().NORTH);
		dataPanel.add(resetMap,new BorderLayout().NORTH);
		dataPanel.add(distanceLabel,new BorderLayout().SOUTH);
		dataPanel.add(distance,new BorderLayout().SOUTH);
		dataPanel.add(pathLabel,new BorderLayout().SOUTH);
		dataPanel.add(path,new BorderLayout().SOUTH);
		dataPanel.setBackground(Color.GREEN);

		//panel for map
		cityPanel = new JPanel();
		//add border to see the edges of map...use for scrolling
		Border blueLine = BorderFactory.createLineBorder(Color.pink);
		cityPanel.setBackground(Color.YELLOW);
		cityPanel.setBorder(blueLine);
		cityPanel.setLayout(new BoxLayout(cityPanel, BoxLayout.PAGE_AXIS));
		//call the draw component which paints the panel
		drawComponent draw = new drawComponent(cr);
		cityPanel.add(draw);

		//scroll pane to see the entire map
		//add the cityPanel to scroller to see the map
		JScrollPane scroller = new JScrollPane(cityPanel);
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroller.setPreferredSize(new Dimension(200,200));
		scroller.setBackground(Color.BLUE);

		//add elements to frame
		frame.add(scroller, BorderLayout.CENTER);
		frame.add(buttonPanel, new BorderLayout().NORTH);
		frame.add(dataPanel, new BorderLayout().SOUTH);

		frame.pack();
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) 
	{
		//use instance of dijkstra to use buttons
		d = new Dijkstra(cr);

		String action = e.getActionCommand();
		if(action.equals("Target"))
		{
			//to change map based on target
			JComboBox cb = (JComboBox)e.getSource();
			String targetCityName = (String)cb.getSelectedItem();
			d.updateTarget(targetCityName);
			d.run(cr); //from dijkstra algorithm
			updatePathandDistance(); //update textFields
		}
		if(action.equals("Source"))
		{
			//change map based on source
			JComboBox cb = (JComboBox)e.getSource();
			String sourceCityName = (String)cb.getSelectedItem();
			d.updateSource(sourceCityName);
			d.run(cr);
			updatePathandDistance();
		}
		if(action.equals("Show Updated Map"))
		{
			//insert new lines onto the map
			if(!d.source.equals("") && !d.target.equals(""))
			{
				newComponent updateDijkstra = new newComponent(cr,d);
				cityPanel.setVisible(false); //to change panels
				cityPanel.removeAll(); //clear panel
				cityPanel.add(updateDijkstra); //update to new map
				cityPanel.setVisible(true); 
			}
		}
		if(action.equals("Reset"))
		{
			//to see original map again
			drawComponent draw = new drawComponent(cr);
			cityPanel.setVisible(false);
			cityPanel.removeAll(); //clear panel
			cityPanel.add(draw); //add original map
			cityPanel.setVisible(true);
		}
	}
	private void updatePathandDistance() 
	{
		distance.setText(""+d.getDistance());
		path.setText(""+d.getPath());
	}
}