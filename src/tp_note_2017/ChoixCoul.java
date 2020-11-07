package tp_note_2017;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * La classe ChoixCoul permet de creer un JPanel qui affiche
 * la rang�e constituee de toutes les couleurs pouvant
 * etre choisies.
 */
public class ChoixCoul extends JPanel {
	/**
	 * 
	 */
	MyImage image;
	/**
	 * on construit la selection de la couleur en construisant une rangee 
	 * avec toutes les couleurs possibles
	 * 
	 */
	public ChoixCoul(Modele m) {
		super();
		this.setPreferredSize(new Dimension(300,50));
		int[] ints = { 1, 2, 3, 4, 5, 6 };
		RangeeSimple r = new RangeeSimple(ints, m);
		image = r.getImage(-1);
	}

	/**
	 * on dessine simplement la rangee
	 */
	public void paintComponent(Graphics g) {
		image.dessinerDansComposant(g, 0, 0);
	}
}
