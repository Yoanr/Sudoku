/**
 * La classe <code>Correction<code> permet de corriger le sudoku
 *
 *@version 1.1
 *@author Yoan Rock 
 **/

import javax.swing.*;
import java.awt.event.*;
public class Correction implements ActionListener {
    private int compteur;
    private JFrame fen;
    public Correction (int compt,JFrame f){
	this.compteur=compt;
	this.fen=f;
    }
 @Override
 /** 
bouton corriger
  **/
        
    
    public void actionPerformed(ActionEvent evenement) {
    if (evenement.getActionCommand().equals("corriger")) {
	System.out.print("COMPTEUR== "+compteur);
	if(this.compteur==81) {

	    JOptionPane.showMessageDialog(this.fen,"Félicitation Vous avez gagnez");
	}
	else {
	    if(this.compteur>81) {
		JOptionPane.showMessageDialog(this.fen,"Trop de valeur");
	    }
	    else{
		JOptionPane.showMessageDialog(this.fen,"Pas assez de valeur");
	    }
	}
    }
 }
}
