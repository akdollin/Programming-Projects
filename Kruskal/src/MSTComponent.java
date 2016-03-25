//***************************************
// This is the Component class for the Dijkstra GUI.
//This class draws the MST. 
//Akiva Dollin-acd2164
//****************************************
import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

public class MSTComponent extends JComponent
{
	//uses the MST from Kruskal and the Max y value from Reader
	public FileReader fr; 
	public Kruskal k;
	private static final long serialVersionUID = 1L;

	public MSTComponent(FileReader fr, Kruskal k)
	{
		this.fr = fr;
		this.k = k;
		//set size with max x and y from file
		setPreferredSize(new Dimension(fr.maxWidth+150,fr.maxHeight+150));
	}

	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		//use draw method to draw map
		draw(g2);
	}
	
	public void draw(Graphics g) 
	{
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setFont(new Font("TimesRoman", Font.BOLD, 14));
		//for every edge, draw the two points, 
		//their names and the edge between then
		for (Edge e : k.MSTree)
		{
			String name1 = e.point1.name;
			String name2 = e.point2.name;
			int xCord1 = e.point1.xCord + 50;
			//subract from max y to account for weird data
			int yCord1 = (fr.maxHeight - e.point1.yCord) + 50;
			int xCord2 = e.point2.xCord + 50;
			int yCord2 = (fr.maxHeight - e.point2.yCord) + 50;
			//draw the names
			g2.drawString(name1,xCord1,yCord1);
			g2.drawString(name2,xCord2,yCord2);
			//circles
			g2.draw(new Ellipse2D.Double(xCord1, yCord1, 10, 10));
			g2.draw(new Ellipse2D.Double(xCord2, yCord2, 10, 10));
			//lines connecting the MST
			g2.drawLine(xCord1,yCord1,xCord2,yCord2);
		}
	}
}