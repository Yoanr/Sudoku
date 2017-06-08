import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * La classe <code>Launcher2<code> permet de lancer le sudoku de resolution
 *
 *@version 1.5
 *@author Adrien Colombier
 **/


public class Launcher2 {
    public static void main(String[] args){
        
	String[] s = new String[2];
	s[0]="Charger une grille";
	s[1]="Les commandes";
	JFrame fenetre = new JFrame();
	fenetre.setSize(900,900);
	fenetre.setLocation(100,100);
	fenetre.setTitle("Sudoku Launcher2");	
	fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	Color couleur = new Color(155,155,155);
	JPanel bas = new JPanel();
	bas.setBackground(couleur);
	Img img = new Img();
	
	JButton b1 = new JButton(s[0]);
	JButton b2 = new JButton(s[1]);

		JTextField status = new JTextField("Pas de fichier chargé!"); //nouveau champs de texte
	bas.add(b1);
	bas.add(b2);
        
	fenetre.add(bas,BorderLayout.SOUTH);
	fenetre.add(img,BorderLayout.CENTER);
	
        
	Clic2 observateur = new Clic2(fenetre,status,s);
	b1.addActionListener(observateur);
	b2.addActionListener(observateur);
	
	
	fenetre.setVisible(true);


    }
}
