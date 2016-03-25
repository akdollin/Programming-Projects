

public class Node implements Comparable<Node> 
	{
		char element; // Stores the character for a leaf node
		int frequency; // weight of the subtree rooted at this node
		Node left; // Reference to the left subtree
		Node right; // Reference to the right subtree
		String code = ""; // The code of this node from the root

		public Node()  //used for interior nodes//no characters
		{
		}

		/** Create a node with the specified weight and character */
		public Node(int frequency, char element) 
		{
			this.frequency = frequency;
			this.element = element;
			this.left = null;
			this.right = null;
		}

		public int compareTo(Node o) 
		{
			return (new Integer(this.frequency).compareTo(new Integer(o.frequency)));
		}

		public boolean isLeaf()
		{
			return left == null && right == null;
		}

		public int height()
		{
			if(this.isLeaf())
			{
				return 1;
			}

			int leftHeight = left.height();
			int rightHeight = right.height();
			int height = Math.max(leftHeight, rightHeight) + 1;
			return height;
		}

		public int fullSize()
		{
			if (this.isLeaf())
			{
				return 1;
			}

			return 1 + left.fullSize() + right.fullSize();
		}
	}