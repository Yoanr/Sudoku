/**
 * La classe <code>Boutton<code> permet de faire connaitre la case appuyé 
 *
 *@version 1.1
 *@author Yoan Rock
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


public class Boutton  implements MouseListener {
    /** 
correspond au bouton 
    **/
    private JButton button;
    /**
correspond a la grille de donnée du sudoku 
    **/
    private static int[][] tabsudoku;
    /** 
constructeur permet de recuperer le boutton et le tableau de donnée 
     **/
    
    public Boutton(JButton b, int[][] t1){
	this.button=b;
	this.tabsudoku=t1;
	
    }
    /**
Renvoie rien
permet d'utiliser le clic de la souris
@return rien;
     **/
    public void mouseClicked(MouseEvent e) {
	int indicex=e.getXOnScreen()/100;
	int indicey=e.getYOnScreen()/100;

	Numpad clav = new Numpad(this.button,this.tabsudoku,indicex,indicey);
	tabsudoku=clav.getTab1();
	
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
