import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.*;


/**
 * La classe <code>Numpad2<code> permet d'utiliser les touches du clavier
 *
 *@version 2.0
 *@author Yoan Rock 
 **/




public class Numpad2 implements KeyListener {
    /**
boutton appuyé

     **/
    private JButton button;
/**
tableau du sudoku

     **/
    private static int[][][] tab1;
/**
indice colonne

     **/
    private int ix;
/**
indice ligne

     **/
    private int iy;
/**
indice du tableau

     **/
    private int iz;
    /**
tableau indiquant si la case pré-rempli

     **/
    private boolean[][] caseini;
/**
compteur pour savoir si c'est gagné

     **/
    private int compteur;
    public Numpad2(JButton b, int[][][] t1,int indicex,int indicey,int indicevalue, boolean[][] in,int compt) {
	this.tab1=t1;
	this.button=b;
	this.ix=indicex;
	this.iy=indicey;
	this.iz=indicevalue;
	this.caseini=in;
	this.compteur=compt;

	Font f=new Font("Arial", Font.BOLD, 20); 
	button.setFont(f); 
    }

/**
gerer les clics sur touches du clavier

     **/
    public void keyPressed(KeyEvent e) {
	int j,k,i;
	boolean bool=true;
	if(e.getKeyChar() == '1'){
	    if(tab1[iy][ix][iz]==0) {
		this.compteur++;
    }
	    if(this.caseini[iy][ix]==false){
	    tab1[iy][ix][iz]=1; 
	    bool=Sudoku.verifContrainteManuelMod(tab1,ix,iy,1);
	    if(bool==true) {
		tab1[iy][ix][iz]=0;
	    }
	    else{
this.button.setText("1");
	    }
	    }
	}
	if(e.getKeyChar() == '2'){
 if(tab1[iy][ix][iz]==0) {
     this.compteur++;
    }
  if(this.caseini[iy][ix]==false){
tab1[iy][ix][iz]=2; 
	    bool=Sudoku.verifContrainteManuelMod(tab1,ix,iy,2);
	    if(bool==true) {
		tab1[iy][ix][iz]=0;
	    }
	    else{
this.button.setText("2");
	    }
  }
	}
	if(e.getKeyChar() == '3'){
 if(tab1[iy][ix][iz]==0) {
     this.compteur++;
    }
  if(this.caseini[iy][ix]==false){
tab1[iy][ix][iz]=3; 
	    bool=Sudoku.verifContrainteManuelMod(tab1,ix,iy,3);
	    if(bool==true) {
		tab1[iy][ix][iz]=0;
	    }
	    else{
this.button.setText("3");
	    }
  }
	}
	if(e.getKeyChar() == '4'){
 if(tab1[iy][ix][iz]==0) {
     this.compteur++;
    }
if(this.caseini[iy][ix]==false){
tab1[iy][ix][iz]=4; 
	    bool=Sudoku.verifContrainteManuelMod(tab1,ix,iy,4);
	    if(bool==true) {
		tab1[iy][ix][iz]=0;
	    }
	    else{
this.button.setText("4");
	    }
}
	}
	if(e.getKeyChar() == '5'){
 if(tab1[iy][ix][iz]==0) {
     this.compteur++;
    }
if(this.caseini[iy][ix]==false){
tab1[iy][ix][iz]=5; 
	    bool=Sudoku.verifContrainteManuelMod(tab1,ix,iy,5);
	    if(bool==true) {
		tab1[iy][ix][iz]=0;
	    }
	    else{
this.button.setText("5");
	    }
}
	}
	if(e.getKeyChar() == '6'){
 if(tab1[iy][ix][iz]==0) {
     this.compteur++;
    }
if(this.caseini[iy][ix]==false){
tab1[iy][ix][iz]=6; 
	    bool=Sudoku.verifContrainteManuelMod(tab1,ix,iy,6);
	    if(bool==true) {
		tab1[iy][ix][iz]=0;
	    }
	    else{
this.button.setText("6");
	    }
}
	}
	if(e.getKeyChar() == '7'){
 if(tab1[iy][ix][iz]==0) {
     this.compteur++;
    }
if(this.caseini[iy][ix]==false){
tab1[iy][ix][iz]=7; 
	    bool=Sudoku.verifContrainteManuelMod(tab1,ix,iy,7);
	    if(bool==true) {
		tab1[iy][ix][iz]=0;
	    }
	    else{
this.button.setText("7");
	    }
}
	}
	if(e.getKeyChar() == '8'){
 if(tab1[iy][ix][iz]==0) {
     this.compteur++;
    }
if(this.caseini[iy][ix]==false){
tab1[iy][ix][iz]=8; 
	    bool=Sudoku.verifContrainteManuelMod(tab1,ix,iy,8);
	    if(bool==true) {
		tab1[iy][ix][iz]=0;
	    }
	    else{
this.button.setText("8");
	    }
}
	}
	if(e.getKeyChar() == '9'){
 if(tab1[iy][ix][iz]==0) {
     this.compteur++;
    }
if(this.caseini[iy][ix]==false){
tab1[iy][ix][iz]=9; 
	    bool=Sudoku.verifContrainteManuelMod(tab1,ix,iy,9);
	    if(bool==true) {
		tab1[iy][ix][iz]=0;
	    }
	    else{
this.button.setText("9");
	    }
}
	}

if(e.getKeyChar() == KeyEvent.VK_DELETE){
 if(tab1[iy][ix][iz]!=0) {
     this.compteur--;
    }
if(this.caseini[iy][ix]==false){
	    tab1[iy][ix][iz]=0;

	    this.button.setText("");
	    return; 
} 
	}

    }

    public void keyReleased(KeyEvent e) {
    }
    public void keyTyped(KeyEvent e) {
    }
    public int[][][] getTab1() {
	return tab1;
    }
   

}


