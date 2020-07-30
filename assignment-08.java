//***************************************************************************
// Assignment 8 - Computer Dating
// Date Written: 07-30-2020
// Author: Teo Espero
// Description:
//    This Java program was written to simulate a DATING application
//    which test compatibility based on gender, gender searched, romance, 
//    distance, and finance
//***************************************************************************

public class Foothill {
   
   //----------------------------------------------------------------------
   // CONSTANT DECLARATIONS
   // these are PUBLIC constants
   // and can be used anywhere in the program
   public static final
      String
         SEPARATOR="\n",
         INDENT="  ",
         DEFAULT_NAME="John Doe",
         GNDR_ERR=" rejected as gender",
         LIMIT_ERR=" is beyond allowable values (1-10)";
   
   public static final
      int
         MIN_ROMANCE=1, 
         MAX_ROMANCE=10,
         MIN_FINANCE=1,
         MAX_FINANCE=10,
         MIN_DISTANCE=1,
         MAX_DISTANCE=10,
         MIN_NAME_LEN=4,
         MAX_NAME_LEN=20;
   
   public static final
      char
         DEFAULT_GEND='M', 
         DEFAULT_SEARCH_GEND='M';
   //----------------------------------------------------------------------
   
   
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
   
   public static void printPrompt(Object myObject) {
      // this is the GENERIC method for displaying our PROMPTS
      System.out.print(myObject);
   }
   //----------------------------------------------------------------------
   
   
   //----------------------------------------------------------------------
   //  This method will print the names of the two objects and show 
   // the fit value.  
   public static void displayTwoProfiles(
         DateProfile profile1, 
         DateProfile profile2) {
      printPrompt("Fit between "+profile1.getName()+" ");
      printPrompt("and "+profile2.getName()+":");
      printPrompt(INDENT+profile1.fitValue(profile2));
   }
   
   
   //----------------------------------------------------------------------
   // MAIN PROGRAM
   // this is where the objects are created and the methods are called
   public static void main(String args[]){

      // OBJECT VALUES
      // to make use of the lesson we have for the chapter
      // I am designing the application to use arrays
      // in creating the date profiles
      String[][] dateProfiles = {
            // date profile 01
            {"Teo Espero", "M", "F", "7", "6","1"},
            // date profile 02
            {"Jane Somebody ", "F", "M", "8", "5","2"},
            // date profile 03
            {"Elvis Nobody", "M", "F", "10", "7","8"},
            // date profile 04
            {"Jane Peabody", "F", "M", "5", "6","8"},
            // date profile 05
            {"Jane Anybody", "F", "F", "5", "6","8"},
            // date profile 06
            {"Jane Not Defined", "Q", "F", "10", "6","8"}
      };


      //--------------------------------------------------------
      // DATE PROFILES
      // as mentioned earlier the array values will be used
      // in populating our Object data
      //       element[a][a] = name
      //       element[a][b] = gender
      //       element[a][c] = search gender
      //       element[a][d] = romance
      //       element[a][e] = finance
      //       element[a][f] = distance
      //
      //--------------------------------------------------------
      
      
      //--------------------------------------------------------
      // date profile 01
      DateProfile 
         dateProfile01=new DateProfile(
                  // name
                  dateProfiles[0][0],
                  // gender
                  dateProfiles[0][1].charAt(0),
                  // search gender
                  dateProfiles[0][2].charAt(0),
                  // romance
                  Integer.parseInt(dateProfiles[0][3]),
                  // finance
                  Integer.parseInt(dateProfiles[0][4]),
                  // distance
                  Integer.parseInt(dateProfiles[0][5])
               );
      
      //--------------------------------------------------------
      // date profile 02
      DateProfile 
         dateProfile02=new DateProfile(
                  // name
                  dateProfiles[1][0],
                  // gender
                  dateProfiles[1][1].charAt(0),
                  // search gender
                  dateProfiles[1][2].charAt(0),
                  // romance
                  Integer.parseInt(dateProfiles[1][3]),
                  //finance
                  Integer.parseInt(dateProfiles[1][4]),
                  //distance
                  Integer.parseInt(dateProfiles[1][5])
               );
      
      //--------------------------------------------------------      
      // date profile 03
      DateProfile 
         dateProfile03=new DateProfile(
                  // name
                  dateProfiles[2][0],
                  // gender
                  dateProfiles[2][1].charAt(0),
                  // search gender
                  dateProfiles[2][2].charAt(0),
                  // romance
                  Integer.parseInt(dateProfiles[2][3]),
                  // finance
                  Integer.parseInt(dateProfiles[2][4]),
                  // distance
                  Integer.parseInt(dateProfiles[2][5])
               );
      
      //--------------------------------------------------------
      // date profile 04
      DateProfile 
         dateProfile04=new DateProfile(
                  // name
                  dateProfiles[3][0],
                  // gender
                  dateProfiles[3][1].charAt(0),
                  // search gender
                  dateProfiles[3][2].charAt(0),
                  // romance
                  Integer.parseInt(dateProfiles[3][3]),
                  // finance
                  Integer.parseInt(dateProfiles[3][4]),
                  // distance
                  Integer.parseInt(dateProfiles[3][5])
               );
      
      //--------------------------------------------------------
      // date profile 05
      DateProfile 
         dateProfile05=new DateProfile(
                  // name
                  dateProfiles[4][0],
                  // gender
                  dateProfiles[4][1].charAt(0),
                  // search gender
                  dateProfiles[4][2].charAt(0),
                  // romance
                  Integer.parseInt(dateProfiles[4][3]),
                  // finance
                  Integer.parseInt(dateProfiles[4][4]),
                  // distance
                  Integer.parseInt(dateProfiles[4][5])
               );
      
      
      // initialized profiles
      
      //--------------------------------------------------------
      // profile 01 and profile 02
      displayTwoProfiles(dateProfile01, dateProfile02);
      printPrompt(SEPARATOR);
      //--------------------------------------------------------

      //--------------------------------------------------------
      // profile 03 and profile 04
      displayTwoProfiles(dateProfile03, dateProfile04);
      printPrompt(SEPARATOR);
      //--------------------------------------------------------
      
      //--------------------------------------------------------
      // profile 01 and profile 03
      displayTwoProfiles(dateProfile01, dateProfile03);
      printPrompt(SEPARATOR);
      //--------------------------------------------------------
      
      //--------------------------------------------------------
      // profile 02 and profile 04
      displayTwoProfiles(dateProfile02, dateProfile04);
      printPrompt(SEPARATOR);
      //--------------------------------------------------------
      
      //--------------------------------------------------------
      // profile 01 and profile 04
      displayTwoProfiles(dateProfile01, dateProfile04);
      printPrompt(SEPARATOR);  
      //--------------------------------------------------------
      
      //--------------------------------------------------------
      // profile 02 and profile 03
      displayTwoProfiles(dateProfile02, dateProfile03);
      printPrompt(SEPARATOR);  
      //--------------------------------------------------------
      
      //--------------------------------------------------------
      // profile 01 and profile 01
      displayTwoProfiles(dateProfile01, dateProfile01);
      printPrompt(SEPARATOR);
      //--------------------------------------------------------
      
      //--------------------------------------------------------
      // profile 05 and profile 05
      displayTwoProfiles(dateProfile05, dateProfile05);
      printPrompt(SEPARATOR);  
      //--------------------------------------------------------
      

      
      //--------------------------------------------------------
      // these are just to verify the values
      // for each class instance
      printPrompt(SEPARATOR);  
      printPrompt("these are just to verify the values"+SEPARATOR);
      dateProfile01.profileDump();
      dateProfile02.profileDump();
      dateProfile03.profileDump();
      dateProfile04.profileDump();
      dateProfile05.profileDump();
      
      //--------------------------------------------------------
      // date profile 06
      DateProfile 
         dateProfile06=new DateProfile(
                  // name
                  dateProfiles[5][0],
                  // gender
                  dateProfiles[5][1].charAt(0),
                  // search gender
                  dateProfiles[5][2].charAt(0),
                  // romance
                  Integer.parseInt(dateProfiles[5][3]),
                  // finance
                  Integer.parseInt(dateProfiles[5][4]),
                  // distance
                  Integer.parseInt(dateProfiles[5][5])
               );
      
      
      //--------------------------------------------------------
      // profile 05 and profile 06
      displayTwoProfiles(dateProfile05, dateProfile06);
      printPrompt(SEPARATOR);  
      //--------------------------------------------------------
      
      dateProfile06.profileDump();
   }
   //----------------------------------------------------------------------
}



//-------------------------------------------------------------------------
class DateProfile {
   // Each object in the DateProfile class represents an applicant's profile.
   // If the object is ('M', 'F', 7, 3, 5, "Tom Smith") romance being 
   // somewhat important (7), finance being less important (3), and distance 
   // being in the middle (5).
   
   //--------------------------------------------------------
   // DateProfile fields
   private 
      char 
         gender='\0',
         searchGender='\0';
   
   private
      int
         romance=0,
         finance=0,
         distance=0;
   
   private
      String
         name=null;
   //--------------------------------------------------------
   
   
   
   //----------------------------------------------------------------------
   public DateProfile() {
      // method that sets all six members to their default values
      this.setName(Foothill.DEFAULT_NAME);
      this.setGender(Foothill.DEFAULT_GEND);
      this.setSearchGender(Foothill.DEFAULT_SEARCH_GEND);
      this.setRomance(Foothill.MIN_ROMANCE);
      this.setFinance(Foothill.MIN_FINANCE);
      this.setDistance(Foothill.MIN_DISTANCE);
   }
   //----------------------------------------------------------------------
   
   
   //----------------------------------------------------------------------
   // constructor that initializes the fields
   public DateProfile(String profName, 
                      char profGender,
                      char profSrchGender,
                      int profRomance,
                      int profFinance,
                      int profDistance) {
      
      // check name
      if (profName.length()>=Foothill.MIN_NAME_LEN) {
         setName(profName);
      }
      else {
         setName(Foothill.DEFAULT_NAME);
      }
      
      // check gender
      
      // it can't be blank
      if (profGender!='\0') {
         
         // should just be M or F
         if (Character.toUpperCase(profGender)=='M' 
            || Character.toUpperCase(profGender)=='F') {
            setGender(profGender);
         }
         else {
            Foothill.printPrompt(Foothill.SEPARATOR+profGender
                  +Foothill.GNDR_ERR);
            System.exit(0); 
         }
      }
      else {
         setGender(Foothill.DEFAULT_GEND);
      }
      
      // check search gender
      if (profSrchGender!='\0') {
         if (Character.toUpperCase(profSrchGender)=='M' 
            || Character.toUpperCase(profSrchGender)=='F') {
            setSearchGender(profSrchGender);
         }
         else {
            Foothill.printPrompt(Foothill.SEPARATOR+profGender
                  +Foothill.GNDR_ERR);
            System.exit(0); 
         }
      }
      else {
         setSearchGender(Foothill.DEFAULT_SEARCH_GEND);
      }
      
      // check romance
      if (profRomance>=Foothill.MIN_ROMANCE 
         && profRomance<=Foothill.MAX_ROMANCE) {
         setRomance(profRomance);
      }
      else {
         Foothill.printPrompt(Foothill.SEPARATOR+profRomance
               +Foothill.LIMIT_ERR+" for romance");
         System.exit(0); 
      }
      
      // check finance
      if (profFinance>=Foothill.MIN_FINANCE
         && profFinance<=Foothill.MAX_FINANCE) {
         setFinance(profFinance);
      }
      else {
         Foothill.printPrompt(Foothill.SEPARATOR+profFinance
               +Foothill.LIMIT_ERR+" for finance");
         System.exit(0); 
      }
      
      // check distance
      if (profDistance>=Foothill.MIN_DISTANCE
         && profDistance<=Foothill.MAX_DISTANCE) {
         setDistance(profDistance);
      }
      else {
         Foothill.printPrompt(Foothill.SEPARATOR+profDistance
               +Foothill.LIMIT_ERR+" for distance");
         System.exit(0); 
      }
   }
   //----------------------------------------------------------------------
   
   
   //----------------------------------------------------------------------
   public void profileDump() {
      
      Foothill.printPrompt(Foothill.SEPARATOR);
      Foothill.printPrompt("name="+this.name+Foothill.SEPARATOR);
      Foothill.printPrompt("gender="+this.gender+Foothill.SEPARATOR);
      Foothill.printPrompt("search gender="+this.searchGender
                           +Foothill.SEPARATOR);
      Foothill.printPrompt("romance="+this.romance+Foothill.SEPARATOR);
      Foothill.printPrompt("finance="+this.finance+Foothill.SEPARATOR);
      Foothill.printPrompt("distance="+this.distance+Foothill.SEPARATOR);
   }
   //----------------------------------------------------------------------  
   
   // ACCESSORS
   //----------------------------------------------------------------------
   public String getName() {
      return name;
   }
   //----------------------------------------------------------------------
   
   //----------------------------------------------------------------------
   public char getGender() {
      return gender;
   }
   //----------------------------------------------------------------------
   
   //----------------------------------------------------------------------
   public char getSearchGender() {
      return searchGender;
   }
   //----------------------------------------------------------------------
   
   //----------------------------------------------------------------------   
   public int getRomance() {
      return romance;
   }
   //----------------------------------------------------------------------
   
   //----------------------------------------------------------------------   
   public int getFinance() {
      return finance;
   }
   //----------------------------------------------------------------------
   
   //----------------------------------------------------------------------   
   public int getDistance() {
      return distance;
   }
   //----------------------------------------------------------------------
   
   // MUTATORS   
   //----------------------------------------------------------------------   
   public boolean setName(String profName) {
      name=profName;
      return true;
   }
   //----------------------------------------------------------------------
   
   //----------------------------------------------------------------------   
   public boolean setGender(char gdr) {
      gender=gdr;
      return true;
   }
   //----------------------------------------------------------------------
   
   //----------------------------------------------------------------------   
   public boolean setSearchGender(char gdr) {
      searchGender=gdr;
      return true;
   }
   //----------------------------------------------------------------------
   
   //----------------------------------------------------------------------   
   public boolean setRomance(int profRomance) {
      romance=profRomance;
      return true;
   }
   //----------------------------------------------------------------------
   
   //----------------------------------------------------------------------   
   public boolean setFinance(int profFinance) {
      finance=profFinance;
      return true;
   }
   //----------------------------------------------------------------------
   
   //----------------------------------------------------------------------   
   public boolean setDistance(int profDistance) {
      distance=profDistance;
      return true;
   }
   //----------------------------------------------------------------------
   
   //----------------------------------------------------------------------
   public double fitValue(DateProfile partner){
      //  which returns a number from 0.0 (very bad fit) to 1.0 
      // (perfect fit).  The public instance method compares the calling 
      // object (this) to the object passed as a parameter.  
       return (double)Math.round((this.determineGenderFit(partner)*
             this.determineRomanceFit(partner)*
             this.determineFinanceFit(partner)*
             this.determineDistanceFit(partner)) * 100000d) / 100000d;
   }
   //----------------------------------------------------------------------
   
   //----------------------------------------------------------------------
   public double determineGenderFit(DateProfile partner) {
      // This private instance method returns either a 0 or 1 depending 
      // on the gender compatibility of the calling object and the passed 
      // parameter object.  You have to compare gender compatibility 
      // completely: i.e., there must be mutual consent on this one!  
      // It is used by the public fitValue(), not directly by 
      // the client main().
      if(this.gender==partner.getSearchGender() 
         && this.searchGender==partner.getGender())
         return 1.0;
      else
         return 0.0;
   }
   //----------------------------------------------------------------------
   
   
   //----------------------------------------------------------------------
   public double determineRomanceFit(DateProfile partner) {
      // This private instance method returns a number from (but not 
      // including) 0.0 to (and including) 1.0 depending on the romance 
      // compatibility of the calling object and the passed parameter object. 
      // It should call calculateFit().
      return calculateFit(partner.getRomance(), this.getRomance());
   }
   //----------------------------------------------------------------------
   
   
   //----------------------------------------------------------------------
   public double determineFinanceFit(DateProfile partner) {
      // This private instance method returns a number from 
      // (but not including) 0.0 to (and including) 1.0 depending on the 
      // finance compatibility of the calling object and the passed 
      // parameter object. It should call calculateFit(). 
      return calculateFit(partner.getFinance(), this.getFinance());
   }
   //----------------------------------------------------------------------
   
   //----------------------------------------------------------------------
   public double determineDistanceFit(DateProfile partner) {
      // This private instance method returns a number from (but not 
      // including) 0.0 to (and including) 1.0 depending on the distance 
      // compatibility of the calling object and the passed parameter 
      // object. It should call calculateFit().
      return calculateFit(partner.getDistance(), this.getDistance());
   }
   //----------------------------------------------------------------------
   
   
   //----------------------------------------------------------------------
   public double calculateFit(double partnerValue, double inherentValue) {
      // will be used to better serve the three determine...fit() methods.  
      // This private instance method, will take the two values and 
      // compare them.  The numbers should be highest (1.0) if the two 
      // values are equal (both 3, both 5, both 7) and lowest (perhaps a 
      // small non-zero value like .1)  if their difference is 9.  
      double difference;
      
      if(inherentValue>partnerValue)
         difference=inherentValue-partnerValue;
      else
         difference=partnerValue-inherentValue;
      if(difference==0)
         return 1.0;
      else if(difference==9)
         return 0.1;
      else
         return (10-difference)/10.0;
   }
   //----------------------------------------------------------------------
}
//--------------------------------------------------------------------------
/*
SAMPLE RUN
Fit between Teo Espero and Jane Somebody :  0.729
Fit between Elvis Nobody and Jane Peabody:  0.45
Fit between Teo Espero and Elvis Nobody:  0.0
Fit between Jane Somebody  and Jane Peabody:  0.0
Fit between Teo Espero and Jane Peabody:  0.24
Fit between Jane Somebody  and Elvis Nobody:  0.256
Fit between Teo Espero and Teo Espero:  0.0
Fit between Jane Anybody and Jane Anybody:  1.0
these are just to verify the values

name=Teo Espero
gender=M
search gender=F
romance=7
finance=6
distance=1

name=Jane Somebody 
gender=F
search gender=M
romance=8
finance=5
distance=2

name=Elvis Nobody
gender=M
search gender=F
romance=10
finance=7
distance=8

name=Jane Peabody
gender=F
search gender=M
romance=5
finance=6
distance=8

name=Jane Anybody
gender=F
search gender=F
romance=5
finance=6
distance=8

Q rejected as gender
*/