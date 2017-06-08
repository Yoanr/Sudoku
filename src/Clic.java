import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

/**
 * La classe <code>Clic<code> permet d'utiliser les boutons du Launcher1 
 *
 *@version 1.1
 *@author Adrien Colombier
 **/

public class Clic implements ActionListener {
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
     
    private JPanel pano;
    public Clic (JFrame f,JTextField s,String[] tab1, JPanel pan){
	this.fen=f;
	this.status=s;
	this.tab=tab1;
	this.pano=pan;
    }
    @Override
    /**
permet une action sur un clic 
    **/
    
    public void actionPerformed(ActionEvent evenement) {
	/**
correspond au faite de cliquer sur le bouton grille vide
	**/

	if (evenement.getActionCommand().equals(this.tab[0])) {
	    int i,j,k;
	    int[][] tab = new int[9][9];
	    for(j=0;j<9;j++) {
		for(i=0;i<9;i++) {
		   
		    System.out.print(tab[j][i]+" ");
		    System.out.print("|");
		}
		System.out.println();
	
		for(k=0;k<9;k++) {
		    System.out.print("---");
		}
		System.out.println();
	    }

	    int[][] contrainte = new int[9][9];
	    int nbrfile=0;
	    Sudoku sudo = new Sudoku(tab);
	    Sudokufile file = new Sudokufile(nbrfile);
	    nbrfile= file.changeValue();
	    this.fen.dispose();
	    JFrame f = new JFrame();
	    f.setSize(900,900);
	    f.setResizable(false);
	    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
	    JPanel conteneurgrille = new JPanel();
	    JPanel zonebas = new JPanel();
	
	    GridLayout grille = new GridLayout(9,9);
	    for(j = 0; j<9;j++){
		for(i = 0; i<9;i++){
		    // String s =""+j+""+i+"";
		    JButton texte = new JButton();
		    Boutton observateur = new Boutton(texte,tab);
		    texte.addMouseListener(observateur);
		    conteneurgrille.add(texte);
		    texte.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		}
	    }
      
	    conteneurgrille.setLayout(grille);
	    f.add(conteneurgrille, BorderLayout.CENTER);
	    f.add(zonebas, BorderLayout.SOUTH);
	   
	    String[] buttonname = new String[2];
	    buttonname[0]="save";
	    buttonname[1]="Save as Sudoku"+nbrfile+".grille & quitter";
	    String[] filename = new String[2];

	    filename[0]="";
	    filename[1]="Sudoku"+nbrfile+".grille";


	    JButton bname = new JButton(buttonname[1]);
	   
	
	    zonebas.add(bname);
	    Clicfen2 clic2 = new Clicfen2(f,tab,contrainte,buttonname,filename);
	    
	    bname.addActionListener(clic2);
	
	    f.setVisible(true);

	    
	}
	/**
correspond au faite de cliquer sur charger une grille
	**/
	if (evenement.getActionCommand().equals(this.tab[1])) {
	    int[] canonique = new int[9];
	    int[][] grille = new int[9][9];
	    int[][] contrainte = new int[9][9];
	    int nbrfile=0;
String s1;
	    Sudoku sudo = new Sudoku(grille);
	    Sudokufile file = new Sudokufile(nbrfile);
	    nbrfile= file.changeValue();
	    int i,j,k;
	    JFileChooser chooser = new JFileChooser();//création dun nouveau filechosser
	    chooser.setApproveButtonText("Choix du fichier..."); //intitulé du bouton
	    chooser.showOpenDialog(null); //affiche la boite de dialogue
	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{	
		    this.status.setText(chooser.getSelectedFile().getAbsolutePath()); //si un fichier est selectionné, récupérer le fichier puis sont path et l'afficher dans le champs de texte
		}
	    String s=chooser.getSelectedFile()+"";
	    canonique=Sudokufile.readSudoku(s);
	    grille=Sudoku.canoniqueToGrille(canonique);

	    this.fen.dispose();
	    JFrame f = new JFrame();
	    f.setSize(900,900);
	    f.setResizable(false);
	    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	    JPanel conteneurgrille = new JPanel();
	    JPanel zonebas = new JPanel();
	
	    GridLayout grill = new GridLayout(9,9);
Font fa=new Font("Arial", Font.BOLD, 40); 
	
	    for(j = 0; j<9;j++){
		for(i = 0; i<9;i++){
		    if(grille[j][i]==0) {
			s1="";
		    }else{
			s1=grille[j][i]+"";
		    }
		    JButton texte = new JButton(s1);
texte.setFont(fa); 
		    Boutton observateur = new Boutton(texte,grille);
		    texte.addMouseListener(observateur);
		    conteneurgrille.add(texte);
		    texte.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		}
	    }
	    
	    conteneurgrille.setLayout(grill);
	    f.add(conteneurgrille, BorderLayout.CENTER);
	    f.add(zonebas, BorderLayout.SOUTH);
	    
	    String[] buttonname = new String[2];
	    buttonname[0]="save";
	    buttonname[1]="Save as Sudoku"+nbrfile+".grille & quitter";
	    String[] filename = new String[2];
	    filename[0]=s;
	    filename[1]="Sudoku"+nbrfile+".grille";
	    JButton save = new JButton(buttonname[0]);
	    JButton bname = new JButton(buttonname[1]);
	    zonebas.add(save);
	
	    zonebas.add(bname);
	    Clicfen2 clic2 = new Clicfen2(f,grille,contrainte,buttonname,filename);
	    //Clicfen2 clic3 = new Clicfen2(f,grille,contrainte,buttonname,
	    save.addActionListener(clic2);
	    bname.addActionListener(clic2);
	
	    f.setVisible(true);

	}
	/** 
correpond au faite de cliquer sur les commandes 
	 **/
if (evenement.getActionCommand().equals(this.tab[2])) {
ImageIcon img = new ImageIcon("../img/com.png");

JOptionPane.showMessageDialog(this.fen,"Pour entrer une valeur :\nCliquez sur la case et choississez votre numero a l'aide du numpad ( de 1 à 9 ).\nPour supprimer une valeur existante :\ncliquer sur la case puis sur la touche  'suppr' ","Les commandes",JOptionPane.INFORMATION_MESSAGE,img);


}
    }
}


