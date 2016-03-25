public class Tester
{
	public static void main(String[] args) 
	{
		String str1 = "Whats";

		int hashcode1 = 0;
		int hashcode2 = 0;

		for(int i=0;i<str1.length();i++) 
		{
			hashcode1 = 31*hashcode1 + str1.charAt(i);
			hashcode2 = (hashcode2 << 5) - hashcode2 + str1.charAt(i);
		}

		System.out.println("Hashcode1 : " + hashcode1);
		System.out.println("Hashcode2 : " + hashcode2);
	}

}