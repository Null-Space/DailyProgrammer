package core_197b_isbn;


/*
 * 
 * 
 */
public class IsbnNumber 
{
	private String ISBN;										//The ISBN value. I am using String again, as "I" can easily solve the problem this way.
	private static final int DEFAULT_MAX_GENERATIONS = 50;		//Setting a DEFAULT limit on the number of generation attempts
	private int MaxGenerations = DEFAULT_MAX_GENERATIONS;		//Added user defined variable for the ability to change the above limit.
	private boolean successfulISBN = false;						//Validation success flag.
	private int actualGenerationAttempts;						//Keeping track of the number of attempts. Sort of interesting.
	
	public IsbnNumber()
	{
		//Empty constructor
	}
	
	public void beginISBNGeneration()
	{
		int generationAttempts = 1;
		String lastGeneratedISBN = "Null";
		while(generationAttempts < this.MaxGenerations && !successfulISBN)
		{
			String newISBN = generateRandomISBN();
			
			if(!validateThisISBN(newISBN)){
				generationAttempts++;
				lastGeneratedISBN = newISBN;
			}
			else
			{
				this.successfulISBN = true;
				this.ISBN = newISBN;
				actualGenerationAttempts = generationAttempts;
			}
		}
		
		if(!this.successfulISBN){
			this.actualGenerationAttempts = generationAttempts;
			this.ISBN = lastGeneratedISBN;
		}
	}
	
	//User defined max generations
	public void setMaximumGenerationAttempts(int attempts){
		this.MaxGenerations = attempts;
	}
	
	public int getMaximumGenerationAttempts(){
		return this.actualGenerationAttempts;
	}
	
	public String getISBN()
	{
		if(!this.successfulISBN)
		{
			System.out.println("Failed to generate a valid ISBN number after "+this.MaxGenerations+" attemps! Sorry :( ");
			System.out.println("This was the last ISBN generated! "+this.ISBN);
		}
		else{
			System.out.println("A validated ISBN was found after #"+getMaximumGenerationAttempts()+" generation attempts!");
		}
		return this.ISBN;
	}
	
	/*public IsbnNumber(String isbnNumber)
	{
		
	}*/
	
	public String generateRandomISBN(){
		String newISBN = "";
		for(int x = 0; x < 10; x++)
		{
			int value = (int)(Math.random()*9);
			newISBN += value;
		}
		return newISBN;
	}
	
	private static int sumRecursively(int index, int[] digits)
	{
		int sum = (10-index)*digits[index];
		if(index == 9)
		{
			return sum;
		}
		else 
		{
			int newIndex = index+1;
			int newSum = sum;
			return newSum += sumRecursively(newIndex, digits );
		}
	}
	
	public static boolean validateThisISBN(String isbn)
	{
		String[] stringDigits = (isbn.split("(?!^)"));
		int[] digits = new int[ stringDigits.length];
		int count = 0;
		for(String string : stringDigits){
			digits[count] = Integer.parseInt(string);
			count++;
		}
		int sumOfDigits = sumRecursively(0, digits);
		
		System.out.println("ISBN Value is:"+isbn);
		System.out.println("Totol sum of digits: "+sumOfDigits+" And the final: / 11 = "+(sumOfDigits/11)+" Remainder: "+(sumOfDigits%11));
		if((sumOfDigits%11) > 0)
		{
			return false;
		}
		else return true;
	}
}
