//***************************************
// This is the HuffmanCode class for the Huffman problem.
//This class is passed in a file, reads it line by line, and builds
//the tree.
//Akiva Dollin-acd2164
//****************************************
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HuffmanCode 
{
	public int[] counts = new int[256]; // 256 ASCII characters
	public String[] codes = new String[256]; //saves the huffman encodings
	public Node codedHeap;  //the root node of the full tree
	public String finalCode =""; //the final huffman string

	//constructor takes in file, reads it by line
	public HuffmanCode(File file) throws FileNotFoundException
	{
		codes[10]=""; //for the new line character

		Scanner scanner = new Scanner(file);
		while(scanner.hasNextLine()) //determines if there is a next line
		{
			counts[10]++;  //new line character
			String text = scanner.nextLine(); //goes to the next line
			getCharacterFrequency(text);   
		}
		scanner.close();
		//to account for the last line, 
		//which should not include a suffix new line
		counts[10]--;  
		//print the frequencies
		printFrequency(counts);
		//build the tree
		makeTrees(counts);
		//print codes
		getCode(codedHeap);

		//second scanner for encoding the orginal file based on huffman code
		Scanner scanner2 = new Scanner(file);
		while(scanner2.hasNextLine()) //determines if there is a next line
		{
			String originalText = scanner2.nextLine(); //goes to the next line
			encode(codedHeap, originalText);
			finalCode+=codes[10];
		}

		//to account for new line characters
		finalCode = finalCode.substring(0,finalCode.length()
				- codes[10].length());
		scanner2.close();
		//print Huff code
		System.out.println("Huffman String: "+finalCode);
		//print final string
		System.out.println(decode(finalCode,codedHeap));

		System.out.println("Decoded Text: " + decode(finalCode,codedHeap));
	} 
	//accesor method
	public String getFinalCode()
	{
		return finalCode;
	}
	//accesor method
	public Node getRootNode()
	{
		return codedHeap;
	}
	public String[] getCodes()
	{
		return codes;
	}
	public int getHeight(Node root)
	{
		int heightLeft = 0;
		int heightRight = 0;
		if(root.left!=null)
			heightLeft = getHeight(root.left);
		if(root.right!=null)
			heightRight = getHeight(root.right);
		if(heightLeft > heightRight)
		{
			return heightLeft+1;
		}
		else{
			return heightRight+1;
		}
	}
	//decode method, recurses though the root
	public String decode(String huffString,Node root)
	{
		//start with null string
		String decodedText = "";
		//pass in the root
		Node temp = root;
		for(int i = 0;i<huffString.length();i++)
		{
			//then go left down the tree
			if(huffString.charAt(i) == '0')
			{
				temp = temp.left;
				if(temp.left == null && temp.right == null) //base case
				{
					decodedText+= temp.element;
					temp = root;
				}
			}
			else
			{
				//go right if its a 1
				temp = temp.right;
				if(temp.left == null && temp.right == null)
				{
					decodedText+= temp.element;
					temp = root;  
				}
			}
		}
		return decodedText;
	}
	//encodes based on iterating through the array and comparing 
	//it to the letter so far
	public String encode(Node codedHeap2, String text) 
	{
		String huffString="";
		//iterate through the file
		for (int i = 0; i < text.length(); i++)
		{
			//iterate through the freq array
			char c = text.charAt(i);
			huffString += codes[(int) c];
		}
		//instantiate the instance variable
		setFinalCode(huffString);
		return huffString;
	}
	public String setFinalCode(String huffString) 
	{
		finalCode+=huffString;
		return finalCode;
	}
	//two deleteMins() and an insert to create tree
	public Node makeTrees(int[] freqArray) 
	{
		BinaryHeap<Node> heap = new BinaryHeap<Node>(); 
		//create new nodes for each char and insert
		for(int i = 0; i<freqArray.length;i++)
		{	
			if(freqArray[i]>0)
				heap.insert(new Node(freqArray[i],(char) i));
		}
		//only one character
		if(heap.getSize()==1)
		{
			Node a = new Node();
			Node leftDel = heap.deleteMin();
			a.frequency = leftDel.frequency;
			a.left= leftDel;
			heap.insert(a);
		}
		//combines two trees
		while(heap.getSize()>1)
		{
			Node a = new Node();
			Node leftDel = heap.deleteMin();
			Node rightDel = heap.deleteMin();
			a.frequency = leftDel.frequency + rightDel.frequency;
			a.left= leftDel;
			a.right = rightDel;
			heap.insert(a);
		}
		codedHeap=heap.deleteMin();
		return codedHeap;
	}

	//simple print frequency method
	private void printFrequency(int[] freqArray) 
	{
		for(int i = 0; i<freqArray.length;i++)
		{
			if(freqArray[i] != 0)
			{
				//two actually print new line character 
				if(i==10)
				{
					System.out.println("Frequency: /n-->"+freqArray[i]);
				}
				//to print space 
				if(i==32)
				{
					System.out.println("Frequency: sp-->"+freqArray[i]);
				}
				else if(i != 10)
				{
					System.out.println("Frequency: "+ 
							(char) i + "-->"+freqArray[i]);
				}
			}
		}
	}
	//iterates through the text and converts each to ASCII code
	//array is size of all ascii values
	public int[] getCharacterFrequency(String text)
	{
		for (int i = 0; i < text.length(); i++)
			counts[(int) text.charAt(i)]++; // Count the character in text
		return counts;
	}

	//searches through tree and returns array of codes of the characters
	public void getCode(Node root) 
	{
		if(root == null)
			throw new UnderflowException("Underflow");
		else
			getCode(root,"");
	}
	//add you recurse, add to each lines code
	private void getCode(Node n, String code)
	{
		if(n.left != null)   //not a leaf
		{
			//whenever you go left
			getCode(n.left, code+"0");
			//right
			if(n.right != null)
			{
				getCode(n.right, code+"1");
			}		
		}
		else  //its a leaf
		{
			//save code for later use
			codes[(int) n.element] = code;
			//new line char
			if((int) n.element== 10)
			{
				System.out.println("HuffCode:/n-->" + code);
			}
			//sp char
			if((int) n.element == 32)
			{
				System.out.println("HuffCode: sp-->" + code);
			}
			else if ((int) n.element != 10)
			{
				System.out.println("HuffCode: "+n.element + "-->"+ code);
			}
		}
	}
}  
