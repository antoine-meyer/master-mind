package application;

import java.util.ArrayList;
import java.util.List;

import rangees.*;

public class Modele implements Sujet {
	/**
	 * attribut correspondant a un booléen indiquant si la combinaison à découvrir est masquée (true) ou non (false).
	 */
	private boolean masquer;
	/**
	 * attribut correspondant au numéro de la rangée courante
	 */
	private int ligneEnCours;
	/**
	 * attribut correspondant au numéro de la case courante dans la rangée courante
	 */
	private int colonneEnCours;
	/**
	 * attribut qui est la rangée contenant la combinaison de couleurs à découvrir (tirées au hasard en début de partie)
	 */
	private RangeeSimple secret;
	/**
	 * attribut qui est une liste de Rangee du jeu et contenant initialement des instances de RangeeSimple (ArrayList)
	 */
	//private Rangee[] rangees;
	private List<Rangee> rangees;
	/**
	 * attribut correspondant 
	 */
	private int couleurEnCours;
	/**
	 *
	 */
	private ArrayList<Observateur> observateurs;
	/**
	 * constructeur d'un modèle
	 */
	public Modele() {
		this.masquer = false;
		this.ligneEnCours = 0;
		this.colonneEnCours = 0;
		int[] intSecret = { (int) (Math.random() * 6 + 1), (int) (Math.random() * 6 + 1), (int) (Math.random() * 6 + 1), (int) (Math.random() * 6 + 1) };
		this.secret = new RangeeSimple(intSecret, this);
		this.rangees = new ArrayList<Rangee>();
		int[] ints = { 0, 0, 0, 0 }; 
		for (int i = 0; i < 7; i++) {
			this.rangees.add(new RangeeSimple(ints, this));
		}
		this.couleurEnCours = 0;
		this.observateurs = new ArrayList<Observateur>();
	}
	/**
	 * 
	 */
	public void enregistrerObservateur(Observateur o) {
		this.observateurs.add(o);
	}
	/**
	 * 
	 */
	public void supprimerObservateur(Observateur o) {
		int i = this.observateurs.indexOf(o);
		if (i >= 0) {
			this.observateurs.remove(i);
		}
	}
	/**
	 * 
	 */
	public void notifierObservateurs() {
		for (int i = 0; i < this.observateurs.size(); i++) {
			Observateur observer = this.observateurs.get(i);
			observer.actualiser(this);
		}
	}
	/**
	 * 
	 */
	public List<Rangee> getRangees(){
		return this.rangees;
	}
	/**
	 * 
	 */
	public void selectCouleur(int i) {
		//modifier la couleur courante
		this.couleurEnCours = i;
		//affecter la couleur courante à la case courante de la rangée en cours
		int[] ints = this.getRangees().get(this.ligneEnCours).getInt().clone();
		ints[this.colonneEnCours] = this.couleurEnCours;
		this.getRangees().get(ligneEnCours).setInt(ints);
		//on avance d'une case pour etre sympa avec le joueur
		if(this.getColonneEnCours() < 3) {
			this.setColonneEnCours(this.getColonneEnCours()+1);
		}
		this.notifierObservateurs();
	}
	/**
	 * 
	 */
	public void setColonneEnCours(int c) {
		this.colonneEnCours = c;
		this.notifierObservateurs();
	}
	/**
	 * 
	 */
	public void valider() {
		int[] ints = this.getRangees().get(ligneEnCours).getInt();
		//on vérifie que chaque bille à une couleur autre que celle de base
		boolean validable = true;
		for(int i=0; i<ints.length; i++) {
			if(ints[i] == 0) {
				validable = false;
			}
		}
		//si toutes les billes ont une couleur alors on peut valider la rangée
		if(validable) {
			//on décore la rangée sur l'aquelle on travaille 
			//this.rangees[this.ligneEnCours] = new RangeeSimple(ints, this);
			this.rangees.set(ligneEnCours, new RangeeNotee(rangees.get(ligneEnCours)));
			//this.rangees[this.ligneEnCours] = new RangeeNotee(this.rangees[this.ligneEnCours]);
			//on avance dans les colonnes
			this.ligneEnCours = this.ligneEnCours + 1;
			this.colonneEnCours = 0;
		}
		this.notifierObservateurs();
	}
	/**
	 * 
	 */
	public int getLigneEnCours() {
		return this.ligneEnCours;
	}
	/**
	 * 
	 */
	public Rangee getSecret() {
		return this.secret;
	}
	/**
	 * 
	 */
	public boolean getMasquer() {
		return this.masquer;
	}
	/**
	 * 
	 */
	public void setMasquer(boolean m) {
		this.masquer = m;
		this.notifierObservateurs();
	}
	/**
	 * 
	 */
	public int getColonneEnCours() {
		return this.colonneEnCours;
	}
	/**
	 * 
	 */
	public int getCouleurEnCours() {
		return this.couleurEnCours;
	}
}
