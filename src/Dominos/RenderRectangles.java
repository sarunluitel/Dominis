package Dominos;
/************************************
 @author Sarun Luitel

 renders labels  and change properties to
 simulate domino's.

 ************************************/

import javafx.scene.control.Label;

import java.util.HashMap;

public  class RenderRectangles
{
  private static final String[] SIDE =
      {" \n   ", "  . \n ", "  .  \n  .  ",
          " . .  \n  .  ", " . . \n . . ",
          " ...  \n . . ", " ... \n ... ",".  ||||| ."};
  static Label label=null;

  /********************************************************
   @param  side1 takes in one side of the domino to assign
   number of dots.
   @return labels formatted by CSS to similate dominos

   ********************************************************/
  public static Label renderLbl(int side1, int side2)
  {

    //Initial condition when Player hasn't chosen Dominos
    if(side1!=-1||side2!=-1)
    {
      label = new Label(SIDE[side1] + "\n____\n" + SIDE[side2]);
      label.getStyleClass().add("domino-design");
      label.setId(side1 * 10 + side2 + "");
    }

    Label finalLabel = label;
    label.setOnMousePressed(e ->
    {

      Integer clickedDomino = Integer.parseInt(finalLabel.getId());
      if (Player.playerHand.containsKey(clickedDomino))
      {
        GameController.playerEntry = Integer.parseInt(finalLabel.getId());
        GameController.hasPlayerPlayed = true;
        if (e.isPrimaryButtonDown()) Player.side = 0;
        if (e.isSecondaryButtonDown()) Player.side = 1;
        GameController.playPlayerTurn();
      }


    });


    return label;
  }

}
