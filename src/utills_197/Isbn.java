package utills_197;

public class Isbn 
{
	/* ****************************************************************
	 * Main ISBN utility method
	 * 
	 * This is the beginning of the validation process.
	 * It takes a string as argument, splits the string
	 * into an array of strings, ie: "12345" becomes:
	 * ["1","2","3" ... ] etc. Then another array of int's
	 * is obtained from that array.
	 * 
	 * finally the private static sumRecursively method is called
	 * and passed as argument: the starting index value, and the
	 * array of Integers. The returned sum is then used for validation
	 * by checking the remainder from being divided by 11;
	 * 
	 * If there is remainder, this method returns false, otherwise true.
	 * 
	 * ****************************************************************/
	
	public static boolean isbnValidator(String isbnNumber)
	{
		String[] stringDigits = (isbnNumber.split("(?!^)"));
		int[] digits = new int[ stringDigits.length];
		int count = 0;
		for(String string : stringDigits){
			digits[count] = Integer.parseInt(string);
			count++;
		}
		int sumOfDigits = sumRecursively(0, digits);
		
		System.out.println("ISBN Value is:"+isbnNumber);
		System.out.println("Totol sum of digits: "+sumOfDigits+" And the final: / 11 = "+(sumOfDigits/11)+" Remainder: "+(sumOfDigits%11));
		if((sumOfDigits%11) > 0)
		{
			return false;
		}
		else return true;
	}
	
	/* ******************************************************************
	 * This method is a recursive method that takes as argument
	 * an int for index, as well as the int array of digits.
	 * 
	 * It uses the index to traverse the array until the final
	 * digit is found, where by the sum is itself. It then 
	 * uses this to sum the rest of the equations, which is returned
	 * ******************************************************************/
	
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
	
	/* ***********************************************************
	 * The generateISBNnumber method is rather basic in function.
	 * 
	 * It randomly generates a number 0-9, until ten(10) numbers
	 * have been generated.
	 * 
	 * A new String is then returned containing these numbers.
	 * 
	 * ***********************************************************/
	
	public static String generateISBNnumber()
	{
		String newISBN = "";
		for(int x = 0; x < 10; x++)
		{
			int value = (int)(Math.random()*9);
			newISBN += value;
		}
		
		return newISBN;
	}
	
	/* ***********************************************************
	 * giveMeISBN is called to generate a correct ISBN
	 * 
	 * It takes no arguments, calls the generateISBNnumber
	 * method, and validates the resulting ISBN number with
	 * a call to the isbnValidator method.
	 * 
	 * If a randomly generated ISBN is successfully validated
	 * it is returned as a string.
	 * **********************************************************/
	
	public static String giveMeISBN()
	{
		String newISBN = generateISBNnumber();
		if(isbnValidator(newISBN))
		{
			return newISBN;
		}
		else return giveMeISBN();
	}
}
