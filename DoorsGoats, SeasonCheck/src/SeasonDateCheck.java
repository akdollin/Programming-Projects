
public class SeasonDateCheck {
	public static String dateCheck(int d, int m)
	{
		//intial season without equinox or solstice
		String season = "not a valid date";
		//account for invalid dates
		if( m>12 || d>=32)
		{
			return season;
		}
		
		
		if (m == 1 || m==2 || m==3) 
			season = "Winter";
		
		if (m==4 || m==5 || m==6) 
			season = "Spring";
		
		if (m==7 || m==8 || m==9)
			season = "Summer";
			
		if (m==10 || m==11 || m==12)
			season = "Fall";
		
		//then write method for accounting for change dates
		if(m%3==0 && d>=21) 
		{
			if (season== "Winter") //(m == 1 || m==2 || m==3) 
			{
				season = "Spring";
			} 
			else if (season== "Spring") //(m==4 || m==5 || m==6) 
			{
				season = "Summer";
			} 
			else if  (season == "Summer") //(m==7 || m==8 || m==9)
			{
				season = "Fall";
			}
			else //(m==10 || m==11 || m==12)
			{   
				season = "Winter";
			}
		}
		return season; //return the new season
		}
	}

	


	

		