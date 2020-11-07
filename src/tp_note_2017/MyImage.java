package tp_note_2017;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * La classe MyImage permet de creer des images a partir d'un chemin et d'y
 * superposer d'autres images dont le nom est donne
 * 
 * <ul>
 * <li>le constrtucteur construit une image a partir d'un fichier
 * <li>la methode superposer permet d'ajouter un calque au dessus de l'image
 * <li>la methode dessinerDansComposant permet de dessiner le resultat dans un
 * composant
 * </ul>
 
 */
public class MyImage {

	/**
	 * l'objet image stockee dans MyImage
	 */
	BufferedImage image;

	/**
	 * constructeur de la classe MyImage. Construit une image vide de taille tx, ty
	 * 
	 */
	public MyImage(int tx, int ty) {
		this.image = new BufferedImage(tx, ty, BufferedImage.TYPE_4BYTE_ABGR);
	}

	/**
	 * permet de dessiner un ovale
	 * 
	 * 
	 */
	public void dessinerRond(int x, int y, int width, int height, Color c) {
		Graphics g = this.image.getGraphics();
		g.setColor(c);
		g.fillOval(x, y, width, height);
		g.dispose();
	}
	
	/**
	 * permet de dessiner un restangle
	 * 
	 * 
	 */
	public void dessinerRectangle(int x, int y, int width, int height, Color c) {
		Graphics g = this.image.getGraphics();
		g.setColor(c);
		g.drawRect(x, y, width, height);
		g.dispose();
	}

	/**
	 * superpose dans l'image une image
	 * 
	 * @param im
	 *            image a superposer
	 * @param x
	 *            position en x dans le composant
	 * @param y
	 *            position en y dans le composant
	 */
	public void superposer(MyImage im, int x, int y) {
		Graphics g = this.image.getGraphics();
		g.drawImage(im.image, x, y, null);
		g.dispose();
	}

	/**
	 * Affichage de l'image contenu dans MyImage dans un JPanel dont on passe le
	 * graphics
	 * 
	 * @param g
	 *            graphics dans lequel dessiner
	 * @param x
	 *            position en x dans le composant
	 * @param y
	 *            position en y dans le composant
	 */
	public void dessinerDansComposant(Graphics g, int x, int y) {
		g.drawImage(image, x, y, null);
	}

	/**
	 * permet de dessiner une chaine de caracteres
	 * 
	 * @param chaine
	 *            la chaine a dessiner
	 * @param i
	 *            position en x
	 * @param j
	 *            position en y
	 */
	public void dessinerChaine(String chaine, int i, int j,Color coul) {
		Graphics g = this.image.getGraphics();
		g.setColor(coul);
		g.drawString(chaine, i, j);
		g.dispose();

	}

}