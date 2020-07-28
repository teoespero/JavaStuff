/************************************************************************
 * Assignment 6 - A Three String Class
 * Description:
 * The program will loop, asking the user for a bet amount from 0 to 50 
 * (assume dollars, you can use ints or longs).  If the user types a 0 
 * that means she wants to quit.  Otherwise, accept the amount as their 
 * bet and simulate a slot machine pull. 
 * 
 * Author: Teo Espero
 * Date Written: 07-28-2020  
 ************************************************************************/

import java.util.*;
import java.lang.Math;

public class Foothill
{
   // these are PUBLIC constants
   // and can be used anywhere in the program
   static final 
      String 
         SEPARATOR="\n",
         INPUT_PROMPT="How much would you like to bet (1 - 50) or 0 to quit? ",
         ERROR_BET="You have entered an illegal value (1 - 50 or 0 to quit).",
         INDENT="\t",
         ANNOUNCE="whirrrrrr .... and your pull is ...",
         WIN_MSG="congratulations, you win: ",
         LOST_MSG="sorry, you lose.",
         END_GAME="Thanks for coming to Casino Espero.";
   
   // open our stream for input
   static Scanner inputStream=new Scanner(System.in);
      
   
   //----------------------------------------------------------------------
   // printPrompt
   // this is the GENERIC method for displaying our PROMPTS
   // note that we are overloading this method so it can accept both
   // String and Integer data
   public static void printPrompt(String msgPrompt) {
      // this is the GENERIC method for displaying our PROMPTS
      System.out.print(msgPrompt);
   }
   
   public static void printPrompt(int msgNumeric) {
      // this is the GENERIC method for displaying our PROMPTS
      System.out.print(msgNumeric);
   }
   //----------------------------------------------------------------------
   
   
   //----------------------------------------------------------------------
   public static ThreeString pull() {
      // This method instantiates and returns a ThreeString object to 
      // the client. The data of the ThreeString object has to first be 
      // filled with three randomly chosen strings according to the 
      // probabilities
      ThreeString combos=new ThreeString();
      
      combos.setString1(randString());
      combos.setString2(randString());
      combos.setString3(randString());
      
      return combos;
   }
   //----------------------------------------------------------------------
   

   //----------------------------------------------------------------------
   private static String randString()
   // This private helper method does a little work -- yet is still 
   // quite short.  It produces and returns a single random string 
   // based on the required probabilities.  It does this by calling the 
   // java Math.random() function and using the return result of that 
   // function as a means of deciding which of the four possible 
   // strings to return.  
   //       BAR (38%)
   //       cherries (40%)
   //       space (7%)
   //       7 (15%)
   {
      // our possible combinations
      String[] cards = {"cherries", "BAR", "space", "7"};
      
      int indexPt=0;
      
      // generate the randomness
      indexPt=((int) Math.floor(Math.random() * Math.floor(100)));
      
      // BAR (38%)
      if (indexPt>=0 && indexPt<=38) {
         indexPt=0;
      }
      
      // cherries (40%)
      else if (indexPt>=39 && indexPt<=78) {
         indexPt=1;
      }
      
      // space (7%)
      else if (indexPt>=79 && indexPt<=85) {
         indexPt=2;
      }
      
      // 7 (15%)
      else if (indexPt>=86 && indexPt<=100) {
         indexPt=3;
      }
      return cards[indexPt];
   }
   //----------------------------------------------------------------------
   
   
   //----------------------------------------------------------------------
   public static int getPayMultiplier (ThreeString pullString) {
      // After main() gets a ThreeString  object from pull(), which we 
      // will call pullString, it needs to know what the payout will be.  
      // That's the job of this function.  getPayMultiplier() takes the 
      // pullString as a parameter, and inspects it to determine what its 
      // pay multiplier should be:  5?  15?  100?  0?
      
      int betMultiplier=0;
      if (pullString.getString1()=="cherries" 
            && pullString.getString2() != "cherries") {
         betMultiplier=5;
      }
      else if (pullString.getString1()=="cherries" 
            && pullString.getString2()=="cherries"
            && pullString.getString3()!= "cherries") {
         betMultiplier=15;
      }
      else if (pullString.getString1()=="cherries" 
            && pullString.getString2()=="cherries"
            && pullString.getString3()== "cherries") {
         betMultiplier=30;
      }
      else if (pullString.getString1()=="BAR" 
            && pullString.getString2()=="BAR"
            && pullString.getString3()== "BAR") {
         betMultiplier=50;
      }
      else if (pullString.getString1()=="7" 
            && pullString.getString2()=="7"
            && pullString.getString3()!= "7") {
         betMultiplier=100;
      }
      return betMultiplier;
   }
   //----------------------------------------------------------------------
   

   //----------------------------------------------------------------------
   public static void display (ThreeString thePull, int winnings ) {
      // This method takes the winnings (a dollar amount) and thePull 
      // as parameters and displays the three strings inside thePull 
      // along with "sorry - you lost " or "congrats, you won $X."
      String combo="";
      
      combo=thePull.getString1()+" "+thePull.getString2()
               +" "+thePull.getString3();
      printPrompt(ANNOUNCE);
      printPrompt(SEPARATOR+combo);
      if (winnings<1) {
         printPrompt(SEPARATOR+LOST_MSG);
      }
      else {
         printPrompt(SEPARATOR+WIN_MSG);
         printPrompt(winnings);
      }
      
   }
   
   //----------------------------------------------------------------------
   public static int getBet() {
      // getBet() has to not only acquire the bet from the user, but also 
      // do the output that asks for the bet.
    
      boolean validInput=false;
      String myBetStr;
      int myBetInt=0;
      
      
      while (!validInput) {
         printPrompt(SEPARATOR+INPUT_PROMPT);
         myBetStr=inputStream.nextLine();
         if (myBetStr.length()>0) {
            myBetInt=Integer.parseInt(myBetStr);
            if (myBetInt>=0 && myBetInt<=50) 
               validInput=true;
            else
               printPrompt(ERROR_BET);
         }
         else {
            myBetStr=null;
            printPrompt(ERROR_BET);
         }
      }
      return myBetInt;
   }
   //----------------------------------------------------------------------
   
   
   //--------------------------------------------------------------------
   // main class stuff ...
   public static void main(String args[]){
      int winnings=0;
      boolean continueGame=true;
      
      // this game continues until the user enters 0
      while (continueGame) {
         SlotMachine gameSession = new SlotMachine(pull());
         gameSession.setMyBetInt(getBet());
         if (gameSession.getMyBetInt()>0) {
            winnings=gameSession.getMyBetInt()*getPayMultiplier(gameSession);
            display(gameSession, winnings);
            printPrompt(SEPARATOR);
         }
         else {
            continueGame=false;
         }
      }
      printPrompt(END_GAME);
      
      // close our stream for input
      inputStream.close();
  }
  //--------------------------------------------------------------------
}

//----------------------------------------------------------------------
// this class builds on the base class ThreeString
class SlotMachine extends ThreeString
{
   private int myBetInt=0;

   public SlotMachine(ThreeString pull)
   {
      // TODO Auto-generated constructor stub
      this.setString1(pull.getString1());
      this.setString2(pull.getString2());
      this.setString3(pull.getString3());
   }

   public int getMyBetInt()
   {
      return myBetInt;
   }
   
   public void setMyBetInt(int bet)
   {
      // TODO Auto-generated method stub
      myBetInt=bet;
   }
}
//----------------------------------------------------------------------

//----------------------------------------------------------------------
// ThreeString will consist of three private member Strings as its 
// basic data. There will be few instance methods to support that data.  
class ThreeString
{

   // the following are declarations for our limits on how long
   // or short the string should 
   public static final 
         int 
            MIN_LEN=1,
            MAX_LEN=50;
   
   // this is the default value of our string when an object is initialized
   // without any parameters or if the parameters are invalid
   public static final
      String
         DEFAULT_STRING=null;
   
   // these are the "fields" associated with the class ThreeString
   private  
      String 
         string1,
         string2,
         string3;
   
   //--------------------------------------------------------------------
   public ThreeString() {
      // ThreeString () -- a default constructor that initializes all 
      // members to DEFAULT_STRING.
      setString1(DEFAULT_STRING);
      setString2(DEFAULT_STRING);
      setString3(DEFAULT_STRING);
   }
   //--------------------------------------------------------------------

   //--------------------------------------------------------------------
   public ThreeString(String str1, String str2, String str3) {
      // this constructor is called when the instance is created
      // with parameters str1, str2, str3
      
      // note that the values of str1, str2, and str3 should be
      // within the valid ranges defined by MIN_LEN and MAX_LEN
      // before the mutators are called. OTW, they do not change.
      if (str1!=null) {
         if (validString(str1)) {
            setString1(str1);
         }
      }
      if (str2!=null) {
         if (validString(str2)) {
            setString2(str2);
         }
      }
      if (str3!=null) {
         if (validString(str3)) {
            setString3(str3);
         }
      }
   }
   //--------------------------------------------------------------------
   
   //--------------------------------------------------------------------
   public boolean validString(String str) {
      // method returns a TRUE/FALSE value depending on the 
      // parameters validity in MIN_LEN/MAX_LEN
      boolean valid=false;
      if (str.length()>=MIN_LEN && str.length()<=MAX_LEN) {
         valid=true;
      }
      return valid;
   }
   //--------------------------------------------------------------------
   
   //--------------------------------------------------------------------
   public void setString1(String str1) {
      // sets the value of ThreeString.string1
      string1=str1;
   }
   //--------------------------------------------------------------------
   
   //--------------------------------------------------------------------
   public void setString2(String str2) {
      // sets the value of ThreeString.string2
      string2=str2;
   }
   //--------------------------------------------------------------------
   
   //--------------------------------------------------------------------
   public void setString3(String str3) {
      // sets the value of ThreeString.string3
      string3=str3;
   }
   //--------------------------------------------------------------------
   
   //--------------------------------------------------------------------
   public String toString() {
      // a method that returns a String which contains all the information 
      // (three strings) of the ThreeString object.
      String 
         combinedString=getString1()+getString2()+getString3();
      return combinedString;
   }
   //--------------------------------------------------------------------

   
   //--------------------------------------------------------------------
   public String getString1()
   // accessor for string1
   {
      return string1;
   }
   //--------------------------------------------------------------------
   
   //--------------------------------------------------------------------
   public String getString2()
   // accessor for string2
   {
      return string2;
   }
   //--------------------------------------------------------------------
   
   //--------------------------------------------------------------------
   public String getString3()
   // accessor for string3
   {
      return string3;
   }
   //--------------------------------------------------------------------
}
//----------------------------------------------------------------------

/* OUTPUT

How much would you like to bet (1 - 50) or 0 to quit? 2
whirrrrrr .... and your pull is ...
BAR BAR BAR
congratulations, you win: 100

How much would you like to bet (1 - 50) or 0 to quit? 3
whirrrrrr .... and your pull is ...
7 BAR space
sorry, you lose.

How much would you like to bet (1 - 50) or 0 to quit? 4
whirrrrrr .... and your pull is ...
space BAR cherries
sorry, you lose.

How much would you like to bet (1 - 50) or 0 to quit? 10
whirrrrrr .... and your pull is ...
BAR BAR 7
sorry, you lose.

How much would you like to bet (1 - 50) or 0 to quit? 2
whirrrrrr .... and your pull is ...
BAR 7 cherries
sorry, you lose.

How much would you like to bet (1 - 50) or 0 to quit? 3
whirrrrrr .... and your pull is ...
7 cherries cherries
sorry, you lose.

How much would you like to bet (1 - 50) or 0 to quit? 6
whirrrrrr .... and your pull is ...
BAR space space
sorry, you lose.

How much would you like to bet (1 - 50) or 0 to quit? 8
whirrrrrr .... and your pull is ...
BAR cherries 7
sorry, you lose.

How much would you like to bet (1 - 50) or 0 to quit? 9
whirrrrrr .... and your pull is ...
cherries cherries cherries
congratulations, you win: 270

How much would you like to bet (1 - 50) or 0 to quit? 0
Thanks for coming to Casino Espero. 
*/
