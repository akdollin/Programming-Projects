import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import javax.swing.*;
import java.awt.*;

public class ProgramTester implements ActionListener 
{
	public static HuffmanCode huffCode;
	// Runs the program and starts the GUI.
	public static void main(String[] args) 
	{
		try
		{
			//does not have two files needed
			if(args.length!=1)
			{
				System.out.println("Please input file name.");
				System.exit(0);
			}
			else
			{
				//save files as File objects
				File file = new File(args[0]);
				huffCode = new HuffmanCode(file);
				//System.out.println(huffCode.decode("11010",huffCode.codedHeap));
//				String s = huffCode.getFinalCode();
//				System.out.println(s);
				ProgramTester gui = new ProgramTester();
				//gui.start();
			}
		}
		catch (FileNotFoundException e) //catch problems with importing file
		{
			e.printStackTrace();
		}
	}

	private JFrame frame;
	private JTextField decodeField, encodeField;
	private JTextArea decodeArea, encodeArea;
	public JButton decode, resetDecode, encode, resetEncode;
	private JLabel encodeStatusLabel;
	//private TreeShape treeShape;

	public ProgramTester() 
	{
		//System.out.println(huff.getFinalCode());
		frame = new JFrame("Huffman GUI Kivi");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//for encoding the string of huffman
		JPanel bottomPanel = new JPanel(new BorderLayout());
		encodeField = new JTextField(20);
		encodeArea = new JTextArea(10, 10);
		encodeField.setText("Enter Characters to be Encoded");

		bottomPanel.add(new JLabel("Enter text based on tree: "), BorderLayout.WEST);
		encode = new JButton("Encode");
		encodeField.addActionListener(this);
		encode.setActionCommand(encodeField.getText());

		bottomPanel.add(encodeField);
		bottomPanel.add(encode, BorderLayout.EAST );

		//decoding the hoffman string
		JPanel rightPanel = new JPanel(new FlowLayout());
		decodeField = new JTextField(20);
		decodeArea = new JTextArea(10, 10);
		decodeField.setText(huffCode.getFinalCode());
		rightPanel.add(decodeField);
		String buttonText = "Decode";
		decode = new JButton(buttonText);
		decode.addActionListener(this);
		decode.setActionCommand(decodeField.getText());

		resetDecode = new JButton ("Reset");
		resetDecode.addActionListener(this);
		resetDecode.setActionCommand("Reset");
		
		rightPanel.add(decode);
		rightPanel.add(resetDecode);

		decodeArea = new JTextArea(10, 10);

		// size frame and place it in the center of the screen
		frame.add(bottomPanel,BorderLayout.SOUTH);
		frame.add(rightPanel,BorderLayout.WEST);

		frame.pack();
		frame.setVisible(true);
	}

	// Runs the GUI by displaying its graphical frame.
	public void start() 
	{
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) 
	{
		String action = e.getActionCommand();
		if (action.equals(decodeField.getText())) 
		{	
			decodeField.setText(huffCode.decode(decodeField.getText(),huffCode.getRootNode()));
		}	
		else
		{
			decodeField.setText("Error");
		}
			
		if(action.equals("Reset"))
		{
			decodeField.setText("");
			decodeField.setText(huffCode.encode(huffCode.getRootNode(),decodeField.getText()));
		}
		if(action.equals(encodeField.getText()))
		{
			encodeField.setText("it worked");
		}
	}
}