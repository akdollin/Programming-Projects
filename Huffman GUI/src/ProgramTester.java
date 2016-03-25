//***************************************
// This is the ProgramTester class for the Huffman problem.
//This class takes a file, calls the HuffmanCode to internally build
//the tree, then calls the GUI methods to visually construct
//Akiva Dollin-acd2164
//****************************************
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
	//instance of the tree
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
				//create tree
				huffCode = new HuffmanCode(file);
				//create gui
				ProgramTester gui = new ProgramTester();
			}
		}
		catch (FileNotFoundException e) //catch problems with importing file
		{
			e.printStackTrace();
		}
	}
	//instance variables used for gui
	private JFrame frame;
	private JTextField decodeField, encodeField;
	private JTextArea decodeArea, encodeArea;
	public JButton decode, resetDecode, encodeButton, resetEncode, encode;
	private JLabel encodeStatusLabel;
	private TreePanel treePanel;
	public String temp;

	//methods for creating the GUI
	public ProgramTester() 
	{
		//create frame
		frame = new JFrame("Huffman GUI Kivi");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		treePanel = new TreePanel(huffCode.getRootNode(),100,300);

		//for printing the tree
		treePanel.add(new JLabel("HUFFMAN TREE"), BorderLayout.WEST);
		JScrollPane treeScrollPane = new JScrollPane();
		treeScrollPane.setViewportView(treePanel);

		//decoding the huffman string
		JPanel rightPanel = new JPanel(new FlowLayout()); //panel
		decodeField = new JTextField(20); //text
		decodeArea = new JTextArea(10, 10);
		temp = huffCode.getFinalCode();
		decodeField.setText(huffCode.getFinalCode()); //give it final string
		rightPanel.add(decodeField);
		
		//decode button
		String buttonText = "Decode";
		decode = new JButton(buttonText);
		decode.addActionListener(this);
		decode.setActionCommand(buttonText);

		//reset button for both de and en code
		String resetText = "Reset";
		resetDecode = new JButton (resetText);
		resetDecode.addActionListener(this);
		resetDecode.setActionCommand(resetText);
		
		//button for encode
		String encodeText = "Encode";
		encodeButton = new JButton (encodeText);
		encodeButton.addActionListener(this);
		encodeButton.setActionCommand(encodeText);
		
		//add the buttons to the panel
		rightPanel.add(encodeButton);
		rightPanel.add(decode);
		rightPanel.add(resetDecode);

		frame.add(rightPanel,BorderLayout.NORTH);
		frame.add(treePanel,BorderLayout.CENTER);
		frame.pack();
	
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) 
	{
		String action = e.getActionCommand();
		if (action.equals("Decode"))
		{	
			//correct decode
			if(decodeField.getText().substring(0,1).equals("0") || 
					decodeField.getText().substring(0,1).equals("1"))
			{
				String s = huffCode.decode(decodeField.getText(),
						huffCode.getRootNode());
				decodeField.setText(s);
			}
			else
			{
				decodeField.setText("Error");		
			}

		}	
		//reset button//temp is saved as the initial huff string
		else if(action.equals("Reset"))
		{
			decodeField.setText(temp);

		}
		//encode button
		else if(action.equals("Encode"))
		{
			//try to encode an encoding
			if(decodeField.getText().substring(0,1).equals("0"))
			{
				decodeField.setText("Error");
			}
			//try to encode an encoding
			else if(decodeField.getText().substring(0,1).equals("1"))
			{
				decodeField.setText("Error");
			}
			//try to encode an error
			else if(decodeField.getText().equals("Error"))
			{
				decodeField.setText("Error");
			}
			else
			{
				String s = huffCode.encode(huffCode.getRootNode(),
						decodeField.getText());
				decodeField.setText(s);			
			}
		}
		//somethng bad happens
		else
		{
			decodeField.setText("Error");
		}
	}
}
