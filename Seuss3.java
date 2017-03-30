import java.io.*;
import java.util.Scanner;

/**
 * Created by paudyaln on 2/6/2017.
 * Seuss.java
 *
 * The Program reads words from the file.
 * Removes all the duplicate word
 * and writes it to file
 */
public class Seuss3 
{
    public static void main(String[] args)
	{
        Scanner reader = null;
        FileWriter file;
        PrintWriter writer = null;

        try {
            reader = new Scanner(new File("greenEggs.txt"));
            file = new FileWriter(new File("greenEggsOutput.txt"));
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
           LinkedHashSet<String> textHashSets = new LinkedHashSet<>(20);

            while (reader.hasNext()) {
                //get next word
                String word = reader.next();
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
                    textHashSets.add(word);
                }
            }
            //write file to the console
            writer.println(textHashSets.toString());
            writer.close();
            //print the set of word to the console
            System.out.print(textHashSets);
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
