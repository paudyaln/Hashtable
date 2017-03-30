/*
 * driver program for testing LinkedHashSet
 */

public class HashSets
{
	public static void main (String [] args)
	{
		LinkedHashSet<Character> letters = new LinkedHashSet< >();

		char [] toAdd = {'C', 'b', 'c', 'Q', 'z', 'D', 'E', 'P', 'j', 'F', 
			'E', 'I', 'y', 'f', 'i', 'U', 'V', 'm', 'e', 'W'};
	 
		for (int i = 0; i < toAdd.length; i++)
		{
			letters.add(toAdd[i]);
		}

		System.out.println("\n" + letters);

		System.out.println("Does the set contain 'e'? " + 
			(letters.contains('e') ? "yes" : "no"));
		System.out.println("Does the set contain 'a'? " + 
			(letters.contains('a') ? "yes" : "no"));

		System.out.println("After removing e, c, y, W, and y:\n");	
		letters.remove('e');
		letters.remove('c');
		letters.remove('y');
		letters.remove('W');
		letters.remove('y');
		System.out.println(letters);
	}
}
