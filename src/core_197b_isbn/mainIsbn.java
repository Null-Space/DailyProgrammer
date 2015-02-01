package core_197b_isbn;


/*
 * In my first solution to problem #197
 * I only used one OOP methodology, and that
 * was recursion.
 * 
 * In this solution I aim to incorporate
 * Encapsulation into the application.
 * I do this by using An object class ISBN.
 * 
 * This allows for a more flexible solution, with
 * code that can be expanded upon later.
 */
public class mainIsbn 
{

	public static void main(String[] args) 
	{
		IsbnNumber newISBNnumber = new IsbnNumber();
		newISBNnumber.setMaximumGenerationAttempts(25);
		newISBNnumber.beginISBNGeneration();
		System.out.print(newISBNnumber.getISBN());

	}

}
