//***************************************
// This is the drawComponent class for GUI.
//This class creates a component and draws circles, city names
//and lines.
//Akiva Dollin-acd2164
//****************************************
import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*; 

public class newComponent extends JComponent
{
	public CityReader cr; 
	public Dijkstra path;

	//add constructor parameters for width and height
	public newComponent(CityReader map,Dijkstra d)
	{
		cr=map;
		d = path;

		//set size
		setPreferredSize(new Dimension(cr.getWidth()+150,cr.getHeight()+150));
	}
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;

		drawCities(g2);
	}
	private void drawCities(Graphics2D g2) 
	{
		g2.setFont(new Font("TimesRoman", Font.BOLD, 14));
		//use path to draw cities
		for(int i = 0; i < path.finalPath.size()-1;i++)
		{
			g2.drawString(path.finalPath.get(i).name,
					(path.finalPath.get(i).xCord)+50
					,(cr.getHeight()-path.finalPath.get(i).yCord)+50);

			g2.draw(new Ellipse2D.Double((path.finalPath.get(i).xCord)+50,
					(cr.getHeight()-path.finalPath.get(i).yCord)+50,15,15));

			g2.drawLine(path.finalPath.get(i).xCord+50,
					(cr.getHeight()-path.finalPath.get(i).yCord)+50,
					path.finalPath.get(i+1).xCord+50,
					(cr.getHeight()-path.finalPath.get(i+1).yCord)+50);
		}
		
		//draw the last city
		g2.drawString(path.finalPath.get(path.finalPath.size()-1).name,
				(path.finalPath.get(path.finalPath.size()-1).xCord)+50
				,(cr.getHeight()-path.finalPath.get(
						path.finalPath.size()-1).yCord)+50);

		g2.draw(new Ellipse2D.Double((path.finalPath.get(
				path.finalPath.size()-1).xCord)+50,
				(cr.getHeight()-path.finalPath.get(
						path.finalPath.size()-1).yCord)+50,15,15));	
	}

}