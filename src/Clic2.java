import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
 * La classe <code>Clic2<code> permet d'utiliser les boutons du Launcher1 
 *
 *@version 1.2
 *@author Adrien Colombier
 **/

public class Clic2 implements ActionListener {
 /** 
fenetre du Launcher
    **/
    private JFrame fen;
 /**
correspond a une futur idée d'ajout d'un jtextfiled contenant le fichier a charger
    **/
    private JTextField status;
/**
       Tableau contenant nom des bouttons 
    **/
    private String[] tab;
    public Clic2 (JFrame f,JTextField s,String[] tab1){
	this.fen=f;
	this.status=s;
	this.tab=tab1;

    }
    @Override
/**
permet une action sur un clic 
    **/
    
    public void actionPerformed(ActionEvent evenement) {
/**
correspond au faite de cliquer sur le bouton chargr une vide
	**/

	if (evenement.getActionCommand().equals(this.tab[0])) {
	    int[] canonique = new int[9];
	    int[][] grille = new int[9][9];
	    int[][] contrainte = new int[9][9];

	    JFileChooser chooser = new JFileChooser();//création dun nouveau filechosser
	    chooser.setApproveButtonText("Choix du fichier..."); //intitulé du bouton
	    chooser.showOpenDialog(null); //affiche la boite de dialogue
	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{	
		    this.status.setText(chooser.getSelectedFile().getAbsolutePath()); //si un fichier est selectionné, récupérer le fichier puis sont path et l'afficher dans le champs de texte
					    
		}
	    String s=chooser.getSelectedFile()+"";


	    this.fen.dispose();
	    JFrame f = new JFrame();
	    f.setSize(600,100);
	    f.setResizable(false);
	    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    GridLayout grill = new GridLayout(1,3);
	    f.setLayout(grill);
	    String[] tabstring = new String[2];
	    tabstring[0]="MANUEL";
	    tabstring[1]="AUTOMATIQUE";
	    JButton b1 = new JButton(tabstring[0]);
	    JLabel bou = new JLabel("OU");
	    JButton b2 = new JButton(tabstring[1]);
	    f.add(b1);
	    f.add(bou);
	    f.add(b2);
	    canonique=Sudokufile.readSudoku(s);
	    grille=Sudoku.canoniqueToGrille(canonique);
	    Clicmini observateur = new Clicmini(f,tabstring,grille);
	    b1.addActionListener(observateur);
	    b2.addActionListener(observateur);
	    f.setVisible(true);

	}
/**
correspond au faite de cliquer sur les commandes
	**/

	if (evenement.getActionCommand().equals(this.tab[1])) {

ImageIcon img = new ImageIcon("../img/com.png");

JOptionPane.showMessageDialog(this.fen,"Pour entrer une valeur :\nCliquez sur la case et choississez votre numero a l'aide du numpad ( de 1 à 9 ).\nPour supprimer une valeur existante :\ncliquer sur la case puis sur la touche  'suppr' ","Les commandes",JOptionPane.INFORMATION_MESSAGE,img);


}
	

    }
}

