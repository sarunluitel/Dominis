import javafx.scene.control.Label;

import java.util.HashMap;

public  class RenderRectangles
{
  private static final String[] SIDE = {" \n  \n ", "\n  .   \n ", "  .  \n\n  .  ",
      "  .  \n  .  \n  .  ", " . . \n\n . . ",
      " . . \n  .  \n . . ", " ... \n\n ... ",".\n  |||||  \n."};
  public static HashMap<Integer,Label> GUIDominos= new HashMap<>();
  public static Label label=null;


  public static Label renderLbl(int side1, int side2)
  {


    if(side1!=-1||side2!=-1)
    {
      label = new Label(SIDE[side1] + "\n____\n" + SIDE[side2]);
      label.getStyleClass().add("domino-design");
      label.setId(side1 * 10 + side2 + "");
      GUIDominos.put(side1 * 10 + side2, label);
    }

    Label finalLabel = label;
    label.setOnMousePressed(e -> {


    //  System.out.println(finalLabel.getId());
      GameController.playerEntry=Integer.parseInt(finalLabel.getId());
      GameController.hasPlayerPlayed=true;
      if(e.isPrimaryButtonDown())Player.side=0;
      if(e.isSecondaryButtonDown())Player.side=1;
      GameController.playPlayerTurn();



    });

    return label;
  }

}
