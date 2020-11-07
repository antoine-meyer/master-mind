package tp_note_2017;

import java.util.ArrayList;

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
	private Rangee[] rangees;
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
		this.rangees = new RangeeSimple[7];
		int[] ints = { 0, 0, 0, 0 }; 
		for (int i = 0; i < this.getRangees().length; i++) {
			this.rangees[i] = new RangeeSimple(ints, this);
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
	public Rangee[] getRangees() {
		return this.rangees;
	}
	/**
	 * 
	 */
	public void selectCouleur(int i) {
		//modifier la couleur courante
		this.couleurEnCours = i;
		//affecter la couleur courante à la case courante de la rangée en cours
		int[] ints = {
				this.rangees[this.ligneEnCours].getInt()[0],
				this.rangees[this.ligneEnCours].getInt()[1],
				this.rangees[this.ligneEnCours].getInt()[2],
				this.rangees[this.ligneEnCours].getInt()[3]
		}; 
		ints[this.colonneEnCours] = this.couleurEnCours;
		this.rangees[this.ligneEnCours].setInt(ints);
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
		//faire des choses
		System.out.println("Methode valider");
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
