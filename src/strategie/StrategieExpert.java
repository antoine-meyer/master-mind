package strategie;

import java.awt.Color;
import java.util.ArrayList;

import application.Modele;

public class StrategieExpert implements StrategieEval {
	private Modele model;
	//constructeur
	public StrategieExpert(Modele m) {
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
		
		//on compte le nombre de bien place
		int nbBienPlaces = 0;
        for (int k = 0; k < this.getModel().getSecret().getInt().length; k++) {
            if (this.model.getSecret().getInt()[k] == couleursRangeeSimple[k]) {
                nbBienPlaces++;
            }
        }
        //on compte le nombre d'existant mais mal place
        int nbMalPlacees = 0;
        for (int k = 0; k < this.getModel().getSecret().getInt().length; k++) {
            if (listCouleursSecret.contains(couleursRangeeSimple[k])) {
                nbMalPlacees++;
            }
        }
        nbMalPlacees -= nbBienPlaces;
        int nbPasPresent = 0;
        for (int k = 0; k < this.getModel().getSecret().getInt().length; k++) {
            if (!listCouleursSecret.contains(couleursRangeeSimple[k])) {
                nbPasPresent++;
            }
        }
        //remplissage du tableau reponse avec d'abord les billes noires
        for (int k = 0; k < nbBienPlaces; k++) {
            res[k] = 2;
        }
        //puis les billes blanches
        for (int k = nbBienPlaces; k < nbMalPlacees+nbBienPlaces; k++) {
            res[k] = 1;
        }
        //et enfin les billes grises
        for (int k = nbMalPlacees+nbBienPlaces; k < nbPasPresent+nbMalPlacees+nbBienPlaces; k++) {
            res[k] = 0;
        }
		return res;
	}

	public Modele getModel() {
		return this.model;
	}
}
