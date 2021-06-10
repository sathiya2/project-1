
import java.util.Scanner;
public class Tictoc {
  char tictoc[][]=new char[3][3];
 //Display Fuction
 public static void display(char tictoc[][]) {
  for(int i=0;i<3;i++)
  {
   for(int j=0;j<3;j++)
   {
    System.out.print(tictoc[i][j]+" ");
   }
   System.out.println();
  }
 }
 //Replace Function
 static void replace(char arr[][], char find, char replace) {
    for (int i = 0; i < 3 ; i++)
 {
  for(int j=0 ; j < 3 ; j++)
  {
   if (arr[i][j] == find)
   {
    arr[i][j] = replace;
    return;
   }
        }
    }
}

 //check for win function
 public boolean checkForWin() {
  return (checkForRow() || checkForColomn() || checkForDiagnol());
 }
 
  //This function check row, colomn, diagnol for checkForRow, checForDiagnol, checkForColomn function
 public boolean check(char c1,char c2, char c3)
 {
  return((c1==c2) && (c2==c3));
 }
 //check for row function
 public boolean checkForRow() {
  for(int i=0; i<3; i++)
  {
   if(check(tictoc[i][0],tictoc[i][1],tictoc[i][2])==true)
    return true;
  }
  return false;
 }
 //check for colomn function
 public boolean checkForColomn() {
  for(int i=0; i<3; i++)
  {
   if(check(tictoc[0][i],tictoc[1][i],tictoc[2][0])==true)
    return true;
  }
  return false;
 }
 //check for Diagnol function
 public boolean checkForDiagnol()
 {
  return((check(tictoc[0][0],tictoc[1][1],tictoc[2][2])==true) || (check(tictoc[0][2],tictoc[1][1],tictoc[2][0])==true));
 }
 
 //main Function
 public static void main(String[] args) {
  Tictoc game=new Tictoc();
  Scanner in=new Scanner(System.in);
  //Select Player
  String user1,user2;
  char user1mark,user2mark;
  System.out.print("Enter Player one Name: ");
  user1=in.nextLine();
  System.out.print("Enter Player two Name: ");
  user2=in.nextLine();
  //Mark Selection
  System.out.println(user1+" Select Your Marker (O or X): ");
  //System.out.println(name2+" Select Your Marker (O or X): ");
  user1mark=in.next().charAt(0);
  while(user1mark != 'X' && user1mark != 'x' && user1mark != 'O' && user1mark != 'o')
  {
   System.out.print("Invalid Input (Select O or X): ");
   user1mark=in.next().charAt(0);
  }
  if(user1mark=='X' || user1mark=='x')
   user2mark='O';
  else
   user2mark='X';
  //initialize board
  int counter=0;
  for(int i=0 ; i<3; i++)
  {
   for(int j=0 ; j<3 ; j++)
   {
    game.tictoc[i][j]=Character.forDigit(++counter,10);
   }
  }
  //Display Board
  display(game.tictoc);
 
  //Play

  char input;
  for(int i=0;i<4;i++)
  {
   System.out.print(user1+" Turn: ");
   input=in.next().charAt(0);
   replace(game.tictoc,input,user1mark);
   display(game.tictoc);
   System.out.print(user2+" Turn: ");
   input=in.next().charAt(0);
   replace(game.tictoc,input,user2mark);
   display(game.tictoc);
  }
   System.out.print("User "+user1+": ");
   input=in.next().charAt(0);
   replace(game.tictoc,input,user1mark);
   display(game.tictoc);
   //Check For Win or Tie

   if(game.checkForWin())
    System.out.print("We have a Winner");
   else
    System.out.print("Match is Draw");
 }
}