public class DoorProb {
	
	
	public static void gameShow()
	{
		int goatDoor1;
		int goatDoor2;
		int carDoor;
		int randoPick;
		int hostDoor;
		
		//instantiate all the doors initially
	
		carDoor = (int) (Math.random() * 3) + 1;
		
		if (carDoor == 1)
		{
			goatDoor1 = 2;
			goatDoor2 = 3;
		}
		if (carDoor == 2)
		{
			goatDoor1 = 1;
			goatDoor2 = 3;
		}
		else {
			goatDoor1 = 1;
			goatDoor2 = 2;
		}
		
		
		//player pick his first door
		//System.out.println("Lets play a game.");
		//System.out.println("We have three doors. Pick either door 1, 2, or 3: ");
		randoPick = (int) (Math.random() * 3) + 1;
		//System.out.println("You chose door " + randoPick);
		
		//Game host picks one of the two goat doors 
		if(randoPick == carDoor); //if the user chooses the car door
		{
			hostDoor = (int) (Math.random()*2)+1;
			if (hostDoor == 1){
				hostDoor = goatDoor1;
			}
			else {
				hostDoor = goatDoor2;
			}
		}
		
		//if the rando chooses a goat door
		if (randoPick == goatDoor1)
		{
			hostDoor = goatDoor2;
		}
		if (randoPick == goatDoor2)
		{
			hostDoor = goatDoor1;
		}	
		
		
		//now the second question
		//System.out.println("I'm going to open my door. Door " + hostDoor + " is a goat door.");
		//System.out.println("Would you like to change your pick to the remaining door? Or stay with your door?");
		
		//decide what the correct strategy would be - if the guy knew where the car was
		if (randoPick == goatDoor1 || randoPick == goatDoor2)
		{
			DoorProbTester.change++;
		}
		else 
		{
			DoorProbTester.dontChange++;
		}
	}
}



