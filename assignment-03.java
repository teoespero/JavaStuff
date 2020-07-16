// CS 1A Lab 3 Framework

import java.util.Scanner;

public class Foothill
{
   // food #1 constants
   static final String FOOD_1_NAME="potato";
   static final int FOOD_1_CALORIES_P100G=93;  // in calories
   static final double FOOD_1_SOL_FIBER_P100G=1.8;   // in grams
   static final double FOOD_1_CARBOHYDRATE_P100G=85;   // in grams
   static final double FOOD_1_PROTEIN_P100G=2.5;   // in grams
   static final double FOOD_1_VITAMIN_C_P100G=0.0096;   // in grams
   static final double FOOD_1_FAT_P100G=0.01;   // in grams
   
   // food #2 constants
   static final String FOOD_2_NAME="broccoli";
   static final int FOOD_2_CALORIES_P100G=35;  // in calories
   static final double FOOD_2_SOL_FIBER_P100G=1.2;   // in grams
   static final double FOOD_2_CARBOHYDRATE_P100G=7.2;   // in grams
   static final double FOOD_2_PROTEIN_P100G=2.4;   // in grams
   static final double FOOD_2_VITAMIN_C_P100G=0.0649;   // in grams
   static final double FOOD_2_FAT_P100G=0.4;   // in grams
   
   // food #3 constants
   static final String FOOD_3_NAME="carrots";
   static final int FOOD_3_CALORIES_P100G=35;  // in calories
   static final double FOOD_3_SOL_FIBER_P100G=1.1;   // in grams
   static final double FOOD_3_CARBOHYDRATE_P100G=8.2;   // in grams
   static final double FOOD_3_PROTEIN_P100G=0.8;   // in grams
   static final double FOOD_3_VITAMIN_C_P100G=0.0036;   // in grams
   static final double FOOD_3_FAT_P100G=0.2;   // in grams
   
   // food #4 constants
   static final String FOOD_4_NAME="celery";
   static final int FOOD_4_CALORIES_P100G=18;  // in calories
   static final double FOOD_4_SOL_FIBER_P100G=0.7;   // in grams
   static final double FOOD_4_CARBOHYDRATE_P100G=4.0;   // in grams
   static final double FOOD_4_PROTEIN_P100G=0.8;   // in grams
   static final double FOOD_4_VITAMIN_C_P100G=0.0061;   // in grams
   static final double FOOD_4_FAT_P100G=0.2;   // in grams
   
   // food #5 constants
   static final String FOOD_5_NAME="heavy whipping cream";
   static final int FOOD_5_CALORIES_P100G=345;  // in calories
   static final double FOOD_5_SOL_FIBER_P100G=0.0;   // in grams
   static final double FOOD_5_CARBOHYDRATE_P100G=2.8;   // in grams
   static final double FOOD_5_PROTEIN_P100G=2.1;   // in grams
   static final double FOOD_5_VITAMIN_C_P100G=0.0006;   // in grams
   static final double FOOD_5_FAT_P100G=37;   // in grams
   
   // food #6 constants
   static final String FOOD_6_NAME="bacon bits";
   static final int FOOD_6_CALORIES_P100G=476;  // in calories
   static final double FOOD_6_SOL_FIBER_P100G=0.0;   // in grams
   static final double FOOD_6_CARBOHYDRATE_P100G=28.6;   // in grams
   static final double FOOD_6_PROTEIN_P100G=2.1;   // in grams
   static final double FOOD_6_VITAMIN_C_P100G=0.0019;   // in grams
   static final double FOOD_6_FAT_P100G=25.9;   // in grams
   
   // Set our MIN values for servings
   static final double MINIMUN_SERVINGS=1;
   
   // Set our MIN MAX values for ingredients in grams
   static final int MIN_GRAM=0;   
   static final int MAX_GRAM=1500;
   
   
   static final String INDENT="   ";
   static final String SEPARATOR="\n";
   
   public static void main(String[] args)
   {
      // declare the variables we will be using
      
      String 
             // string variables that will hold the values
             // we will be using for the program
             recipeName="", 
             userInputStr="",
             numOfServingsStr="",
             
             // unit of weight
             unit=" grams(g)"+SEPARATOR,
             
             // our error messages
             errorMsg01=INDENT+"***You cannot make a meal for ",
             errorMsg02=INDENT+"***Invalid. Range is ",
             
             // dividing lines
             myLine="------------------------",
             // our prompt for input messages
             promptMessage01="> Name of recipe ? ",
             promptMessage02="> #servings ? ",
             promptMessage03="> #grams of ";
      
      int    // this Integer variables will hold the values
             // converted from the string values as input
            userInputInt=0,
             // you always make a meal for yourself (1) or
             // others (>1)
             numOfServings=0;
      
      boolean
             // this value will be used in validating the number 
             // of servings entered by the user
             servingsValid=false;
      
      double 
            // initialize accumulator variables
            totalSolFiber=0.0,
            totalCals= 0.0,
            totalCarb=0.0,
            totalProtein=0.0,
            totalVitC=0.0,
            totalFat=0.0,
            
            // values per serving
            totalSolFiberPerSev=0.0,
            totalCalsPerSev= 0.0,
            totalCarbPerSev=0.0,
            totalProteinPerSev=0.0,
            totalVitCPerSev=0.0,
            totalFatPerSev=0.0;
      
      // open our stream for input
      Scanner inputStream=new Scanner(System.in);
      
      // print menu
      System.out.println("---------- List of Possible Ingredients ---------");
      System.out.println(INDENT+"Food #1: "+FOOD_1_NAME);
      System.out.println(INDENT+"Food #2: "+FOOD_2_NAME);
      System.out.println(INDENT+"Food #3: "+FOOD_3_NAME);
      System.out.println(INDENT+"Food #4: "+FOOD_4_NAME);
      System.out.println(INDENT+"Food #5: "+FOOD_5_NAME);
      System.out.println(INDENT+"Food #6: "+FOOD_6_NAME+SEPARATOR);      
    
      // name of recipe
      System.out.print(promptMessage01);
      recipeName=inputStream.nextLine();
      
      // get number of servings
      while (!servingsValid) {
         System.out.print(promptMessage02);
         numOfServingsStr=inputStream.nextLine();
         numOfServings=Integer.parseInt(numOfServingsStr);
         
         // check if the number of servings is valid
         // valid must be 1 or more
         if (numOfServings >= MINIMUN_SERVINGS) {
            servingsValid=true;
         }
         else {
            System.out.println(errorMsg01+numOfServings);
            System.out.println(errorMsg02+MINIMUN_SERVINGS+" or more.");
            
            inputStream.close();
            // Terminate JVM 
            System.exit(0); 
         }
      }
     
      // food #1 ---------------------------------------------------------
      System.out.print(promptMessage03+FOOD_1_NAME+"? ");
      userInputStr=inputStream.nextLine();
      userInputInt=Integer.parseInt(userInputStr);
      
      // test if user entered a valid gram value for
      // ingredient 1
      if ((userInputInt < MIN_GRAM || userInputInt > MAX_GRAM)) {
         System.out.println(errorMsg02+"between "+MIN_GRAM+" and "+MAX_GRAM); 
         
         inputStream.close();
         // Terminate JVM 
         System.exit(0); 
      }
      
      // update accumulators food #1
      totalCals+=userInputInt*(FOOD_1_CALORIES_P100G/100.);
      totalSolFiber+=userInputInt*(FOOD_1_SOL_FIBER_P100G/100.);
      totalCarb+=userInputInt*(FOOD_1_CARBOHYDRATE_P100G/100.);
      totalProtein+=userInputInt*(FOOD_1_PROTEIN_P100G/100.);
      totalVitC+=userInputInt*(FOOD_1_VITAMIN_C_P100G/100.);
      totalFat+=userInputInt*(FOOD_1_FAT_P100G/100.);
      
      // food #2 ---------------------------------------------------------
      System.out.print(promptMessage03+FOOD_2_NAME+"? ");
      userInputStr=inputStream.nextLine();
      userInputInt=Integer.parseInt(userInputStr);
      
      // test if user entered a valid gram value for
      // ingredient 2
      if ((userInputInt < 0 || userInputInt > 1500)) {
         System.out.println(errorMsg02+"between "+MIN_GRAM+" and "+MAX_GRAM);
         
         inputStream.close();
         // Terminate JVM 
         System.exit(0); 
      }
      
      // update accumulators for food #2
      totalCals+=userInputInt*(FOOD_2_CALORIES_P100G/100.);
      totalSolFiber+=userInputInt*(FOOD_2_SOL_FIBER_P100G/100.);
      totalCarb+=userInputInt*(FOOD_2_CARBOHYDRATE_P100G/100.);
      totalProtein+=userInputInt*(FOOD_2_PROTEIN_P100G/100.);
      totalVitC+=userInputInt*(FOOD_2_VITAMIN_C_P100G/100.);
      totalFat+=userInputInt*(FOOD_2_FAT_P100G/100.);

      // food #3 ---------------------------------------------------------
      System.out.print(promptMessage03+FOOD_3_NAME+"? ");
      userInputStr=inputStream.nextLine();
      userInputInt=Integer.parseInt(userInputStr);
      
      // test if user entered a valid gram value for
      // ingredient 3
      if ((userInputInt < MIN_GRAM || userInputInt > MAX_GRAM)) {
         System.out.println(errorMsg02+"between "+MIN_GRAM+" and "+MAX_GRAM); 
         
         inputStream.close();
         // Terminate JVM 
         System.exit(0); 
      }
      
      // update accumulators food #3
      totalCals+=userInputInt*(FOOD_3_CALORIES_P100G/100.);
      totalSolFiber+=userInputInt*(FOOD_3_SOL_FIBER_P100G/100.);
      totalCarb+=userInputInt*(FOOD_3_CARBOHYDRATE_P100G/100.);
      totalProtein+=userInputInt*(FOOD_3_PROTEIN_P100G/100.);
      totalVitC+=userInputInt*(FOOD_3_VITAMIN_C_P100G/100.);
      totalFat+=userInputInt*(FOOD_3_FAT_P100G/100.);
      
      // food #4 ---------------------------------------------------------
      System.out.print(promptMessage03+FOOD_4_NAME+"? ");
      userInputStr=inputStream.nextLine();
      userInputInt=Integer.parseInt(userInputStr);
      
      // test if user entered a valid gram value for
      // ingredient 4
      if ((userInputInt < MIN_GRAM || userInputInt > MAX_GRAM)) {
         System.out.println(errorMsg02+"between "+MIN_GRAM+" and "+MAX_GRAM);
         
         inputStream.close();
         // Terminate JVM 
         System.exit(0); 
      }
      
      // update accumulators food #4
      totalCals+=userInputInt*(FOOD_4_CALORIES_P100G/100.);
      totalSolFiber+=userInputInt*(FOOD_4_SOL_FIBER_P100G/100.);
      totalCarb+=userInputInt*(FOOD_4_CARBOHYDRATE_P100G/100.);
      totalProtein+=userInputInt*(FOOD_4_PROTEIN_P100G/100.);
      totalVitC+=userInputInt*(FOOD_4_VITAMIN_C_P100G/100.);
      totalFat+=userInputInt*(FOOD_4_FAT_P100G/100.);
      
      // food #5 ---------------------------------------------------------
      System.out.print(promptMessage03 + FOOD_5_NAME+"? ");
      userInputStr=inputStream.nextLine();
      userInputInt=Integer.parseInt(userInputStr);
      
      // test if user entered a valid gram value for
      // ingredient 4
      if ((userInputInt < MIN_GRAM || userInputInt > MAX_GRAM)) {
         System.out.println(errorMsg02+"between "+MIN_GRAM+" and "+MAX_GRAM);
         
         inputStream.close();
         // Terminate JVM 
         System.exit(0); 
      }
      
      // update accumulators food #5
      totalCals+=userInputInt*(FOOD_5_CALORIES_P100G/100.);
      totalSolFiber+=userInputInt*(FOOD_5_SOL_FIBER_P100G/100.);
      totalCarb+=userInputInt*(FOOD_5_CARBOHYDRATE_P100G/100.);
      totalProtein+=userInputInt*(FOOD_5_PROTEIN_P100G / 100.);
      totalVitC+=userInputInt*(FOOD_5_VITAMIN_C_P100G/100.);
      totalFat+=userInputInt*(FOOD_5_FAT_P100G/100.);

      // food #6 ---------------------------------------------------------
      System.out.print(promptMessage03+FOOD_6_NAME+"? ");
      userInputStr=inputStream.nextLine();
      userInputInt=Integer.parseInt(userInputStr);
      
      // test if user entered a valid gram value for
      // ingredient 4
      if ((userInputInt < MIN_GRAM || userInputInt > MAX_GRAM)) {
         System.out.println(errorMsg02+"between "+MIN_GRAM+" and "+MAX_GRAM); 
         
         inputStream.close();
         // Terminate JVM 
         System.exit(0); 
      }
      
      // update accumulators food #6
      totalCals+=(userInputInt*(FOOD_6_CALORIES_P100G/100.));
      totalSolFiber+=userInputInt*(FOOD_6_SOL_FIBER_P100G/100.);
      totalCarb+=userInputInt*(FOOD_6_CARBOHYDRATE_P100G/100.);
      totalProtein+=userInputInt*(FOOD_6_PROTEIN_P100G/100.);
      totalVitC+=userInputInt*(FOOD_6_VITAMIN_C_P100G/100.);
      totalFat+=userInputInt*(FOOD_6_FAT_P100G/100.);
      
      System.out.println("... COMPUTING ...");
      
      // get the nutrition values per serving
      totalCalsPerSev=totalCals/numOfServings;
      totalSolFiberPerSev=totalSolFiber/numOfServings;
      totalCarbPerSev=totalCarb/numOfServings;
      totalProteinPerSev=totalProtein/numOfServings;
      totalVitCPerSev=totalVitC/numOfServings;
      totalFatPerSev=totalFat/numOfServings;
      
           
      // report results --------------------------------------------------
      // note that we are formatting the doubles in to 3 decimal places
      
      // print the headers
      System.out.println(myLine+myLine);
      System.out.println("\nThe nutritional value per serving "+recipeName);
      System.out.println(myLine+myLine);
      
      // print the nutrition values 
      System.out.printf(INDENT+"Calories: %.3f"+unit,totalCalsPerSev);
      System.out.printf(INDENT+"Soluble Fiber: %.3f"+unit,totalSolFiberPerSev);
      System.out.printf(INDENT+"Carbohydrates: %.3f"+unit,totalCarbPerSev);
      System.out.printf(INDENT+"Protein: %.3f"+unit,totalProteinPerSev);
      System.out.printf(INDENT+"Vitamin C: %.3f"+unit,totalVitCPerSev);
      System.out.printf(INDENT+"Fat: %.3f"+unit,totalFatPerSev);
      
      // end of the report
      System.out.println(myLine+myLine);
   }
}
/* CONSOLE OUTPUT
---------- List of Possible Ingredients ---------
   Food #1: potato
   Food #2: broccoli
   Food #3: carrots
   Food #4: celery
   Food #5: heavy whipping cream
   Food #6: bacon bits

> Name of recipe ? TEO'S VEGETABLE SOUP
> #servings ? 4
> #grams of potato? 4
> #grams of broccoli? 4
> #grams of carrots? 4
> #grams of celery? 4
> #grams of heavy whipping cream? 4
> #grams of bacon bits? 4
... COMPUTING ...
------------------------------------------------

The nutritional value per serving TEO'S VEGETABLE SOUP
------------------------------------------------
   Calories: 10.020 grams(g)
   Soluble Fiber: 0.048 grams(g)
   Carbohydrates: 1.358 grams(g)
   Protein: 0.107 grams(g)
   Vitamin C: 0.001 grams(g)
   Fat: 0.637 grams(g)
------------------------------------------------
*/