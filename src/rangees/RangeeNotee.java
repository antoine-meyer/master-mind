package rangees;

import java.awt.Color;
import java.util.ArrayList;

import application.Modele;
import application.MyImage;
import strategie.StrategieDebutant;
import strategie.StrategieEval;

public class RangeeNotee implements Rangee {
	private Rangee ran;
	private Color[] couleursResultat;
	public RangeeNotee(Rangee r) {
		this.ran = r;
		this.couleursResultat = new Color[4];
		this.correctionCouleurs(this.getModel().getEval().getResultat());
	}
	public int[] getInt() {
        return this.ran.getInt();
    }
	public void setInt(int[] s)
	{
		
	}
	public MyImage getImage(int ligneEnCours)
	{
	    int TAILLE = 10;
	    int ECART = 2;
	    RangeeSimple rangeeS = (RangeeSimple)ran;
	    //les petites billes
	    MyImage im = rangeeS.getImage(ligneEnCours);
	    MyImage res = new MyImage(400, TAILLE);
	    for (int j = 4; j < 8; j++) {
	        res.dessinerRond(j * TAILLE + (ECART+3)*j, ECART, TAILLE - 2, TAILLE - 2, couleursResultat[j-4]);
	    }
	    im.superposer(res, 220, 20);
	    //le type d'évaluation
	    MyImage res2 = new MyImage(100, 20);
	    if(this.getModel().getEval() instanceof StrategieDebutant) {
	    	res2.dessinerChaine("Débutant", 10, 10, Color.BLACK);
	    }else {
	    	res2.dessinerChaine("Expert", 20, 10, Color.BLACK);
	    }
	    im.superposer(res2, 200, 20);
	    //on renvoie le résultat
	    return im;
	}
	public Modele getModel() {
		return this.ran.getModel();
	}
	public void correctionCouleurs(int[] s) {
		for(int i=0; i<s.length; i++) {
			//si la couleur est au bonne endroit et de bonne couleur
			if(s[i] == 2) {
				this.couleursResultat[i] = Color.BLACK;
			}
			//si la couleur est bonne mais pas au bon endroit
			else if(s[i] == 1)
			{
				this.couleursResultat[i] = Color.WHITE;
			}
			//si la couleur n'est pas bonne
			else {
				this.couleursResultat[i] = Color.GRAY;
			}
		}
	}
}


