import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HuffmanCode 
{
	public int[] counts = new int[256]; // 256 ASCII characters
	public String[] codes = new String[256];
	public Node codedHeap;
	public String finalCode ="";

	public HuffmanCode(File file) throws FileNotFoundException
	{
		codes[10]="";

		Scanner scanner = new Scanner(file);
		while(scanner.hasNextLine()) //determines if there is a next line
		{
			counts[10]++;
			String text = scanner.nextLine(); //goes to the next line
			getCharacterFrequency(text);
		}
		scanner.close();
		counts[10]--;
		printFrequency(counts);
		makeTrees(counts);
		getCode(codedHeap);

		Scanner scanner2 = new Scanner(file);
		while(scanner2.hasNextLine()) //determines if there is a next line
		{
			String originalText = scanner2.nextLine(); //goes to the next line
			encode(codedHeap, originalText);
			finalCode+=codes[10];
		}

		//over 80 characters
		finalCode = finalCode.substring(0,finalCode.length() - codes[10].length());
		scanner2.close();
		System.out.println("Huffman String: "+finalCode);
		System.out.println("Decoded Text: " + decode(finalCode,codedHeap));
	} 
	public String getFinalCode()
	{
		return finalCode;
	}
	public Node getRootNode()
	{
		return codedHeap;
	}
	public String decode(String huffString,Node root)
	{
		String decodedText = "";
		Node temp = root;
		for(int i = 0;i<huffString.length();i++)
		{
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


	public String encode(Node codedHeap2, String text) 
	{
		for (int i = 0; i < text.length(); i++)
		{
			char c = text.charAt(i);
			finalCode += codes[(int) c];
		}
		return finalCode;
	}

	public Node makeTrees(int[] freqArray) 
	{
		BinaryHeap<Node> heap = new BinaryHeap<Node>(); 

		for(int i = 0; i<freqArray.length;i++)
		{	
			if(freqArray[i]>0)
				heap.insert(new Node(freqArray[i],(char) i));
		}
		if(heap.getSize()==1)
		{
			Node a = new Node();
			Node leftDel = heap.deleteMin();
			a.frequency = leftDel.frequency;
			a.left= leftDel;
			heap.insert(a);
		}
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

	private void printFrequency(int[] freqArray) 
	{
		for(int i = 0; i<freqArray.length;i++)
		{
			if(freqArray[i] != 0)
			{
				if(i==10)
				{
					System.out.println("Frequency: /n-->"+freqArray[i]);
				}
				if(i==32)
				{
					System.out.println("Frequency: sp-->"+freqArray[i]);
				}
				else if(i != 10)
				{
					System.out.println("Frequency: "+ (char) i + "-->"+freqArray[i]);
				}
			}
		}
	}

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
	private void getCode(Node n, String code)
	{
		if(n.left != null)   //not a leaf
		{
			getCode(n.left, code+"0");

			if(n.right != null)
			{
				getCode(n.right, code+"1");
			}		
		}
		else  //its a leaf
		{
			//save code for later use
			codes[(int) n.element] = code;

			if((int) n.element== 10)
			{
				System.out.println("HuffCode:/n-->" + code);
			}
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
