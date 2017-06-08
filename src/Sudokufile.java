import javax.swing.JFileChooser;
import java.io.*;
/**
 * La classe <code>Sudokufile<code> permet de gerer les flux
 *
 *@version 1.5
 *@author Yoan Rock 
 **/
public class Sudokufile {
    /**
     *valeur du fichier 
     **/
    private int val;
    /**
constructeur 
    **/
    public Sudokufile(int value) {
	this.val=value;
    }
    /**
     * renvoi un int permettent de changer le numero du fichier a save
     *@return int permettent de changer le numero du fichier a save
     **/
    public int changeValue() {
	//this.val=0;
	try{
	    FileInputStream fichier = new FileInputStream("count.txt");
	    DataInputStream flux = new DataInputStream(fichier);

	    try{
		this.val=flux.readInt();
		flux.close();
	    }catch(IOException e) {
		System.out.println("Impossible de récuperer l'entier");
	    }
	}catch(FileNotFoundException e){
	    System.out.println("Fichier n'existe pas");
	}
	this.val=this.val+1;
	System.out.println(this.val);
	try{
	    FileOutputStream fichier = new FileOutputStream("count.txt");
	    DataOutputStream flux = new DataOutputStream(fichier);
	    try {
		flux.writeInt(this.val);
		flux.close();
	    } catch(IOException e){
		System.out.println("Impossible de rentrer la valeur");
	    }
	}catch(FileNotFoundException e){
	    System.out.println("Fichier n'existe pas");
	}
	return this.val;
    }
    /** permet d'ecrire dans un fichier 
     *@return boolean verifier si aucune erreur n'est survenu
     *renvoi un boolean pour  erifier si aucune erreur n'est survenu
     **/
    public static boolean writeSudoku(int[] nbr,String name) {

    try{
	    FileOutputStream fichier = new FileOutputStream(name);
	    DataOutputStream flux = new DataOutputStream(fichier);
	    try {
		for(int i=0;i<9;i++) {
		flux.writeInt(nbr[i]);
		}
		flux.close();
	    } catch(IOException e){
		System.out.println("Impossible de rentrer la valeur");
		return true;
	    }
	}catch(FileNotFoundException e){
	    System.out.println("Fichier n'existe pas");
	    return true;
	}
    return false;
    }
/** permet de lire dans un fichier 
     *@return boolean un tableau de int contenant nombre canonique pour  erifier si aucune erreur n'est survenu
     *renvoi un tableau de int contenant nombre canonique pour  erifier si aucune erreur n'est survenu
     **/
    public static int[] readSudoku(String name) {
	int[] canonique = new int[9];

try{
	    FileInputStream fichier = new FileInputStream(name);
	    DataInputStream flux = new DataInputStream(fichier);
	    try {
		for(int i=0;i<9;i++) {
	canonique[i]=flux.readInt();
		}
		flux.close();
	    } catch(IOException e){
		System.out.println("Impossible de rentrer la valeur");
        
	    }
	}catch(FileNotFoundException e){
	    System.out.println("Fichier n'existe pas");
	   
	}
return canonique;
    }


}




