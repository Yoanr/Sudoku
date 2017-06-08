import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
/**
 * La classe <code>Clicfen2<code> permet d'utiliser les boutons de sauvegarde
 *
 *@version 1.0
 *@author Yoan Rock 
 **/

public class Clicfen2 implements ActionListener {
 /** 
fenetre du Launcher
    **/
    private JFrame fen;

    private int[][] tablo1;
    private int[][] tablo2;
    /**
correspond au nom des boutons
     **/
    private String[] str1;
/**
correspond au nom des fichier
     **/
    private String[] str2;
    /**
recupere les variable demmandée pour sauvegarder convenablement 
    **/
    public Clicfen2 (JFrame f,int[][] tab1,int[][] tab2,String[] s1,String[] s2){
	this.fen=f;
        this.tablo1=tab1;
	this.tablo2=tab2;
	this.str1=s1;
	this.str2=s2;

    }
    @Override
      /**
permet une action sur un clic 
    **/   
    
    public void actionPerformed(ActionEvent evenement) {
	/**
correspond au faite de cliquer sur save
	**/
	if (evenement.getActionCommand().equals(this.str1[0])) {
int i,j,k;
		int[] canonique = new int[9];
	    canonique=Sudoku.grilleToCanonique(this.tablo1);
	    boolean bool=Sudokufile.writeSudoku(canonique,this.str2[0]);
	    if(bool==false) {
	        
	        
	        ImageIcon img = new ImageIcon("../img/save.png");
	        
		String s="Sauvegarde dans : "+this.str2[0]+" reussie avec succes";

		JOptionPane.showMessageDialog(this.fen,s,"Sauvegarder",JOptionPane.INFORMATION_MESSAGE,img);
this.fen.dispose();
	    
	    }
	}
	    if (evenement.getActionCommand().equals(this.str1[1])) {
	/**
correspond au faite de cliquer sur save as
	**/
		//this.str2
		int i,j,k;
		int[] canonique = new int[9];
	        
		canonique=Sudoku.grilleToCanonique(this.tablo1);
		boolean bool=Sudokufile.writeSudoku(canonique,this.str2[1]);
		if(bool==false) {
		     ImageIcon img = new ImageIcon("../img/save.jpg");
	        
		String s="Sauvegarde dans : "+this.str2[1]+" reussie avec succes";

		JOptionPane.showMessageDialog(this.fen,s,"Sauvegarder",JOptionPane.INFORMATION_MESSAGE,img);
this.fen.dispose();
		}
	    }
	}
    }
