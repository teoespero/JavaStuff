/************************************************************************
 * Assignment 6 - A Three String Class
 * Description:
 * The assignment is to first create a class called ThreeString. 
 * ThreeString will consist of three private member Strings as its basic 
 * data. There will be few instance methods to support that data.
 * 
 * Author: Teo Espero
 * Date Written: 07-27-2020  
 ************************************************************************/

// this is not really used but is included for compliance
import java.util.*;

public class Foothill
{
   // we are declaring our NEW_LINE character as a CONSTANT
   private static final 
      String
         NEW_LINE="\n";

   // main class stuff ...
   
  public static void main(String args[]){  
     
      //------------------------------------------------------------------
      // myStringObject01
      // instance 1 of our ThreeString class  
     //------------------------------------------------------------------
      System.out.print("myStringObject01"+NEW_LINE);
      System.out.print(NEW_LINE+"Class is uninitialized"+NEW_LINE); 
      System.out.print("-----------------------------------------------");
      System.out.print(NEW_LINE);
      ThreeString myStringObject01 = new ThreeString();
      System.out.print(myStringObject01.getString1());  
      System.out.print(NEW_LINE+myStringObject01.getString2());
      System.out.print(NEW_LINE+myStringObject01.getString3());
      System.out.print(NEW_LINE);
      System.out.print(NEW_LINE+"Class is initialized"+NEW_LINE);
      System.out.print("-----------------------------------------------");
      myStringObject01.setString1(NEW_LINE+"Hello ");  
      myStringObject01.setString2(NEW_LINE+"World! ");
      myStringObject01.setString3(NEW_LINE+"This is Java with Objects");
      
      System.out.print(myStringObject01.getString1());  
      System.out.print(myStringObject01.getString2());  
      System.out.print(myStringObject01.getString3());
      //------------------------------------------------------------------
      
      //------------------------------------------------------------------
      // myStringObject02
      // instance 2 of our ThreeString class
      //------------------------------------------------------------------
      ThreeString myStringObject02 = new ThreeString("My ","name is ","Teo.");
      System.out.print(NEW_LINE+NEW_LINE+"myStringObject02"+NEW_LINE);
      System.out.print(NEW_LINE+"Class is initialized"+NEW_LINE); 
      System.out.print("-----------------------------------------------");
      System.out.print(NEW_LINE+myStringObject02.getString1());  
      System.out.print(NEW_LINE+myStringObject02.getString2());  
      System.out.print(NEW_LINE+myStringObject02.getString3());
      
      System.out.print(NEW_LINE);
      System.out.print(NEW_LINE+"Objects Combined"+NEW_LINE); 
      System.out.println(myStringObject02.toString());
      //------------------------------------------------------------------

      //------------------------------------------------------------------
      // myStringObject03
      // instance 3 of our ThreeString class
      //------------------------------------------------------------------
      System.out.print(NEW_LINE+"myStringObject03"+NEW_LINE);
      ThreeString myStringObject03 = new ThreeString();
      System.out.print(NEW_LINE+"Class is uninitialized"+NEW_LINE); 
      System.out.print("-----------------------------------------------");
      System.out.println(NEW_LINE+myStringObject03.toString());
      System.out.print(NEW_LINE+"Class is initialized"+NEW_LINE); 
      System.out.print("-----------------------------------------------");
      myStringObject03.setString1(NEW_LINE+"This is string1.");  
      myStringObject03.setString2(NEW_LINE+"This is string2.");
      myStringObject03.setString3(NEW_LINE+"This is string3.");
      System.out.print(myStringObject03.getString1());  
      System.out.print(myStringObject03.getString2());  
      System.out.print(myStringObject03.getString3());
      //------------------------------------------------------------------
      
      //------------------------------------------------------------------
      // myStringObject04
      // instance 4 of our ThreeString class
      //------------------------------------------------------------------
      System.out.print(NEW_LINE+NEW_LINE+"myStringObject04"+NEW_LINE);
      System.out.print(NEW_LINE+"Class is initialized"+NEW_LINE); 
      System.out.print("-----------------------------------------------");
      ThreeString myStringObject04 = new ThreeString();
      myStringObject04.setString1("string1 is printed.");  
      myStringObject04.setString2(NEW_LINE+"string2 is printed.");
      myStringObject04.setString3(NEW_LINE+"string3 is printed");
      System.out.print(NEW_LINE);
      System.out.print(myStringObject04.getString1());  
      System.out.print(myStringObject04.getString2());  
      System.out.print(myStringObject04.getString3());
      //------------------------------------------------------------------
      }
}

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

/*
   myStringObject01
   
   Class is uninitialized
   -----------------------------------------------
   null
   null
   null
   
   Class is initialized
   -----------------------------------------------
   Hello 
   World! 
   This is Java with Objects
   
   myStringObject02
   
   Class is initialized
   -----------------------------------------------
   My 
   name is 
   Teo.
   
   Objects Combined
   My name is Teo.
   
   myStringObject03
   
   Class is uninitialized
   -----------------------------------------------
   nullnullnull
   
   Class is initialized
   -----------------------------------------------
   This is string1.
   This is string2.
   This is string3.
   
   myStringObject04
   
   Class is initialized
   -----------------------------------------------
   string1 is printed.
   string2 is printed.
   string3 is printed
*/