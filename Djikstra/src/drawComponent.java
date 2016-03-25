//***************************************
// This is the drawComponent class for GUI.
//This class creates a component and draws circles, city names
//and lines.
//Akiva Dollin-acd2164
//****************************************
import java.awt.geom.Ellipse2D;
import java.awt.*;
import javax.swing.*; 

public class drawComponent extends JComponent
{
	public CityReader cr; 

	public drawComponent(CityReader map)
	{
		cr=map;
		//set size of component with largest values of dijkstra cities
		setPreferredSize(new Dimension(cr.getWidth()+150,cr.getHeight()+150));
	}
	public void paintComponent(Graphics g)
	{
		//create graphic
		Graphics2D g2 = (Graphics2D) g;
		//draw on component whith graphic
		drawCities(g2);
	}
	private void drawCities(Graphics2D g2) 
	{
		g2.setFont(new Font("TimesRoman", Font.BOLD, 14));
		//look through map of cities
		for(String name: cr.getMap().keySet())
		{
			//draw name..flip points by subtracting from greatest yCord
			g2.drawString(cr.getMap().get(name).name,
					(cr.getMap().get(name).xCord)+50
					,(cr.getHeight()-cr.getMap().get(name).yCord)+50);
			//draw circles
			g2.draw(new Ellipse2D.Double((cr.getMap().get(name).xCord)+50
					,(cr.getHeight()-cr.getMap().get(name).yCord)+50
					,15,15));
			//draw lines based on adjacencies...you do draw extra lines
			for(Edge e : cr.getMap().get(name).adjacencies)
			{
				String target = e.target.name;
				int xOriginal = (cr.getMap().get(name).xCord)+50;
				int yOriginal =(cr.getHeight()-cr.getMap().get(name).yCord)+50;
				int newX = cr.getMap().get(target).xCord+50;
				int newY = (cr.getHeight()-cr.getMap().get(target).yCord)+50;
				
				g2.drawLine(xOriginal,yOriginal,newX,newY);
			}
		}
	}
}