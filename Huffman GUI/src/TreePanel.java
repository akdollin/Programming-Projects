import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class TreePanel extends JPanel 
{
	//HuffmanCode huff;
	public Node root;
	public int panelWidth;
	public int panelHeight;
	public int ovalWidth = 40; 
	public int ovalHeight = 40;
	public Graphics graph;
	public int finalNodeCount;
	public int numberNodes;
	public int seperation=20;

	public TreePanel(Node root, int panelWidth, int panelHeight) 
	{
		this.root = root;
		this.panelWidth = panelWidth;
		this.panelHeight = panelHeight;

		setBackground(Color.white);
		setForeground(Color.black);
	}
	public void paintComponent(Graphics graph) 
	{
		graph.setColor(getBackground());
		graph.fillRect(0, 0, getWidth(), getHeight());
		graph.setColor(getForeground());

		revalidate();

		numberNodes = 0;
		finalNodeCount = 0;
		getfinalNodeCount(this.root); 
		drawTree(graph,this.root,0, "", panelWidth/2, panelHeight-5);
	}
	//traverses tree and finds number of nodes
	public void getfinalNodeCount(Node root) 
	{
		if (root != null) 
		{
			getfinalNodeCount(root.right);
			getfinalNodeCount(root.left); 
			finalNodeCount++;
		}
	}

	public int drawTree(Graphics graph,Node root, int depth, String huffCode, int width, int height)
	{
		int w = width;
		int h= height;
		int cordX;
		int cordY;

		//to avoid overlap
		int overlapFix = (numberNodes / finalNodeCount) * (panelWidth - (2*seperation) - ovalWidth);
		//redefine the points
		cordX = (seperation + overlapFix)*10;
		cordY = (seperation + depth*ovalHeight)*2;
		//draw tree recursively
		if (root.left!= null)
		{
			w = w-cordX;
			h = h - cordY;
			drawTree(graph, root.left,depth + 1, huffCode + "0",w,h );
		}
		if (root.right!= null)
		{
			w = w+cordX;
			h = h - cordY;
			drawTree(graph, root.right,depth + 1, huffCode + "1",w,h);
		}
		else
		{
			if(root.left != null && root.right != null)   //tree
			{ 
				graph.drawOval(width, height, ovalWidth, ovalHeight);

				graph.drawString(Character.toString(root.element), width + 5, (height - (ovalHeight/2)));
				graph.drawString(huffCode, width + 5, height - ovalHeight - 10);
				graph.drawLine(width, width+cordX,height, height+height);

			} 
			else
			{
				graph.drawOval(cordX, cordY, ovalWidth, ovalHeight);
				graph.drawString("" + root.frequency+"", cordX + 5, (cordY - (ovalHeight/2)));
			}

			numberNodes++;

			}

		return cordX;
	}
}