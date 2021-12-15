var fs = require("fs");
var words = fs.readFileSync("words.txt").toString();
words = words.split("\n");

var badLetters = /[gkmnopqrstwvyxziGKMNOPQRTSWXVYZI\.\d-?/?&?'?]/;
var longestAcceptableWord="";
var arrayOfWords =['a'];

for(var testWord of words){
    if(testWord.length < longestAcceptableWord.length){
        continue;
    }

    if(testWord.match(badLetters)){
        continue;
    }
    longestAcceptableWord = testWord;

    //Appends new word to possible list of equally lengtht words
    if(arrayOfWords[arrayOfWords.length - 1].length==longestAcceptableWord.length){
        arrayOfWords.push(longestAcceptableWord);
        continue;
    }

    //Empties previous array and creates new one with longer length of the longestWord
    if(arrayOfWords[arrayOfWords.length - 1].length<longestAcceptableWord.length){
        arrayOfWords=[];
        arrayOfWords.push(longestAcceptableWord);
        continue;
    }
}   
    console.log(arrayOfWords.toString());