This is the ReadMe for the TextAvl tree program.

This program has four classes.

UnderflowException:
	This is a generic underflow exception class from Weiss. 
AVlTree:
	This class defines the nodes and the structure of the AVLTree. It includes a subclass defining a node.
	This class is from the Weiss code. It was modified slightly to include two things. Each node now has a 
	list connected to it. If you attempt to insert a duplicate, the line number (the second addition) is 
	inserted into the list. 
buildAVLTree:
	This is a simple class. It takes in a file. In a loop it reads it line by line. It then tokenizes every 
	line to look at the individual words. It then deletes trailing commas and periods, and tries to insert 
	them into the tree. It then prints the full tree. This class calls its own methods to ignore case and deal 
	with periods and commas, while ignoring punctuation within a word, like a URL.
AVLTreeTester:
	This is a basic tester class. It takes in a file as a command line args, and makes an instance
	of the buildAVLTree class. 
	
To Run:
Simply run tester with the desired file as the command line argument. 