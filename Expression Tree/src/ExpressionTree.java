//***************************************
// This is the ExpressionTree class for the 
//Expression tree problem.
//This class contains methods for checking for infix, prefix, and evaluating.
//This class also contains a subclass defining a node. 
//Places the expression into a char array to make it easy to evaluate.
//Akiva Dollin-acd2164
//****************************************
public class ExpressionTree 
{
	private final String postfix;
	private TreeNode root;
	public char[] charArray;
	public  MyStack<TreeNode> nodeStack; 
	public  MyStack<String> evalStack; 

	public ExpressionTree(String postfix)
	{
		//deal with invalid postfix
		this.postfix = postfix;
		//create an instance of Stack
		nodeStack = new MyStack<TreeNode>(postfix.length());
		//create the tree
		createExpressionTree(toCharacterArray(postfix));
		//define the root that the methods will use
		root = nodeStack.pop();
		//post
		System.out.println(postfix+ "--> PostFix Expression");
		//pre
		showPreFix(root);
		System.out.print("--> Prefix Expression");
		//in
		System.out.println("");
		showInFix(root);
		System.out.print("--> Infix Expression");
		//eval
		System.out.println("");
		System.out.println("Result: " + evaluatePostFix(postfix));
		
	}
	//fill an array with the expression
	private char[] toCharacterArray(String postfix) 
	{
		charArray = new char[postfix.length()];

		for(int i=0; i<postfix.length(); i++)
		{
			charArray[i] = postfix.charAt(i);
			//System.out.println(charArray[i]);
		}

		return charArray;
	}

	//subclass to define nodes
	class TreeNode
	{
		//define node as having left right and symbol
		TreeNode left, right;
		char symbol;
		public TreeNode(TreeNode left,TreeNode right,char symbol)
		{
			this.symbol = symbol;
			this.left =left;   //empty to start
			this.right = right;
		}
	}
	//create a tree with the expression
	public void createExpressionTree(char[] arr) 
	{
		for (int i = 0; i < arr.length; i++) 
		{
			char ch  = arr[i];
			if (isOperator(ch)) //if the character is an operator 
			{
				//pop twice and then combine and push
				TreeNode right = nodeStack.pop();
				TreeNode left = nodeStack.pop();
				nodeStack.push(new TreeNode(left, right, ch));
			} 
			else 
			{
				//or add a leaf
				TreeNode newNode = new TreeNode(null,null, ch);
				nodeStack.push(newNode);
			}
		}
	}
	//used by tree generator
	private boolean isOperator(char symbol) 
	{
		if(symbol == '+' || symbol == '-' 
				|| symbol == '*' || symbol == '/')
			return true;
		else
			return false;
	}
	//to show prefix notation
	//operators come before the two operands
	public void showPreFix(TreeNode n)
	{
		if(n!=null) 
		{
			//print the operator, then recurse to the left and right
			System.out.print(n.symbol);
			showPreFix(n.left);
			showPreFix(n.right);
		}
	}
	//to show infix notation
	//human readable
	public void showInFix(TreeNode n)
	{
		if (n!= null)
		{
			if (n.left == null) //if n is a leaf, therefore a number
			{
				System.out.print(n.symbol);
			}
			else //n is not a leaf
			{
				//recurse to left, then print symbol, then recurse right
				System.out.print("(");
				showInFix(n.left);
				System.out.print(")" + n.symbol + "(");
				showInFix(n.right);
				System.out.print(")");
			}
		}  
	} 
	//print out the evaluation of the postfix
	private int evaluatePostFix(String n) 
	{
		int result = 0;
		//create new stack the size of the expression
		evalStack = new MyStack<String>(postfix.length());
		for( int i=1; i<=n.length(); i++)
		{
			//if the first character is an operand, push
			//will always have two operands
			if(n.substring(i-1,i).matches("[0-9]+"))
				evalStack.push(n.substring(i-1,i));
			else 
			{
				try 
				{
					//cast from substring to int, pop twice, combine, repush
					int num2 = Integer.parseInt(evalStack.pop()); 
					String oprnd = n.substring(i-1,i);
					int num1 = Integer.parseInt(evalStack.pop());
					
					if(oprnd.equals("*")){
						result = num1*num2;
					} 
					else if(oprnd.equals("/")){
						result = num1/num2;
					} 
					else if(oprnd.equals("+")){
						result = num1+num2;
					} 
					else if(oprnd.equals("-")){
						result = num1-num2;
					}
					//repush, as a string for the stack
					//result is an int, stack needs a string
					evalStack.push(result+"");
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
					break;
				}
			}
			
		}
		return result;
		}
	}