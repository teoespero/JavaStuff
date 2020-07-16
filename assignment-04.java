// ---------------------------------------------------------------------------
// Assignment 4 - Free Frozen Yogurt
// 20200713
// Teo Espero
// This Java program was written to simulate a POS for Foothill Fro-Yo, LLC, 
// gives customers a stamp every time they purchase a yogurt.  After they earn 
// a certain number of stamps, they qualify for a free yogurt, which they may 
// use toward the purchase of a single yogurt.
//---------------------------------------------------------------------------


import java.util.Scanner;

public class Foothill
//------------------------------------------
// Class Foothill contains the values and variables
// needed in our program
{
   static final String INDENT="   ";
   static final String SEPARATOR="\n";
   
   //------------------------------------------
   // the following string constants are defined
   // they contain all the prompts and messages in the system
   static final String 
         STAMPMSG01="You qualify for a free yogurt. ",
         STAMPMSG02="Would you like to use your credits? (Y or N) ",
         YES_OR_NO_MSG="*** Invalid response ***",
         MSG01="You have just used 11 credits and have %d left.%n",
         MSG02="You just earned %d stamps and have a total of %d to use.%n",
         MSG03="You just earned %d stamps and have a total of %d to use.%n",
         MSG04="Enjoy your free yogurt.%n";
   
   static final int STAMP_VALUE=11; 
   
 
   //------------------------------------------
   // myMenu method displays our menu
   //       P (process a Purchase)
   //       S (Shut down.)
   static void myMenu() {
      System.out.println(SEPARATOR+"Menu:");
      System.out.println(INDENT+"P (process Purchase)");
      System.out.println(INDENT+"S (Shut down)");
      System.out.print(SEPARATOR+"> Your Choice: ");
   }
   //------------------------------------------
   
   
   //------------------------------------------
   // getHowMany method is our method that when called
   // prompts for the number of Yogurt that the customer 
   // would like to purchase
   static int getHowMany() {   
      Scanner inputStream=new Scanner(System.in);
      
      System.out.printf("%n> How many yogurts would you like to buy ? ");
      String howManyStr=inputStream.nextLine();
      int howManyInt=Integer.parseInt(howManyStr);
      return howManyInt;
   }
   //------------------------------------------
   
   
   
   
   //------------------------------------------
   // getChoice method returns the uppercase value of
   // the transaction that the customer would like to do
   //       P (process a Purchase)
   //       S (Shut down.)
   static char getChoice() {
      Scanner inputStream=new Scanner(System.in);
      char userInput=inputStream.next().charAt(0);
      userInput=Character.toUpperCase(userInput);
      return userInput;
   }
   //------------------------------------------
   
   
   
   
   //------------------------------------------
   // useStamp validates whether the customer wold like 
   // to avail of a free yogurt using their stamp
   static boolean useStamp() {
      
      Scanner inputStream=new Scanner(System.in);
      
      char yesOrNo='\0';
      boolean stamps=false;
      
      System.out.print(SEPARATOR+STAMPMSG01+STAMPMSG02);
      
      while (yesOrNo!='N' || yesOrNo!='Y') {
         // note that the prompt is repeated until the customer
         // enters a valid response Y/N
         
         yesOrNo=inputStream.next().charAt(0);
         yesOrNo=Character.toUpperCase(yesOrNo);
         if (yesOrNo=='Y') {
            stamps=true;
            break;
         }
         if (yesOrNo=='N') {
            stamps=false;
            break;
         }
         else {
            System.out.println(YES_OR_NO_MSG);
         }
      }
      return stamps;
   }
   //------------------------------------------
   
   
   
   
   //------------------------------------------
   // our main program is still lengthy, i would like to further
   // break it down into methods
   public static void main(String[] args)
   {
      // declare the variables we will be using
      
      int
            numOfYogurt,
            newNumOfYogurt,
            currStamp=0;
      
      char 
            myChoice = '\0';
      boolean 
            useYourStamps=false;


      while (myChoice!='S') {
         newNumOfYogurt=0;
         numOfYogurt=0;
         myChoice = '\0';
         myMenu();
         myChoice = getChoice();
         if (myChoice=='P') {
            
            // if the customer has 11+ stamps, they are given 
            // the option to avail of a free yogurt
            if (currStamp>10) {
               useYourStamps=useStamp();
               if (useYourStamps==true) {
                  currStamp=currStamp-STAMP_VALUE;
                  newNumOfYogurt=1;
                  numOfYogurt=1;
                  System.out.printf(SEPARATOR+MSG01+MSG04,currStamp);
               }
               // otherwise, a normal transaction is done
               if (useYourStamps==false) {
                  numOfYogurt=getHowMany();
                  newNumOfYogurt=newNumOfYogurt+numOfYogurt;
                  currStamp=currStamp+numOfYogurt;
                  System.out.printf(SEPARATOR+MSG02,newNumOfYogurt, currStamp);
               }
            }
            // if it is the first buy or they do not have
            // 11+ stamps, then it is by default a normal transaction
            else {
               numOfYogurt=getHowMany();
               currStamp=currStamp+numOfYogurt;
               newNumOfYogurt=newNumOfYogurt+numOfYogurt;
               System.out.printf(SEPARATOR+MSG03,newNumOfYogurt,currStamp);
            }
         }         
      }
      // the program loops until the user picks S
      // we then exit gracefully to the OS
      // note that i did not close any of the streams and is just letting
      // the garbage collector to do it for me
      System.out.println(SEPARATOR+"*** Goodbye ***");
      System.exit(0); 

   }
}

//------------------------------------------
/* CONSOLE OUTPUT

   Menu:
      P (process Purchase)
      S (Shut down)
   
   > Your Choice: p
   
   > How many yogurts would you like to buy ? 14
   
   You just earned 14 stamps and have a total of 14 to use.
   
   Menu:
      P (process Purchase)
      S (Shut down)
   
   > Your Choice: p
   
   You qualify for a free yogurt. Would you like to use your credits? (Y or N) n
   
   > How many yogurts would you like to buy ? 21
   
   You just earned 21 stamps and have a total of 35 to use.
   
   Menu:
      P (process Purchase)
      S (Shut down)
   
   > Your Choice: p
   
   You qualify for a free yogurt. Would you like to use your credits? (Y or N) n
   
   > How many yogurts would you like to buy ? 2
   
   You just earned 2 stamps and have a total of 37 to use.
   
   Menu:
      P (process Purchase)
      S (Shut down)
   
   > Your Choice: a
   
   Menu:
      P (process Purchase)
      S (Shut down)
   
   > Your Choice: p
   
   You qualify for a free yogurt. Would you like to use your credits? (Y or N) s
   *** Invalid response ***
   y
   
   You have just used 11 credits and have 26 left.
   Enjoy your free yogurt.
   
   Menu:
      P (process Purchase)
      S (Shut down)
   
   > Your Choice: s
   
   *** Goodbye ***
*/