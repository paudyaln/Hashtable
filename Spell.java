import java.io.*;
import java.util.Scanner;

/**
 * Created by paudyaln on 03/26/2017.
 * Spell.java
 *
 * The Program reads words from the file.
 * Checks if the words are  misspelled
 * and writes it to file
 */
public class Spell 
{
    public static void main(String[] args)
	{
	//file readers and writers
        Scanner dreader = null;
	Scanner freader = null;
        FileWriter file;
        PrintWriter writer = null;

        try {
            dreader = new Scanner(new File("dictionary.txt"));
            freader = new Scanner(new File("test.txt"));
	    file = new FileWriter(new File("misspelled.txt"));
            writer = new PrintWriter(file);
        }
        catch(FileNotFoundException e){
            System.out.println("Cannot open input file");
        }
        catch (IOException e){
            System.out.println("Cannot open output file");
        }
        finally {
            //create ArraySet object
            LinkedHashSet<String> dictionary = new LinkedHashSet<>(1000);
	    System.out.println("Dictionary Loading ...");
	    
	    long startTime = System.currentTimeMillis();
            while (dreader.hasNext()) {
                //get next word
                String word = dreader.next();
                //remove punctuation
                word = removePunc(word);
                //variable to check if all letters
                boolean check = true;

                for (int i = 0; i < word.length(); i++) {
                    //check if all the characters in the word are letters
                    if (!isLetter(word.charAt(i))) {
                        check = false;
                        break;
                    }
                }
                //condition when all the character in word are letter
                if(check == true){
                    //make sure all letters are lower case, if not convert
                    word = word.toLowerCase();
                    //add words to the set
                    dictionary.add(word);
                }
            }
	    long endTime = System.currentTimeMillis();
	    //runtime calculation
	    long totalTime = endTime - startTime;

	    System.out.println("Run Time : " + totalTime + " milliseconds");
	    System.out.println("\nMisspelled Word: ");
	    //check words in the dictionary 
	    while(freader.hasNext())
	    {
		String word = freader.next();
	        if(!dictionary.contains(word))
		{
			//write misspelled words on the file
			writer.println(word);
			//write misspelled word in console
			System.out.println(word);	
		}	
	    }
            //write file to the console
            writer.close();
            
		
       }


    }
    /*
    * Check if letter
    */
    public static boolean isLetter(char c){

        if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')){
            return true;
        }
        else {
            return false;
        }
    }
    /*
    * Remove punctuation from the words
    */
    public static String removePunc(String s){
        //remove any punctuation
       return s.replaceAll("[^a-zA-Z1-9]", "");
    }

}
