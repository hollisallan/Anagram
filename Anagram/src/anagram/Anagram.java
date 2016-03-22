package Anagram;
/*
Allan Hollis
Anagram.java

Purpose:
The purpose of anagram.java is to take an input file specified by the user and 
find all anagrams contained within the file itself. It will parse the user's file 
comparing all words to each other to find the anagrams contained. The found anagrams
will be both displayed on the screen and put into an output file (output.txt)

Solution:
    1. Use Scanner class for user input, putting the given information into a String
       (fileName). 
    2. Parse the file with the readFile method. The words will be copied from the 
       file into a String HashMap (words).
    3. The readFile method then calls the wordPair method which establishes two 
       versions of the String. w1 is a version of the string which is the original
       with the sybols removed. w2 is the same as w2, converting all letters to 
       lowercase. wordPair makes a string array with these two versions.
    4. The String will be sorted by the sortWord method which takes the String and
       puts the words into a character array and sorts the array alphabetically,
       returning the sorted words as a String
    5. Within the HashMap words, if there is no word that has the same key as the sorted
       word then a new entry is made for that key and adds the original word in 
       that position
    6. The outputFile method establishes the PrintWriter printer to output to the
       output file output.txt . It then prints both to the screen and the file
       the each word with the original capitalization with their corresponding
       anagrams
       
I/O:
The program will simply take the name of a file containing text and return an
output file containing all anagrams. A user would just enter the name of their files
and when the program has completed successfully an output file will be made.
*/
import java.util.*;
import java.io.*;

public class Anagram 
{

    public static void main(String[] args) throws IOException
    {
      Map<String,List<String>> words = new HashMap<String, List<String>>();
      
      readFile(getFile(), words);  
      outputFile(words);      
    }
    
/*
Purpose:
The purpose of the getFile method is to prompt and recieve input from the 
user on which file to read for anagrams. It returns the inputted file 
name in the form of a string fileName
*/
    public static String getFile()
    {
        Scanner scanner = new Scanner(System.in);
    	System.out.print("Which file would you like to use? : ");
    	String fileName = scanner.nextLine();
    	return fileName;
    }
    
/*
Purpose:
The purpose of the readFile method is to take the words in the file and make
the comparisons and determine if they are anagrams are not. It will also 
determine if the file is valid (Less than 51 words) or if the file exists, 
returning an error message if it does not.
*/

    public static void readFile(String fileName, Map<String,List<String>> words)
    {   
    	try
    	{
    		int count = 0;
			Scanner fileScanner = new Scanner(new File(fileName));
    		while (fileScanner.hasNext())
    		{
    		    String[] pair = wordPair(fileScanner.next());
    		    String sortedWord = pair[0];
    		    String origWord = pair[1];
    		    int len = sortedWord.length();
    		    if (len > 0 && len <= 12)
    		    {
    		      if (! words.containsKey(sortedWord))
    		      {
    		         words.put(sortedWord, new ArrayList<String>());
    		      }
    		      List<String> list = words.get(sortedWord);
    		      list.add(origWord);
    		      count +=1;
    		      if (count > 50)
    		      {
    		       System.out.println("There are more than 50 words in the input file");
    				System.exit(0);
    		      }
    		     }
    		}
    	}
    	catch(FileNotFoundException ex)
    	{
    		System.out.println("The input file is empty");
    		System.exit(0);
    	}
    	
    }
    
/*
Purpose:
The purpose of the outputFile method is to take the words that were
determined to be anagrams, matching them to their original counterparts and
outputting this result to both the screen and the output file output.txt
*/
    public static void outputFile(Map<String, List<String>> words)
    {
    	try
    	{
       	    PrintWriter printer = new PrintWriter(new FileWriter("output.txt"));
	   	//System.out.println(words.toString());
   		System.out.println("Anagrams:");
   		printer.println("Anagrams: ");
   		for (List<String> list : words.values())
   		{
    		System.out.println(list.toString());
                    printer.println(list.toString());
   		}
   			printer.close();
   		}
  	 	catch(Exception e)
    	{
    		System.out.println("The output file is does not exist");
    	}
    } 	
   
/*
Purpose:
The purpose of the wordPair mehod is to remove all symbols from the input 
file and convert all letters to lowercase for easy comparison. It also
preserves the original capitalization of the words so they can be printed 
in output.
*/
    public static String[] wordPair(String word)
    {	    
    	String[] pair = new String[2];
 	   	String w1 = word.replaceAll("[^ A-Za-z]", "");   	
    	String w2 = w1.toLowerCase();
    	pair[0] = sortWord(w2);
    	pair[1] = w1;
    	return pair;
    }
    
   /*
   Purpose:
    The purpose of the sortWord method is to convert the words into a character
    array and sort them alphabetically so they can be compared for anagrams.
    (If the letters in two words are sorted alphabetically and have are 
    equivalent they are anagrams regardless of the original order of letters.)
   */
   public static String sortWord(String word)
    {
    	char [] charWord = word.toCharArray();
    	Arrays.sort(charWord);
    	String sortedWord = new String(charWord);
    	//System.out.println(sortedWord);
    	return sortedWord;
    }  
}

