WordListTester: 
Try block to catch bad input and output. Includes FileNotFoundException
Prints a welcome, and creates a new object reference of the list program. 

ChooseWordList:
Throws i/o exceptions for bad input. Instantiates the instance variable needed to create a new list and file for multiple turns. 
Presents the different types of lists. Interprets the input and has an if statement for each one that scans in the required input and calls the needed method.
It then saves the list created into a file and gives it a specific name. To write to the file, the PrintWriter is used. 
The final methods prompts if you would like a new list. This calls the original method which plays the program again, while not deleting the first file.
Every list created increments an overall counter which keeps track of how many lists you've created and is able to make the file names list1, list2, list3, etc.  

WordLists:
This class defines all the different lists. In the constructor, I create a new arrayList and i import the dictionary and
 interpret it line by line with the fileReader and bufferReader. To find the length, I use the .length() and compare it to the 
 parameter passed into the method. I use the .add() to add each line from the bufferReader to my own arrayList.
For the methods that required looking at two different parts of  word, i used a simple for loop to check each 
letter in the word. If the methods requires a char, i used charAt(), and substring()
for all strings. For multiletter and voweHeavey, i implement a counter to find the given number of occurrences. 

This program prompts you which list you would list to create out of the entire scabble dictionary.
 Once you picks a list, it calls the check method which will interpret each line of the dictionary file and save the desired words in a separate list.
  It then copies this list into an array, and saves it to a file names List1. If you would like another list, the file will be under List2 and so on. 