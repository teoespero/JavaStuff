import java.util.Scanner;

public class Foothill
{
   public static final
      String
         SEPARATOR="\n",
         INDENT="  ",
         PLAY_ROW="Enter a row (0, 1, or 2) for player ",
         CELL_TAKEN="The cell is already taken.",
         PLAY_COL="Enter a column (0, 1, or 2) for player ",
         PROMPT="What is the symbol for a player?",
         ERR="Sorry that is no good, choose a capital letter.  Try again: ";
   
   public static final
      int 
         MAX_WIDTH=3,
         MAX_HEIGHT=3,
         MAX_WINS=5,
         MAX_GAMES=2;
   
   public static Player[][] myBoard=new Player[MAX_HEIGHT][MAX_WIDTH];
   
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
   
   public static void printPrompt(Object myObject) {
      // this is the GENERIC method for displaying our PROMPTS
      System.out.print(myObject);
   }
   //----------------------------------------------------------------------
   
   
   //--------------------------------------------------------------------------
   public static char askUserForSymbol()
   // will ask the user what the symbol for will be for that player.  
   // Don't allow the method to return until a valid capital letter 
   // is entered.  No other ASCII values are allowed.
   {
      String
         inputStr="";
      char
         inputChr=' ';
      
      
      printPrompt(PROMPT+SEPARATOR);
      inputStr=inputStream.nextLine();
      inputChr=inputStr.charAt(0);
      while(!(inputChr>='A' && inputChr<='Z')) {
         printPrompt(ERR);
         inputStr=inputStream.nextLine();
         inputChr=inputStr.charAt(0);
      }
      return inputChr;
   }
   //--------------------------------------------------------------------------
   
   
   //--------------------------------------------------------------------------
   public static void resetBoard(Player[][] board, Player defPlayer)
   // which is used at the start of any game to fill the board with the 
   // default Player.
   {

      for (int myRow=0; myRow<board.length; myRow++)
         for (int myCol=0; myCol<board.length; myCol++)
         {
            board[myRow][myCol] = new Player();
            board[myRow][myCol].setSymbol(defPlayer.getSymbol());
         }
   }
   //--------------------------------------------------------------------------
   
   
   //--------------------------------------------------------------------------
   public static void displayBoard(Player[][] board)
   // which will print out the current status of the board
   {
      printPrompt(SEPARATOR);
      printPrompt("-------------"+SEPARATOR);
      for (int myRow=0; myRow<board.length; myRow++)
      {
         printPrompt("| ");
         for (int myCol=0; myCol<board.length; myCol++)
         {
            printPrompt(board[myRow][myCol].getSymbol()+" | ");
         }
         printPrompt(SEPARATOR+"-------------"+SEPARATOR);
      }
   }
   //--------------------------------------------------------------------------
   
   
   //--------------------------------------------------------------------------
   public static void makeAMove(Player[][] board, Player player)
   // ask the user which row and column they want for the incoming player by 
   // using their symbol. (ie. Enter a row for player S:)  If the location 
   // is already taken, then they cannot go there and must be asked again.  
   // Don't return until a good location is chosen.  
   {
      boolean okLocation=false;
      int 
         rowIndex=0,
         colIndex=0;
      
      //board[rowIndex][colIndex] = new Player();
      while (!okLocation) 
      {
         printPrompt(PLAY_ROW+player.getSymbol()+": ");
         rowIndex = inputStream.nextInt();
         
         printPrompt(PLAY_COL+player.getSymbol()+": ");
         colIndex = inputStream.nextInt();
        
         if (board[rowIndex][colIndex].getSymbol()!='\u0000')
         {
            printPrompt(CELL_TAKEN+SEPARATOR);
            okLocation=false;
         }
         else
         {
            board[rowIndex][colIndex].setSymbol(player.getSymbol());
            okLocation=true;
         }
      }
   }
   //--------------------------------------------------------------------------
   
   //--------------------------------------------------------------------------
   public static boolean isWon(Player[][] board, Player player)
   // will use the symbol of the incoming player to check each of the 
   // possible ways to win.  How many ways are there?  Don't forget about 
   // the diagonal.  Return true if they won, false if not yet.
   {
      // Check rows
      for (int myRow=0; myRow<board.length; myRow++)
         if (player.getSymbol()==board[myRow][0].getSymbol() && 
             player.getSymbol()==board[myRow][1].getSymbol() && 
             player.getSymbol()==board[myRow][2].getSymbol()) 
         {
            printPrompt(player.getSymbol()+" WON.");
            return true;
         }


      // Check columns
      for (int myCol=0; myCol<board.length; myCol++)
         if (player.getSymbol()==board[0][myCol].getSymbol() && 
         player.getSymbol()==board[1][myCol].getSymbol() && 
         player.getSymbol()==board[2][myCol].getSymbol()) 
         {
            printPrompt(player.getSymbol()+" WON.");
            return true;
         }

      // Check major diagonal
      if (player.getSymbol()==board[0][0].getSymbol() && 
          player.getSymbol()==board[1][1].getSymbol() && 
          player.getSymbol()== board[2][2].getSymbol()) 
         {
            printPrompt(player.getSymbol()+" WON.");
            return true;
         }

      // Check sub diagonal
      if (player.getSymbol()==board[0][2].getSymbol() && 
          player.getSymbol()==board[1][1].getSymbol() && 
          player.getSymbol()==board[2][0].getSymbol())
         {
            printPrompt(player.getSymbol()+" WON.");
            return true;
         }
         
      return false;
   }
   //--------------------------------------------------------------------------
   
   
   //--------------------------------------------------------------------------
   public static boolean isDraw(Player [][] board) {
      // checks to see if there are any spots still on the board and if not, 
      // then it is a draw and returns true.  False means that there are 
      // still spots on the board.
      for (int myRow= 0; myRow<board.length; myRow++)
        for (int myCol = 0; myCol<board.length; myCol++) {
           if (board[myRow][myCol].getSymbol()=='\u0000') return false;
        }
      printPrompt("WE HAVE A DRAW.");
      return true; // All cells are now occupied
   }
   //--------------------------------------------------------------------------
   
   public static void main(String args[])
   {
      int 
         gamePlays=0;
      
      Player defPlayer=new Player();
      defPlayer.setSymbol('\u0000');
      
      Player gamePlayer01=new Player();
      Player gamePlayer02=new Player();
      
      gamePlayer01.setSymbol(askUserForSymbol());
      gamePlayer02.setSymbol(askUserForSymbol());
      
      
      while (gamePlays<=MAX_GAMES) {
         gamePlays+=1;
         printPrompt(SEPARATOR+gamePlays+SEPARATOR);
         
         resetBoard(myBoard, defPlayer);
         while (gamePlayer01.getWins()<=MAX_WINS ||
               gamePlayer02.getWins()<=MAX_WINS) {
           if (isDraw(myBoard)||
               isWon(myBoard, gamePlayer01)||
               isWon(myBoard, gamePlayer02)) 
           { 
              resetBoard(myBoard, defPlayer);
              gamePlayer01.setWins(gamePlayer01.getWins()+1);
              break;
           }
           else {
              makeAMove(myBoard, gamePlayer01);
              displayBoard(myBoard);
           }
           if (isDraw(myBoard)||
               isWon(myBoard, gamePlayer01)||
               isWon(myBoard, gamePlayer02)) 
           { 
              resetBoard(myBoard, defPlayer);
              gamePlayer02.setWins(gamePlayer02.getWins()+1);
              break;
           }
             else {
                makeAMove(myBoard, gamePlayer02);
                displayBoard(myBoard);
             }
        }
      }
   }
}



class Player 
{
   private
      char
         symbol='\u0000';
   
   private
      int 
         wins=0;

   public char getSymbol()
   {
      return symbol;
   }

   public void setSymbol(char symbol)
   {
      this.symbol = symbol;
   }

   public int getWins()
   {
      return wins;
   }

   public void setWins(int wins)
   {
      this.wins = wins;
   } 
   
}
