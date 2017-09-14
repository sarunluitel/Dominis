import javafx.scene.control.Label;

public class RenderRectangles
{
  private  static final String[] SIDE={" \n  \n ", "\n  .   \n ","  .  \n\n  .  ",
      "  .  \n  .  \n  .  "," . . \n\n . . ",
      " . . \n  .  \n . . "," ... \n\n ... "};

  public static Label renderLbl(int side1, int side2){
    Label label;
    label= new Label(SIDE[side1]+"\n____\n"+SIDE[side2]);
    label.getStyleClass().add("domino-design");
    return label;
  }

}
