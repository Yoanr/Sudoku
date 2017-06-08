import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
/**
 * La classe <code>Clicmini<code> 
 *
 *@version 1.3
 *@author Yoan Rock 
 **/

public class Clicmini implements ActionListener {
    /**
fenetre du Launcher2
     **/
    private JFrame fen;
    private JTextField status;
    private String[] tab;
    /**
tabeau du sudoku
     **/
    private int [][] grille;
    public Clicmini (JFrame f,String[] tab1, int[][] gr){
	this.fen=f;
	this.tab=tab1;
	this.grille=gr;

    }
    @Override
    public void actionPerformed(ActionEvent evenement) {
	/**
mode manuel
	 **/

	if (evenement.getActionCommand().equals("MANUEL")) {
	    int compteur=0;
	    int i,j,k,l;
	    String s2;
	    int[][][] tab = new int[9][9][4];
	    boolean[][] caseini = new boolean[9][9];
	    for(j=0;j<9;j++) {
		for(i = 0; i<9;i++){
		    if(grille[j][i]!=0) {
			caseini[j][i]=true;
			compteur++;

		    }
		    else{
			caseini[j][i]=false;
		    }
		    tab[j][i][0]=grille[j][i];
		}
	    }
	   
	    this.fen.dispose();
	    JFrame f = new JFrame();
	    f.setSize(900,900);
	    f.setResizable(false);
	    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	    JPanel conteneurgrille = new JPanel();
	    f.add(conteneurgrille, BorderLayout.CENTER);

	    JPanel zonebas = new JPanel();
	    f.add(zonebas, BorderLayout.SOUTH);
	    
	    GridLayout grill = new GridLayout(9,9);
	    conteneurgrille.setLayout(grill);
	    Font fa=new Font("Arial", Font.BOLD, 20); 
	    String s1;
	    for(j = 0; j<9;j++){
		for(i = 0; i<9;i++){
		    if(tab[j][i][0]==0) {
			s1="";
		    }else{
			s1=tab[j][i][0]+"";
		    }
		    JPanel cases = new JPanel();
		    cases.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		    //Departager observateurs = new Departager(cases);
		    //cases.addMouseListener(observateurs);
		    conteneurgrille.add(cases);
		    GridLayout grille22 = new GridLayout(2,2);
		    cases.setLayout(grille22);
		    
	
		    for(l=0;l<4;l++) {
			if(l==0){
			    if(tab[j][i][0]==0) {
				s2="";
			    }else{
				s2=tab[j][i][0]+"";
			    }


			}else{
			    s2="";
			}
			JButton texte = new JButton(s2);
			cases.add(texte);
			texte.setFont(fa); 
			Boutton2 observateur = new Boutton2(texte,tab,caseini,compteur);
			texte.addMouseListener(observateur);
		    }
		    
		    
		    
		    
		}
	    }
	    
	    conteneurgrille.setLayout(grill);
	    
	   
	    JButton corriger = new JButton("corriger");
	 	   
	    
	    zonebas.add(corriger);
	    Correction observateur2 = new Correction(compteur,this.fen);
	    corriger.addActionListener(observateur2);
	
	   
	    //Clicfen2 clic2 = new Clicfen2(f,grille,contrainte,buttonname,filename);
	    //corriger.addActionListener(clic2);
	    
	
	    f.setVisible(true);

	}


	/**
mode automatique
	 **/
	if (evenement.getActionCommand().equals("AUTOMATIQUE")) {
	    long  time1,time2;
	    double time;
	   
	    int i,j,k;
	    int[][] resultat = new int[9][9];
	    time1=System.nanoTime();
	    resultat=Sudoku.iaSudoku(this.grille);
	    time2=System.nanoTime();
	    time=time2-time1/100000000;
	    int a=(int) (time + 0.5f);
	    String timee=a+" s ";

	    resultat=grille;
	    this.fen.dispose();
	    JFrame f = new JFrame();
	    f.setSize(900,900);
	    f.setResizable(false);
	    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
	    JPanel conteneurgrille = new JPanel();
	    JPanel zonebas = new JPanel();
	    Font fa=new Font("Arial", Font.BOLD, 40); 
	
	    GridLayout grille = new GridLayout(9,9);
	    for(j = 0; j<9;j++){
		for(i = 0; i<9;i++){
		    String s =resultat[j][i]+"";

		    JButton texte = new JButton(s);
		    texte.setFont(fa); 
		    
		    conteneurgrille.add(texte);
		    texte.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		}
	    }
      
	    conteneurgrille.setLayout(grille);
	    f.add(conteneurgrille, BorderLayout.CENTER);
	    f.add(zonebas, BorderLayout.SOUTH);
	    JLabel timer= new JLabel(timee);
	    zonebas.add(timer);
	    
	    
	    
	  
	    f.setVisible(true);

	    
	}
	


    }
}

