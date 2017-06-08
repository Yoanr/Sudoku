import javax.swing.*;
import java.awt.*;
/**
 * La classe <code>Img<code> permet d'integrer une image
 *
 *@version 1.0
 *@author Adrien Colombier
 **/
public class Img extends JComponent {
    /**
image
     **/
    private Image sudoke;
    public Img() {
	super();
	sudoke = Toolkit.getDefaultToolkit().getImage("../img/sudoke.jpg");
    }
    @Override
    /**
dessine l'image
     **/
    public void paintComponent(Graphics pinceau) {
	Graphics secondPinceau = pinceau.create();

	
secondPinceau.drawImage(this.sudoke,0 ,0,this.getWidth(),this.getHeight(), this);
    }
}
