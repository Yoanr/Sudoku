import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * La classe <code>Launcher1<code> permet de lancer le sudoku pour editer les grilles 
 *
 *@version 1.8
 *@author Yoan Rock 
 **/

public class Launcher1 {
    public static void main(String[] args){
        
	String[] s = new String[3];
	s[0]="Grille Vide";
	s[1]="Charger une grille";
	s[2]="Les commandes";
	JFrame fenetre = new JFrame();
	fenetre.setSize(900,900);
	fenetre.setLocation(100,100);
	fenetre.setTitle("Sudoku Launcher1");	
	fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	Color couleur = new Color(155,155,155);
	JPanel bas = new JPanel();
	bas.setBackground(couleur);
	Img img = new Img();
	//JPanel haut = new JPanel(img);
	JButton b1 = new JButton(s[0]);
	JButton b2 = new JButton(s[1]);
	JButton b3 = new JButton(s[2]);
	JTextField status = new JTextField("Pas de fichier chargé!"); //nouveau champs de texte
	bas.add(b1);
	bas.add(b2);
	bas.add(b3);
	fenetre.add(bas,BorderLayout.SOUTH);
	fenetre.add(img,BorderLayout.CENTER);
        
	Clic observateur = new Clic(fenetre,status,s,bas);
	b1.addActionListener(observateur);
	b2.addActionListener(observateur);
	b3.addActionListener(observateur);
	
	fenetre.setVisible(true);


    }
}
