package controleurs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import application.Modele;

public class ControleurCase implements MouseListener {
	/**
	 * 
	 */
	private Modele mode;
	/**
	 * 
	 */
	public ControleurCase(Modele m) {
		this.mode = m;
	}
	/**
	 * 
	 */
	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getX() <= 4*50 && !this.mode.getFini()) {
			int caseEnCours = arg0.getX()/50;
			this.mode.setColonneEnCours(caseEnCours);
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

