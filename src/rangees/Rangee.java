package rangees;

import application.Modele;
import application.MyImage;

public interface Rangee {
	/**
	 * getter permettant de récupérer le tableau des entiers correspondant aux couleurs des disques de la rangee cree
	 */
	public int[] getInt();
	/**
	 * 
	 */
	public void setInt(int[] s);
	/**
	 * getter permettant de récupérer l'instance de MyImage correspondant a l'image de la rangee avec les disques de couleur
	 */
	public MyImage getImage(int i);
	
	/**
	 * getter permettant de récupérer l'attribut correspond au modèle utilisé
	 */
	public Modele getModel();
}
