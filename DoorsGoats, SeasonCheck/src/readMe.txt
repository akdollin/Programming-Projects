 SeasonDateCheck
 - I declared season as starting as invalid so if you put in an invalid date, it catches it right away. 
 - I also put in a simple if statement to catch basic errors
 - I then used simple if statements to describe the different situations initially 
 -and other if statements to account for the dividing dates. I used if's, 
 simply because i'm most comfortable with them, and i find them to be very easy to read
 
 SeasonTester
 -this is pretty straight forward.
 - i declared the variables i would need
 - scanned in the ones i also needed
 - and recalled the season check method
 
 DoorProb
 -i began by creating a new method
 - then i defined all the variables i would need
 - i then used .Random to randomly assign where the car was and if statements to assign the remaining doors to goats
 - then the user randomly chooses a door
 - i use if statements, again because i think they are easier to read and are clean and concise and leave no room for error. 
 - i use them to have the host open one of the doors. One door if the user has chosen the car, and another if the user has chose a goat
 -and the last part is another simple if showing which strategy would win the car, whether switching or not switching
 	- i call a variable from my tester class here to count the number of times each strategy should be used
 	
 DoorProbTester
 - this is also fairly simple code. 
 - i set two different variables starting at zero. these are my counters
 - in the other method, i have set it so that each time one of the two are incremented by one
 - because of this, i simple run the gameShow method 1000 times in a for loop, and print out the new variables afterwards
 - the important thing is that switching is always higher out of 1000, around 650
 - and not switching is lower, somewhere near 350
 Together, they must equal 1000. 