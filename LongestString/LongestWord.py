import re
file = open("words.txt", "r")

longestAcceptableWord=""        #start with an empty 'longest word'
arrayOfWords =["a"]             #start with a non-empty array 

num_lines = file.readlines()    #loads all lines on the file onto a String

for i in range(0, len(num_lines)):
    currentWord = num_lines[i]                      #takes the i-th element, accordingly to a line on the file
    currentWord = currentWord.replace("\n", "")     #truncates the breakline character
    
    if(len(currentWord) < len(longestAcceptableWord)):
        continue
    
    #Checks if the currentWord matches any character in the regex
    if bool(re.search(r"(?=.*[gkmnopqrstwvyxziGKMNOPQRTSWXVYZI\.\d\-\/'])", currentWord)):
        continue
    longestAcceptableWord = currentWord

    #Appends new word to possible list of equally lengtht words
    if(len(arrayOfWords[len(arrayOfWords) - 1])==len(longestAcceptableWord)):
        arrayOfWords.append(longestAcceptableWord)
        continue
    
    #Empties previous array and creates new one with longer length of the longestWord
    if(len(arrayOfWords[len(arrayOfWords) - 1])<len(longestAcceptableWord)):
        arrayOfWords.clear()
        arrayOfWords.append(longestAcceptableWord)
        continue

file.close()
print(arrayOfWords)