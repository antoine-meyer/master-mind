package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import application.Modele;
import application.Observateur;
import rangees.Rangee;
import rangees.RangeeSimple;
import strategie.StrategieDebutant;
import strategie.StrategieExpert;

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
		if(a.getActionCommand().equals("Valider") && !this.mod.getFini()) {
			System.out.println(" valider");
			this.mod.valider();
		}
		if(a.getActionCommand().equals("Debutant")&& !this.mod.getFini()) {
			System.out.println(" débutant");
			this.mod.setEval(new StrategieDebutant(this.mod));
		}
		if(a.getActionCommand().equals("Expert")&& !this.mod.getFini()) {
			System.out.println(" expert");
			this.mod.setEval(new StrategieExpert(this.mod));
		}
		if(a.getActionCommand().equals("Rejouer")) {
			System.out.println(" rejouer");
			this.mod.resetJeu();
		}
	}
}
