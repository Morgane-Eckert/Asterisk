import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import edu.princeton.cs.introcs.StdDraw;

public class Main {
	
	private static File fichier = new File("coordonnées_region.txt");
	private static File voisins = new File("voisins.txt");
	
	public static void main(String[] args) throws FileNotFoundException {
		int[][] t = LireCoordonnées();
		int[][] v = ListeVoisins();
		String [] listeNoms = new String [] {"Goudurisk","Obelisk","Asterisk","Idefisk","Panoramisk","Abraracourcisk"};
		//String [] listeCouleurs = new String [] {color.RED,blue,green,black","yellow","white"};//
		ArrayList <Joueur> joueurs = new ArrayList<Joueur> ();
		int nbrJoueurs=0;
		int l=41;
		Random rand = new Random();
		Carte carte = new Carte(t,v);
		// OBTENIR LE NOMBRE DE JOUEURS //
		
		// création des objets joueurs //
		
		for(int k=1;k<=nbrJoueurs;k++) {
			Joueur Joueur = new Joueur(listeNoms[k],Color.red);
			joueurs.add(Joueur);
		}
		
		// répartition des territoires //
		
		ArrayList<Integer> nombres = new ArrayList<Integer>();
		for(int j=0;j<42;j++) {
			nombres.add(j);
		}
		
		// répartition aléatoire des territoires entre les joueurs //
		
		while(l>0) {
			for(Joueur player : joueurs) {
				int randomIndex = rand.nextInt((l - 0) + 1) + 0;
				ArrayList<Territoire> territoires = carte.getTerritoire();
				player.addTerritoire(territoires.get(l));
				territoires.remove(l);
				l--;
			}
		}
		
		// répartition des armées entre les joueurs //
		
		switch (nbrJoueurs){
			case 2:
				for(Joueur player : ListeJoueurs) {
					for(int i=1;i<=40;i++) {
						Unite UNITE = new Unite(false,"Soldier",i,0,1,2,1);
						player.addUnite(UNITE);
					}
				}
				break;
			case 3:
				for(Joueur player : ListeJoueurs) {
					for(int i=1;i<=35;i++) {
						Unite UNITE = new Unite(false,"Soldier",i,0,1,2,1);
						player.addUnite(UNITE);
					}
				}
				break;
			case 4:
				for(Joueur player : ListeJoueurs) {
					for(int i=1;i<=30;i++) {
						Unite UNITE = new Unite(false,"Soldier",i,0,1,2,1);
						player.addUnite(UNITE);
					}
				}
				break;
			case 5:
				for(Joueur player : ListeJoueurs) {
					for(int i=1;i<=25;i++) {
						Unite UNITE = new Unite(false,"Soldier",i,0,1,2,1);
						player.addUnite(UNITE);
					}
				}
				break;
			case 6:
				for(Joueur player : ListeJoueurs) {
					for(int i=1;i<=20;i++) {
						Unite UNITE = new Unite(false,"Soldier",i,0,1,2,1);
						player.addUnite(UNITE);
					}
				}
				break;
			default:
				break;
		}
		
		//Menu/*
		/*
		StdDraw.setCanvasSize(800, 800);
		StdDraw.setScale(0, 800);
		Font font = new Font("Comic Strip MN", Font.PLAIN, 80);
		StdDraw.setFont(font);
		StdDraw.text(370,400, "Salut");
		StdDraw.setPenColor(Color.BLACK);*/
		
		
		Carte map = new Carte(t, v);
		map.initialisation();
		while(true) {
			map.Maj();
		}
	}
	
	public static int[][] ListeVoisins() throws FileNotFoundException{
		int k = 0;
		int i = 0;
		int cache = 0;
		int[][] tab = new int[50][7];
		Scanner sc = new Scanner(voisins);
		while(sc.hasNextLine()) {
			cache = sc.nextInt();
			if(cache == 99) {
				tab[i][k] = cache;
				i++;
				k = 0;
			} else {
				tab[i][k] = cache;
				k++;
			}
		}
		return tab;
	}
	
	public static int[][] LireCoordonnées(){
		int i = 0;
		int[][] tab = new int[42][2];
		Scanner sc;
		try {
			sc = new Scanner(fichier);
			while(sc.hasNextLine()) {
			    tab[i][0]= sc.nextInt();
			    tab[i][1] = sc.nextInt();
			    i++;
			}
			sc.close();
			return tab;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return tab;
		}
	}
	
	
	
}
