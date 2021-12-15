import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class LongestWords{
    public static Scanner myReader;
    public static String longestAcceptableWord="";
    public static String testWord="";
    public static String badLetters=".*([g|k|m|n|o|p|q|r|s|t|w|v|y|x|z|i|G|K|M|N|O|P|Q|R|T|S|W|X|V|Y|Z|I|\\-|0-9|&|\\.|\\'])+.*";
    static ArrayList<String> arrayOfWords = new ArrayList<String>();
    
    public static void main(String[] args) {
      arrayOfWords.add("a");
      
        try {
            File myObj = new File("words.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
              testWord = myReader.nextLine();
              if(testWord.length() < longestAcceptableWord.length()){
                continue;
              }
              
              if((testWord.matches(badLetters))){continue;}
              longestAcceptableWord = testWord;

              //Appends new word to possible list of equally lengtht words
              if(arrayOfWords.get(0).length()==longestAcceptableWord.length()){
                  arrayOfWords.add(longestAcceptableWord);
                  continue;
              }

              //Empties previous array and creates new one with longer length
              if(arrayOfWords.get(0).length()<longestAcceptableWord.length()){
                  arrayOfWords.clear();
                  arrayOfWords.add(longestAcceptableWord);
                  continue;
              }
            }

            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          } 
          System.out.println(arrayOfWords);
    }
}