/**
 * La classe <code>Boutton2<code> permet de faire connaitre la case appuyé 
 *
 *@version 1.1
 *@author Yoan Rock
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.MouseEvent;

public class Boutton2  implements MouseListener {
 /** 
correspond au bouton 
    **/
    private JButton button;
/**
correspond a la grille de donnée du sudoku 
    **/
    private static int[][][] tab1;
/**
correspond a la grille de donnée du sudokuau contrainte pour les cases 
pré- remplie 
    **/
    private static boolean[][] ini;
    /** 
correspond au compteur permettent de connaitre la fin du jeux 
    **/
    private static int compteur;

    public Boutton2(JButton b, int[][][] t1, boolean[][] in,int compt){
/** 
constructeur permet de recuperer le boutton et le tableau de donnée, le tableau de boolean et le compteur 
     **/

	this.button=b;
	this.tab1=t1;
	this.ini=in;
	this.compteur=compt;

    }
/**
Renvoie rien
permet d'utiliser le clic de la souris 
@return rien;
     **/
    public void mouseClicked(MouseEvent e) {
	int newindicex,newindicey,indicevalue=0;
	int indicex=e.getXOnScreen()/100;
	int indicey=e.getYOnScreen()/100;
	System.out.println(e.getX());
	System.out.println(e.getY());
	if(indicex>99) {

	    String strx =indicex+"";
	    String strx2=strx.charAt(1)+strx.charAt(2)+"";
	    newindicex=Integer.parseInt(strx2);
	}
	else {
	    newindicex=indicex;
	}
	if(indicey>99) {
	    String stry =indicey+"";
	    String stry2=stry.charAt(1)+stry.charAt(2)+"";
	    newindicey=Integer.parseInt(stry2);
	}
	else {
	    newindicey=indicey;
	}
	if(newindicex<=50 && newindicey<=50){
	    indicevalue=0;

	}
	if(newindicex>50 && newindicey<=50){
	    indicevalue=1;
	}
	if(newindicex<=50 && newindicey>50){
	    indicevalue=2;
	}
	if(newindicex>50 && newindicey>50){
	    indicevalue=3;
	}

	Numpad2 clav = new Numpad2(this.button,this.tab1,indicex,indicey,indicevalue,this.ini,this.compteur);
	tab1=clav.getTab1();
	        
	this.button.addKeyListener(clav);
        
	
    }
    public void mouseEntered(MouseEvent event) {
    }
    public void mouseExited(MouseEvent event) {
    }
    public void mousePressed(MouseEvent event) {
    }

    public void mouseReleased(MouseEvent event) {
    }
}
