package tp_note_2017;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurBouton implements ActionListener {
	/**
	 * attribut correspond au modèle utilisé
	 */
	private Modele mod;
	/**
	 * 
	 */
	public ControleurBouton(Modele m) {
		this.mod = m;
	}
	/**
	 * 
	 */
	public void actionPerformed(ActionEvent a) {
		System.out.print("Bouton");
		if(a.getActionCommand().equals("Masquer")) {
			System.out.println(" masquer");
			if(this.mod.getMasquer()) {
				this.mod.setMasquer(false);
			}else {
				this.mod.setMasquer(true);	
			}
		}
		if(a.getActionCommand().equals("Valider")) {
			System.out.println(" valider");
			this.mod.valider();
		}
		if(a.getActionCommand().equals("Debutant")) {
			System.out.println(" débutant");
		}
		if(a.getActionCommand().equals("Expert")) {
			System.out.println(" expert");
		}
	}
}
