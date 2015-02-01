package core_197_isbn;

import utills_197.Isbn;

public class ISBN_197 
{
	
	/*------------------------------------------------
	 * 				ISBN Validator <EASY>
	 * -----------------------------------------------
	 * 
	 * My solution to the daily programming task
	 * for [2015-01-12] over at reddit/r/dailyprogramer
	 * 
	 * ================================================
	 * ===   Short link: [http://bit.ly/1EWQhO5]
	 * ================================================
	 */
	
	
	public ISBN_197(String isbn) 
	{
		System.out.println("ISBN inputed: "+ isbn);
		System.out.println(Isbn.isbnValidator(isbn));
	}

	public static void main(String[] args)
	{
		//First object is a test isbn number
		ISBN_197 newProject = new ISBN_197("1234567890");
		//Second object contains the same isbn as the example
		ISBN_197 next = new ISBN_197("0747532699");
		//Finaly we use a generator to randomly generate a isbn
		System.out.println("ISBN =>> "+Isbn.giveMeISBN());

	}

}
