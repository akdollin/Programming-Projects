
public class medianSorter {

	public static void main(String[] args) {
		int[] input = new int[args.length];
		
		for(int i = 0; i < args.length; i++) {
			input[i] = Integer.parseInt(args[i]);
		}
		
		System.out.println(java.util.Arrays.toString(input));
		
		//int[] newArray = new int[args.length];
		
		
		int i = 1;
		//int j = 0;
		//while(j<input.length) {
			int largestSoFar = input[0];
			while(i<input.length) {
				if(input[i] > largestSoFar) {
					int temp = largestSoFar;
					largestSoFar = input[i];
					input[i] = temp;
					//input[i] = 0;
				}
				i++;
			}
			//newArray[j] = largestSoFar;
			
			//j++;
		
		System.out.println(java.util.Arrays.toString(input));
	}
}
	
