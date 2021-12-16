#include <iostream>
#include <fstream>
#include <regex>
#include <string>
#include <vector>
using namespace std;

regex reg(".*([g|k|m|n|o|p|q|r|s|t|w|v|y|x|z|i|G|K|M|N|O|P|Q|R|T|S|W|X|V|Y|Z|I|\\-|0-9|&|\\.|\\'])+.*");

int main()
{
    //string which is used to output the text file
    string longestAcceptableWord="";
    
    //set up variables
    string testWord;
    vector<string> arrayOfWords;
    arrayOfWords.push_back("a");
    // Read from the text file
    ifstream MyReadFile("words.txt");
    while (getline (MyReadFile, testWord)) {
            if(testWord.length() < longestAcceptableWord.length()){
                continue;
              }
              
              if( regex_search(testWord, reg) ){continue;}
              longestAcceptableWord = testWord;

              //Appends new word to possible list of equally lengtht words
              if(arrayOfWords[0].length()==longestAcceptableWord.length()){
                  arrayOfWords.push_back(longestAcceptableWord);
                  continue;
              }

              //Empties previous array and creates new one with longer length
              if(arrayOfWords[0].length()<longestAcceptableWord.length()){
                  arrayOfWords.clear();
                  arrayOfWords.push_back(longestAcceptableWord);
                  continue;
              }
    }
    
    for(int i=0;i<arrayOfWords.size();i++){
        cout<<arrayOfWords[i];
    }
    
    MyReadFile.close();
    return 0;
}