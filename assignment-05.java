// ---------------------------------------------------------------------------
// Assignment 5 - Text Processing
// Date Written: 20200716
// Author: Teo Espero
// Description:
// This program has to search for and replace certain characters in a 
// string with other characters.  This program will look for an individual 
// character, called the key character, inside a target string.   It will 
// then perform various functions such as replacing the key character with 
// a dollar-sign ($) wherever it occurs in the target string.  For 
// example, if the key character were
//          'a'
// and the string were
//          "He who laughs last, laughs fast, faster, FASTEST."
// then the operation of replacing the 'a' by a dollar-sign would result 
// in the new string:
//          "He who l$ughs l$st, l$ughs f$st, f$ster, FASTEST."
//---------------------------------------------------------------------------


import java.util.Scanner;

public class Foothill
{
   // the following constants are used in making our output
   // easier to read for the user
   
   // these are PUBLIC constants
   // and can be used anywhere in the program
   static final String INDENT="   ";
   static final String SEPARATOR="\n";
   
   
   //-------------------------------------------------------------------------
   public static void printPrompt(String msgPrompt) {
      // this is the GENERIC method for displaying our PROMPTS
      System.out.print(msgPrompt);
   }
   //-------------------------------------------------------------------------
   
   
   
   //-------------------------------------------------------------------------
   public static String getKeyCharacter() {
      // This method requests a single character from the user and continues 
      // to ask for it until the user gets it right:  this method will test 
      // to make sure the user only types one single character.  0, 2, 3 or 
      // more characters will be flagged as an error and the method will keep 
      // at the user until he types just one character.
      
      final String 
         KEY_ENTRY="> Please enter a SINGLE character to act as key: ";
      
      boolean
         validEntryForChar=false;
      String
         inputFromUser="";
      
      Scanner inputStream=new Scanner(System.in);
      
      while ((!validEntryForChar)) {
         printPrompt(SEPARATOR+KEY_ENTRY+SEPARATOR);
         inputFromUser=inputStream.nextLine();
         validEntryForChar=validEntry('C', inputFromUser);
      }
      return inputFromUser;
   }
   //-------------------------------------------------------------------------
   
   
   //-------------------------------------------------------------------------
   public static String getString() {
      // This method requests a string from the user and continues to ask 
      // for it until the user gets it right:  this method will test to 
      // make sure the user only types a string that has at least 6 characters.  
      // Make this minimum size a constant (final), and use that symbolic 
      // constant, not the literal (6) wherever it is needed. The acquired 
      // string will be returned as a functional return. 
         
      final String 
         PHRASE_ENTRY01="> Please enter a phrase or sentence >= 6 ",
         PHRASE_ENTRY02="and <= 500 characters:"+SEPARATOR;
   
      boolean
         validEntryForChar=false;
      String
         inputFromUser="";
      
      Scanner inputStream=new Scanner(System.in);
      
      while ((!validEntryForChar)) {
         printPrompt(SEPARATOR+PHRASE_ENTRY01+PHRASE_ENTRY02);
         inputFromUser=inputStream.nextLine();
         validEntryForChar=validEntry('S', inputFromUser);
      }
      return inputFromUser;
   }
   //-------------------------------------------------------------------------
   
   
   //-------------------------------------------------------------------------
   public static boolean validEntry(char dataType, String theData) {
      // This method validates the user input for the CHARACTER KEY 
      // and the PHRASE. It prompts the user for the issue found in the input.
      
      
      // these are our PROMPTS
      final String 
         ERROR_MSG_CHAR="***Please enter ONE character.***",
         ERROR_MSG_STR="***Please enter a phrase between the valid range.***";
      
      boolean
         entryResult=false;
         
      // our boxes for the MIN/MAX, and string length values
      int 
         inputMinLimit=0,
         inputMaxLimit=0,
         stringLength=0;
      
      // to make this method GENERIC we included a data type indicator
      // so it will validate the range dependent on its type
      
      // character validation
      if (dataType=='C') {
         inputMinLimit=1;
         inputMaxLimit=1;
         stringLength=theData.length();
         if (stringLength<inputMinLimit || stringLength>inputMaxLimit) {
            printPrompt(INDENT+ERROR_MSG_CHAR+SEPARATOR);
         }
         else {
            entryResult=true;
         }
      }
      
      // phrase validation
      if (dataType=='S') {
         inputMinLimit=6;
         inputMaxLimit=500;
         stringLength=theData.length();
         if (stringLength<inputMinLimit || stringLength>inputMaxLimit) {
            printPrompt(INDENT+ERROR_MSG_STR+SEPARATOR);
         }
         else {
            entryResult=true;
         }
      }
      
      return entryResult;
   }
   //-------------------------------------------------------------------------
   
   
   //-------------------------------------------------------------------------
   public static String maskCharacter(String theString, char keyCharacter) {
      // This method will take both a string and a character as parameters 
      // and return a new string that has each occurrence of the key character 
      // replaced by a dollar-sign, '$'.
      
      String
         maskedString="";
      char
         currentChar='\0';
     
      // what we're doing is we are slicing each character
      // from the string and creating a new string      
      for (int myStrIndex=0; myStrIndex!=theString.length(); myStrIndex++) {
         currentChar=theString.charAt(myStrIndex);
         
         // if the character slice is equal to the CHARACTER KEY
         // we replace it
         if (currentChar==keyCharacter){
            currentChar='$';
         }
         maskedString=maskedString+String.valueOf(currentChar);
     }
      return maskedString;
   }
   //-------------------------------------------------------------------------
   
   //-------------------------------------------------------------------------
   public static int keyCount(String theString, char keyCharacter) {
      // This method will take both a string and a character as parameters, 
      // and return the number of key characters that appear in the 
      // string (case sensitive).
      
      int
         maskedStringCount=0;
      char
         currentChar='\0';
     
      // what we're doing is we are slicing each character
      // from the string 
      for (int myStrIndex=0; myStrIndex!=theString.length(); myStrIndex++) {
         currentChar=theString.charAt(myStrIndex);
         
         // if the character slice is equal to the CHARACTER KEY
         // we count its instance
         if (currentChar==keyCharacter){
            maskedStringCount=maskedStringCount+1;
         }
     }
      return maskedStringCount;
   }
   //-------------------------------------------------------------------------
   
   
   //-------------------------------------------------------------------------
   public static void main(String[] args)
   // This is our main program... note that the methods created are 
   // called in this module
   {
     
      // initialize the variables that we will be using
      // as place holders for the CHARACTER KEY, PHRASE
      // and the new MASKED STRING
      String
         charInput="",
         stringInput="",
         maskedString="";
      
      char 
      charKey='\0';
      
      // This will be used to store the 'hits' we get
      // with the KEY CHARACTER
      int 
         keyCharCount=0;

      //----------------------------------------------------------------------
      // BEGIN
      
      
      charInput=getKeyCharacter();
      stringInput=getString();   

     
      charKey=charInput.charAt(0);
      maskedString=maskCharacter(stringInput, charKey);
      printPrompt(SEPARATOR+"String with '"+charInput+"' masked:"+SEPARATOR);
      printPrompt(maskedString+SEPARATOR);
      keyCharCount=keyCount(stringInput, charKey);
      printPrompt(SEPARATOR+"# "+charInput+"'s : "+keyCharCount+SEPARATOR);
      // END
      //----------------------------------------------------------------------
   }
   //-------------------------------------------------------------------------
}

//------------------------------------------
/* CONSOLE OUTPUT

1ST RUN
-----------------------------------------------------------------
> Please enter a SINGLE character to act as key: 
a

> Please enter a phrase or sentence >= 6 and <= 500 characters:
He who laughs last, laughs fast, faster, FASTEST.

String with 'a' masked:
He who l$ughs l$st, l$ughs f$st, f$ster, FASTEST.

# a's : 5

2ND RUN
-----------------------------------------------------------------

> Please enter a SINGLE character to act as key: 
E

> Please enter a phrase or sentence >= 6 and <= 500 characters:
Teodulfo Espero

String with 'E' masked:
Teodulfo $spero

# E's : 1

3RD RUN
-----------------------------------------------------------------


> Please enter a SINGLE character to act as key: 
o

> Please enter a phrase or sentence >= 6 and <= 500 characters:
The quick brown fox jumped over the lazy dog.

String with 'o' masked:
The quick br$wn f$x jumped $ver the lazy d$g.

# o's : 4

4TH RUN
-----------------------------------------------------------------

> Please enter a SINGLE character to act as key: 
msg
   ***Please enter ONE character.***

> Please enter a SINGLE character to act as key: 
m

> Please enter a phrase or sentence >= 6 and <= 500 characters:
Mary
   ***Please enter a phrase between the valid range.***

> Please enter a phrase or sentence >= 6 and <= 500 characters:
Mary had a little lamb.

String with 'm' masked:
Mary had a little la$b.

# m's : 1


5TH RUN
-----------------------------------------------------------------

> Please enter a SINGLE character to act as key: 
O

> Please enter a phrase or sentence >= 6 and <= 500 characters:
The quick brown FOX jumped over the lazy DOg.

String with 'O' masked:
The quick brown F$X jumped over the lazy D$g.

# O's : 2

*/