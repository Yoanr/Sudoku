
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.*;

/**
 * La classe <code>Numpad<code> permet de gerer les touches du clavier
 *
 *@version 2.0
 *@author Yoan Rock 
 **/

public class Numpad  implements KeyListener {
    /**
boutton appuyer
     **/
    private JButton button;
    /**
tableau du sudoku
     **/
    private static int[][] tabsudoku;
    /**
indice colonne
     **/
    private int ix;
    /**
indice ligne
     **/
    private int iy;
    /** 
constructeur permettent de transmettre les indices et les autres données

    **/
    public Numpad(JButton b, int[][] t1,int indicex,int indicey) {
	this.tabsudoku=t1;
	this.button=b;
	this.ix=indicex;
	this.iy=indicey;

	Font f=new Font("Arial", Font.BOLD, 40); 
	button.setFont(f); 


    }
    /** 
permet de gerer les touches du clavier
    **/
    public void keyPressed(KeyEvent e) {
	int j,k,i;

	boolean bool=true;

	if(e.getKeyChar() == '1'){

	   
	    tabsudoku[iy][ix]=1;
	    	    
	    bool=Sudoku.verifContrainte(tabsudoku,ix,iy,1); 
	    if(bool==true) {
		tabsudoku[iy][ix]=0;
	  }else{
	
	this.button.setText("1");
	    }
	}
	if(e.getKeyChar() == '2'){
 
	    
	    tabsudoku[iy][ix]=2;
	   
	    bool=Sudoku.verifContrainte(tabsudoku,ix,iy,2); 
	    if(bool==true) {
		tabsudoku[iy][ix]=0;
	    }
	    else{
	
		this.button.setText("2");
	    }
	}
	if(e.getKeyChar() == '3'){
	    
	    tabsudoku[iy][ix]=3;
 
	    bool=Sudoku.verifContrainte(tabsudoku,ix,iy,3); 
	    if(bool==true) {
		tabsudoku[iy][ix]=0;
	    }
	    else{
		
		this.button.setText("3");
	    }
	}
	if(e.getKeyChar() == '4'){
	    
	    tabsudoku[iy][ix]=4;
	    bool=Sudoku.verifContrainte(tabsudoku,ix,iy,4); 
	    if(bool==true) {
	        tabsudoku[iy][ix]=0;
	    }
	    else{
	
		this.button.setText("4");
	    }
	}
	if(e.getKeyChar() == '5'){
	    
	    tabsudoku[iy][ix]=5;
	    bool=Sudoku.verifContrainte(tabsudoku,ix,iy,5); 
	    if(bool==true) {
		tabsudoku[iy][ix]=0;
	    }
	    else{
		this.button.setText("5");
	    }
	}
	if(e.getKeyChar() == '6'){
	    
	    tabsudoku[iy][ix]=6;
	    bool=Sudoku.verifContrainte(tabsudoku,ix,iy,6); 
	    if(bool==true) {
		tabsudoku[iy][ix]=0;
	    }
	    else{
		this.button.setText("6");
	    }
	}
	if(e.getKeyChar() == '7'){
	    
	    tabsudoku[iy][ix]=7;
	    bool=Sudoku.verifContrainte(tabsudoku,ix,iy,7); 
	    if(bool==true) {
		tabsudoku[iy][ix]=0;
	    }
	    else{
		
			this.button.setText("7");
	    }
	}

	if(e.getKeyChar() == '8'){
	    
	    tabsudoku[iy][ix]=8;
	    bool=Sudoku.verifContrainte(tabsudoku,ix,iy,8); 
	    if(bool==true) {
		tabsudoku[iy][ix]=0;
	    }
	    else{
		
		this.button.setText("8");
	    }
	}

	if(e.getKeyChar() == '9'){
	    
	    tabsudoku[iy][ix]=9;
	    bool=Sudoku.verifContrainte(tabsudoku,ix,iy,9); 
	    if(bool==true) {
		tabsudoku[iy][ix]=0;
	    }
	    else{
	
			this.button.setText("9");
	    }
	}
	if(e.getKeyChar() == KeyEvent.VK_DELETE){
	    tabsudoku[iy][ix]=0;

	    this.button.setText("");
	    return;  
	}
	if(e.getKeyChar() == KeyEvent.VK_ENTER){
	  
	    for(j=0;j<9;j++) {
		for(i=0;i<9;i++) {
		   
		    System.out.print(tabsudoku[j][i]+" ");
		    System.out.print("|");
		}
		System.out.println();
	
		for(k=0;k<9;k++) {
		    System.out.print("---");
		}
		System.out.println();
	    }
	    System.out.println();
	    System.out.println();
	    System.out.println();
	}

    }
    public void keyReleased(KeyEvent e) {
    }
    public void keyTyped(KeyEvent e) {
    }
    /** 
getter permettent de recuperer le tableau du sudoku 
     **/
    public int[][] getTab1() {
	return tabsudoku;
    }
  
    

}
