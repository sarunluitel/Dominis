package Dominos;

/************************************
 @author Sarun Luitel

 Main method that runs the program
 ************************************/
public class Main
{
  public static void main(String[] args)
  {
    DisplayController startDisplay=new DisplayController();
    startDisplay.renderDisplay(args);
  }
}