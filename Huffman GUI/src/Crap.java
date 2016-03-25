//import javax.swing.*;
//import javax.swing.event.*;
//import java.awt.*;
//
//public class TreePanel extends JPanel 
//{
//	//HuffmanCode huff;
//	public Node root;
//	public int panelWidth;
//	public int panelHeight;
//	public int ovalWidth = 40; 
//	public int ovalHeight = 40;
//	public Graphics g;
//	public int finalNodeCount;
//	public int numberNodes;
//	public int seperation=20;
//
//	public TreePanel(Node root, int panelWidth, int panelHeight) 
//	{
//		this.root = root;
//		this.panelWidth = panelWidth;
//		this.panelHeight = panelHeight;
//		
//		setBackground(Color.white);
//		setForeground(Color.black);
//	}
//	public void paintComponent(Graphics graph) 
//	{
//		graph.setColor(getBackground());
//		graph.fillRect(0, 0, getWidth(), getHeight());
//		graph.setColor(getForeground());
//		
//		revalidate();
//		
//		numberNodes = 1;
//		finalNodeCount = 0;
//		getfinalNodeCount(this.root); 
//		drawTree(graph,this.root,0, "");
//	}
//	//traverses tree and finds number of nodes
//	public void getfinalNodeCount(Node root) 
//	{
//		if (root != null) 
//		{
//			getfinalNodeCount(root.right);
//			getfinalNodeCount(root.left); 
//			finalNodeCount++;
//		}
//	}
//	
//	public int drawTree(Graphics graph,Node root, int depth, String huffCode)
//	{
//		int cordX=0;
//		int cordY;
//		int leftSide;
//		int rightSide;
//
//		//draw tree recursively
//		if (root != null)
//		{
//			leftSide = drawTree(graph, root.right,depth + 1, huffCode + "1");
//
//			//to avoid overlap
//			int overlapFix = (numberNodes / finalNodeCount) * (panelWidth - (2*seperation) - ovalWidth);
//			//redefine the points
//			cordX = (seperation + overlapFix)*10;
//			cordY = (seperation + depth*ovalHeight)*2;
//
//			if(root.left != null && root.right != null)   //tree
//			{ 
//				graph.drawOval(cordX, cordY, ovalWidth, ovalHeight);
//
//				graph.drawString(Character.toString(root.element) + " : " + root.frequency, cordX + 5, cordY + 15);
//				graph.drawString(huffCode, cordX + ovalHeight + 15, cordY + ovalHeight + 15);
//			} 
//			else
//			{
//				graph.drawOval(cordX, cordY, ovalWidth, ovalHeight);
//				graph.drawString(" " + root.frequency, cordX + 15, cordY + 15);
//			}
//
//			numberNodes++;
//			rightSide= drawTree(graph, root.right,depth + 1, huffCode + "0");
//
//			if(root.left!= null) 
//			{
//				leftSide = leftSide + ovalWidth / 2;
//				rightSide = rightSide + ovalWidth / 2;
//
//				graph.drawLine(leftSide,cordY + ovalHeight, rightSide, (cordY + ovalHeight));
//			}
//		}
//		return cordX;
//	}
//}