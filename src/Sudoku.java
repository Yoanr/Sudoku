import java.util.*;

/**
 * La classe <code>Sudoku<code> permet de gerer les calculs et action sur la grille
 *
 *@version 3.2
 *@author Yoan Rock
 **/
public class Sudoku {
/**
tableau du sudoku
     **/

    private int[][] sud;
    /**
constructeur 

     **/


    public Sudoku(int[][] tab) {
	this.sud=tab;
    }


    // methode afficher tableau

    // methode generer un tab int aleatoire

    // 1er = 17 a 33 case rempli 

    /**
renvoie un tableau generer
@return tableau avec case pré-rempli aleatoirement

     **/
    public static  int[][] generer() {
	boolean bool=true;
	int i,j;

	int[][] gene = new int[9][9];

	Random rand = new Random();
	int var=0;
	int caseprerempli = rand.nextInt(17)+17;
	System.out.println(caseprerempli);
        
	while(var<caseprerempli) {
	    int alealigne=rand.nextInt(9);
	    int aleacolonne=rand.nextInt(9);
	    if(gene[alealigne][aleacolonne]==0){
		int a=rand.nextInt(9)+1;
		//	System.out.println("1er a="+a);
		gene[alealigne][aleacolonne]=a;
		bool=verifContrainte(gene,alealigne,aleacolonne,a); /* methode verifie contrainte */ 

		if(bool==true) {
		    gene[alealigne][aleacolonne]=0;
		    // System.out.println("CONTRAINTE");
		}
		else {
		    gene[alealigne][aleacolonne]=a;
		    /*   System.out.print("2eme a="+a);
			 System.out.print(" => ");
			 System.out.print("["+alealigne+"] / ["+aleacolonne+"]");

			 System.out.println();*/
		    
		    var++;
		}
	    }
	}


	return gene;


    }
    /**
     *renvoi un boolean ( true si il y a un probleme de contrainte ) 
     *@return un boolean
     **/
    public static boolean verifContrainte(int[][] tab,int aleac,int aleal,int a) {
        
        int compteur1=0,compteur2=0,compteur3=0,i,j;

        for(i=0;i<9;i++) {
	    if(tab[aleal][i]==a) { //ligne
	        compteur1++;

	    }
	    if(tab[i][aleac]==a){ //colonne
		compteur2++;

	    }
	}
	// ******* // 
	if(aleac<3 && aleal<3) { // all region 1
	    // System.out.println("region1");
	    for(j=0;j<3;j++) {
		for(i=0;i<3;i++) {
		    if(tab[j][i]==a) {
			compteur3++;
		    }
		}
	    }
	}

	if(aleac>2 && aleac<6 && aleal<3) { // all region 2
	    //System.out.println("region2");
	    for(j=0;j<3;j++) {
		for(i=3;i<6;i++) {
		    if(tab[j][i]==a) {
			compteur3++;
		    }
		}
	    }
	}

	if(aleac>5 && aleal<3) { // all region 3
	    // System.out.println("region3");
	    for(j=0;j<3;j++) {
		for(i=6;i<9;i++) {
		    if(tab[j][i]==a) {
			compteur3++;
		    }
		}
	    }
	}
	if(aleac<3 && aleal>2 && aleal<6) { // all region 4
	    // System.out.println("region4");
	    for(j=3;j<6;j++) {
		for(i=0;i<3;i++) {
		    if(tab[j][i]==a) {
			compteur3++;
		    }
		}
	    }
	}
	if(aleac>2 && aleac<6 && aleal>2 && aleal<6) { // all region 5
	    //  System.out.println("region5");
	    for(j=3;j<6;j++) {
		for(i=3;i<6;i++) {
		    if(tab[j][i]==a) {
			compteur3++;
		    }
		}
	    }
	}
	if(aleac>5 && aleal>2 && aleal<6) { // all region 6
	    // System.out.println("region6");
	    for(j=3;j<6;j++) {
		for(i=6;i<9;i++) {
		    if(tab[j][i]==a) {
			compteur3++;
		    }
		}
	    }
	}
	if(aleac<3 && aleal>5) { // all region 7
	    // System.out.println("region7");
	    for(j=6;j<9;j++) {
		for(i=0;i<3;i++) {
		    if(tab[j][i]==a) {
			compteur3++;
		    }
		}
	    }
	}
	if(aleac>2 && aleac<6 && aleal>5) { // all region 8
	    //  System.out.println("region8");
	    for(j=6;j<9;j++) {
		for(i=3;i<6;i++) {
		    if(tab[j][i]==a) {
			compteur3++;
		    }
		}
	    }
	}
	if(aleac>5 && aleal>5) { // all region 9
	    // System.out.println("region9");
	    for(j=6;j<9;j++) {
		for(i=6;i<9;i++) {
		    if(tab[j][i]==a) {
			compteur3++;
		    }
		}
	    }
	}

	if(compteur1>1){
	    System.out.println("PROBLIGNE");
	    return true;
	}
	if(compteur2>1) {
	    System.out.println("PROBCOLONNE");
	    return true;
	}
	if(compteur3>1) {
	    System.out.println("PROBREGION");
	    return true;
	}
	return false;
        
	

    }
    /**
     *@return boolean
     *renvoie un boolean ( false si faux)
     **/
				   

    // methode qui return true or false sudoku es bon ou pas
    public  boolean correctionSudoku() {
	int somme=0,i,j;
	for(j=0;j<9;j++){
	    for(i=0;i<9;i++){
		somme+=this.sud[j][i];
	    }
	    if(somme!=45) {
		return false;
	    }

	}
	return true;


    }
/**
     *renvoi tableau de int  contenant representation canonique
     *@return un tableau de int
parametres : tableau a deux dimension contenant donnée sudoku
     **/
    public static int[] grilleToCanonique(int[][] a){
	int i,j,k,dec;
	int[] canoniquetable = new int[9];
	for(i=0;i<9;i++){
	    j=100000000;
	    dec=0;
	    for(k=0;k<9;k++){
		    
		dec=j*a[i][k]+dec;
		   
		j=j/10;
		
	    }
	    canoniquetable[i]=dec;
	    System.out.println(canoniquetable[i]);
	   
	}
	return canoniquetable;
    }
/**
     *renvoi tableau a deux dimension contenant donnée sudoku
     *@return un tableau a deux dimensions
 
     *parametres : tableau de int  contenant representation canonique
     **/
    public static int[][] canoniqueToGrille(int[] a) {
	int[][] b = new int[9][9];
        int i,j,k;
	
	for(j=0;j<9;j++){
	    String s =a[j]+"";
	    int nbr=9-s.length();
	    k=0;
	    for(i=nbr;i<9;i++){

		char c=	s.charAt(k);
		k++;
		String c1=c+"";
		b[j][i]=Integer.parseInt(c1);
	    }
	}
	return b;

    }
    /**
     *rempli un tableau donnée
     *@return tableau rempli 
     *renvoie tableau rempli
     **/
    public static int[][] iaSudoku(int[][] grillenonrempli) {
	Scanner sc = new Scanner(System.in);

	int[][] grillerempli = new  int[9][9];
	int inttest;
	boolean bool=true;

	// methode a qui on lui donne un tableau et elle renvoi 
	//un autre tableau rempli  (IA)
	int j=0,i=0,compteur=0;
        
	int[] tabcolonne = new int[81];
	int[] tabligne = new int[81];
	int[] tabvaleur = new int[81];
	int k=0;
	for(j=0;j<9;j++) {
	   
	    for(i=0;i<9;i++) {
System.out.println("k = "+k);
		compteur++;
		System.out.println("j = "+j+""+"i= "+i);
		inttest=0;
		if(grillenonrempli[j][i]==0) {
		    bool=true;
		    while(bool==true) {
			System.out.println("inttest = "+inttest);
			if(bool==true && inttest>9) {
			    
			    k--;
			    i=tabcolonne[k];
			    j=tabligne[k];
			    inttest=tabvaleur[k];
			    
				
			}
	         
			inttest++;
			
	        
			grillenonrempli[j][i]=inttest;
			if(inttest<10) {
			bool=Sudoku.verifContrainte(grillenonrempli,i,j,inttest);
			}
			else {
			    grillenonrempli[j][i]=0;
			}
		        
		    }
		    tabcolonne[k]=i;
		    tabligne[k]=j;
		    tabvaleur[k]=inttest;
		    
		    k++;
		    
			
		    
		}
		   
		
	    }
	}
	grillerempli=grillenonrempli;
	return grillerempli;
    }
    /**
meme methode que verif contrainte mais sur un tableau a 3 dimensions
    **/

    public static boolean verifContrainteManuelMod(int[][][] tab,int aleac,int aleal,int a) {

	int compteur1=0,compteur2=0,compteur3=0,compteur4=0,i,j,k;
	for(k=0;k<4;k++){
	    if(tab[aleal][aleac][k]==a){//a l'interieur d'une case
		compteur4++;
	    }
		    
	}
	for(i=0;i<9;i++) {
	    for(k=0;k<4;k++){
		if(tab[aleal][i][k]==a) { //ligne
		    compteur1++;

		}
		if(tab[i][aleac][k]==a){ //colonne
		    compteur2++;

		}
	    }
	}

	if(aleac<3 && aleal<3) { // all region 1
	    // System.out.println("region1");
	    for(j=0;j<3;j++) {
		for(i=0;i<3;i++) {
		    for(k=0;k<4;k++){
			if(tab[j][i][k]==a) {
			    compteur3++;
			}
		    }
		}
	    }
	}
	if(aleac>2 && aleac<6 && aleal<3) { // all region 2
	    //System.out.println("region2");
	    for(j=0;j<3;j++) {
		for(i=3;i<6;i++) {
		    for(k=0;k<4;k++){
			if(tab[j][i][k]==a) {
			    compteur3++;
			}
		    }
		}
	    }
	}

	if(aleac>5 && aleal<3) { // all region 3
	    // System.out.println("region3");
	    for(j=0;j<3;j++) {
		for(i=6;i<9;i++) {
		    for(k=0;k<4;k++){
			if(tab[j][i][k]==a) {
			    compteur3++;
			}
		    }
		}
	    }
	}
	if(aleac<3 && aleal>2 && aleal<6) { // all region 4
	    // System.out.println("region4");
	    for(j=3;j<6;j++) {
		for(i=0;i<3;i++) {
		    for(k=0;k<4;k++){
			if(tab[j][i][k]==a) {
			    compteur3++;
			}
		    }
		}
	    }
	}
	if(aleac>2 && aleac<6 && aleal>2 && aleal<6) { // all region 5
	    //  System.out.println("region5");
	    for(j=3;j<6;j++) {
		for(i=3;i<6;i++) {
		    for(k=0;k<4;k++){
			if(tab[j][i][k]==a) {
			    compteur3++;
			}
		    }
		}
	    }
	}
	if(aleac>5 && aleal>2 && aleal<6) { // all region 6
	    // System.out.println("region6");
	    for(j=3;j<6;j++) {
		for(i=6;i<9;i++) {
		    for(k=0;k<4;k++){
			if(tab[j][i][k]==a) {
			    compteur3++;
			}
		    }
		}
	    }
	}
	if(aleac<3 && aleal>5) { // all region 7
	    // System.out.println("region7");
	    for(j=6;j<9;j++) {
		for(i=0;i<3;i++) {
		    for(k=0;k<4;k++){
			if(tab[j][i][k]==a) {
			    compteur3++;
			}
		    }
		}
	    }
	}
	if(aleac>2 && aleac<6 && aleal>5) { // all region 8
	    //  System.out.println("region8");
	    for(j=6;j<9;j++) {
		for(i=3;i<6;i++) {
		    for(k=0;k<4;k++){
			if(tab[j][i][k]==a) {
			    compteur3++;
			}
		    }
		}
	    }
	}
	if(aleac>5 && aleal>5) { // all region 9
	    // System.out.println("region9");
	    for(j=6;j<9;j++) {
		for(i=6;i<9;i++) {
		    for(k=0;k<4;k++){
			if(tab[j][i][k]==a) {
			    compteur3++;
			}
		    }
		}
	    }
	}				     
	if(compteur1>1){
	    System.out.println("PROBLIGNE");
	    return true;
	}
	if(compteur2>1) {
	    System.out.println("PROBCOLONNE");
	    return true;
	}
	if(compteur3>1) {
	    System.out.println("PROBREGION");
	    return true;
	}
	if(compteur4>1) {
	    System.out.println("PROBCASE");
	    return true;
	}
	return false;

    }
}

	    
	































