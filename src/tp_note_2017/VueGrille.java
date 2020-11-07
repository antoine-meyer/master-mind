package tp_note_2017;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * La classe Grille permet de creer un JPanel contenant :
 * 
 * + l'affichage des objets MyImage associes a 8 instances de RangeeSimple
 * 
 * + l'affichage de la rangee a decouvrir en haut du JPanel, instance de RangeeSimple
 * 
 */
public class VueGrille extends JPanel implements Observateur {
	/**
	 * la taille des cases en pixels
	 */
	public static final int TAILLE = 50;
	/**
	 * 
	 */
	private Modele model;
	/**
	 * 
	 */
	public VueGrille(Modele m) {
		super();	
		this.model = m;
	}
	/**
	 * La methode paintComponent se charge d'effectuer l'affichage de 8 instances 
	 * de la classe RangeeSimple
	 * ainsi que la rang�e � decouvrir en haut du composant.
	 * 
	 * Remarque importante : 
	 * Les instructions de creation des instances de RangeeSimple devront
	 * etre deplacees dans le constucteur de la classe Modele en tenant compte
	 * de ses attributs.
	 */
	public void paintComponent(Graphics g) {
		// dessine le fond en gris
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		// on ajoute chacune des rangees en commencant l'affichage par le bas
		for (int i = 0; i < this.model.getRangees().length; i++) {
			int hauteur = TAILLE*9 - (i + 1) * TAILLE;
			this.model.getRangees()[i].getImage(i).dessinerDansComposant(g, 0, hauteur);
		}
		//on affiche ou non la ligne secrète
		if(!this.model.getMasquer()) {
			this.model.getSecret().getImage(-1).dessinerDansComposant(g, 0, 0);	
		}
		//on affiche la case actuelle
		g.setColor(Color.BLACK);
		g.drawRect(this.model.getColonneEnCours()*TAILLE+5, TAILLE*9-(this.model.getLigneEnCours()+1)*TAILLE+5, 40, 40);
	}
	/*
	 * 
	 */
	public void actualiser(Sujet s) {
		Modele m = (Modele)s;
		System.out.println("Actualisation");
		repaint();
	}
}
