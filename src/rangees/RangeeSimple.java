package rangees;

import java.awt.Color;

import application.Modele;
import application.MyImage;


/**
 * La classe RangeeSimple permet de creer une rangee � partir 
 * d'un tableau d'entiers correspondant � des couleurs
 *  
 * <ul>
 * <li>le constrtucteur construit une rangee a partir d'un tableau d'entiers
 * <li>la methode getImage permet de creer l'image associee a la rangee
 * </ul> 
 */

public class RangeeSimple implements Rangee {
  /**
   * Tableau des entiers correspondant aux couleurs des disques de la rangee cree
   */
	private int[] ints;
	
  /**
   * Tableau des couleurs, les indices dans le tableau sont associ�s avec 
   * les valeurs dans le tableau ints	
   */
	private Color[] couleurs = { Color.GRAY, Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.WHITE,
			Color.BLACK };
	
	/**
	 * attribut correspond au modèle utilisé
	 */
	private Modele mod;
    
   /**
    * Construit une rangee en fonction du tableau d'entiers passe en parametre
    * @param ints
    */
	public RangeeSimple(int[] ints, Modele m) {
		this.ints = ints;
		this.mod = m;
	}
	/**
	 * 
	 */
	public int[] getInt() {
		return ints;
	}
	/**
	 * 
	 */
	public void setInt(int[] s) {
		this.ints = s;
	};
	/**
	 * 
	 */
	public Modele getModel() {
		return this.mod;
	}
	/**
	 * 
	 * @param ligneEnCours
	 * @return une instance de MyImage correspondant � l'image de la rangee
	 * avec les disques de couleur
	 */
	public MyImage getImage(int ligneEnCours) {
		int TAILLE = 50;
		int ECART = 10;
		// creation de l'image du bandeau
		MyImage im = new MyImage(400, TAILLE);
		// dessin des cases avec les disques de couleur
		for (int j = 0; j < ints.length; j++) {	
			Color coul = couleurs[ints[j]];
			im.dessinerRond(j * TAILLE + ECART, ECART, TAILLE - 2 * ECART, TAILLE - 2 * ECART, coul);
		}
		return im;
	}

}
