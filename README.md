# Anagram

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
