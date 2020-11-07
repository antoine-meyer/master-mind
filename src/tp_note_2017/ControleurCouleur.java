package tp_note_2017;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControleurCouleur implements MouseListener {
	/**
	 * 
	 */
	private Modele mode;
	/**
	 * 
	 */
	public ControleurCouleur(Modele m) {
		this.mode = m;
	}
	/**
	 * 
	 */
	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getX() <= 6*50) {
			int couleurEnCours = arg0.getX()/50+1;
			this.mode.selectCouleur(couleurEnCours);
		}
	}
	/**
	 * 
	 */
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 
	 */
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 
	 */
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 
	 */
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
