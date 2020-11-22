package strategie;

import java.awt.Color;
import java.util.ArrayList;

import application.Modele;

public class StrategieDebutant implements StrategieEval {
	private Modele model;
	//constructeur
	public StrategieDebutant(Modele m) {
		this.model = m;
	}
	//methode
	public int[] getResultat() {
		int[] res = new int[4];
		//on recupere la liste de couleurs secretes
		int[] reponseCouleursSecretes = this.model.getSecret().getInt().clone();
		//on les met dans une liste
		ArrayList<Integer> listCouleursSecret = new ArrayList<Integer>();
        for (int i = 0; i < reponseCouleursSecretes.length; i++) {
            listCouleursSecret.add(reponseCouleursSecretes[i]);
        }
        //la liste des couleurs générale
        //Color[] couleurs = { Color.GRAY, Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.WHITE, Color.BLACK };
		//la liste des couleurs proposes par le joueur
        int[] couleursRangeeSimple = this.model.getRangees().get(this.model.getLigneEnCours()).getInt().clone();
        //c'est le mode débutant	
        //on parcours les cases
		for(int i=0; i<res.length; i++) {
			//si la couleur est au bonne endroit et de bonne couleur
			if(listCouleursSecret.get(i) == couleursRangeeSimple[i]) {
				res[i] = 2;
			}
			//si la couleur est bonne mais pas au bon endroit
			else if( listCouleursSecret.contains(couleursRangeeSimple[i]) )
			{
				res[i] = 1;
			}
			//si la couleur n'est pas bonne
			else {
				res[i] = 0;
			}
		}
		return res;
	}

	public Modele getModel() {
		return this.model;
	}
}
