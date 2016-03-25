This is the ReadMe for the spell check program.

This program has three classes.

Main Class:
	SpellCheckTester: This is a basic main class. Creates an instance of the spellCheck class.
This class deals with bad command line args.

SpellCheckerHash:
	This is a class taken from the Weiss text and changed in a very minimal way. The 
	only difference is the myHash(), which defines the hashFunction. It is very basic, adds a prime and 
	mods by the tableSize.
	The myHash() also calls the hashCode() directly below it. This changes every input into a unique integer.
	This method is based off of the examples in chapter 5 of the text book. 
	
SpellCheckerFiles:
	This class does all the reading of the files and calls the three spellCheck methods.
	The class takes in three files. It then takes the first file and inserts it into the hashTable. 
	Takes the second file, and checks it there are duplicates, then inserts them as well.
	It then takes the third file, the input, and checks each word using the spellCheck()s.
	
	Remove: This method takes the word, and in a loop removes one letter at a time. It then uses contains
	to see if the remove would help, and prints the results.
	Add: This method adds one character to each spot in the array and uses contains again. This method
	includes every letter of the alphabet and the apostrophe character. 
	Swap:This method uses a charArray to save the order of the characters. It then makes
	 a temp to save the original and swap every adjacent pair, uses contains and prints the results.
	 
	 
To Run: Simply run the tester class and insert three command line args: dictionary,personal,input. 
	