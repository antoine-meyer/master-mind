package rangees;

import java.awt.Color;
import java.util.ArrayList;

import application.Modele;
import application.MyImage;
import strategie.StrategieDebutant;
import strategie.StrategieEval;

public class RangeeFinale implements Rangee {
	private Rangee ran;
	private Modele m;
	public RangeeFinale(Modele m, Rangee r) {
		this.ran = r;
		this.m = m;
		this.m.setMasquer(false);
	}
	public int[] getInt() {
        return this.ran.getInt();
    }
	public void setInt(int[] s)
	{
		
	}
	public MyImage getImage(int l)
	{
	    RangeeSimple rangeeS = (RangeeSimple)ran;
	    //les petites billes
	    MyImage im = rangeeS.getImage(l);
	    //le type d'évaluation
	    MyImage res = new MyImage(250, 20);
	    if(this.m.getVictoire() == true) {
	    	res.dessinerChaine("Bravo, vous avez gagné !", 10, 10, Color.BLACK);
	    }else {
	    	res.dessinerChaine("Perdu !", 10, 10, Color.BLACK);
	    }
	    im.superposer(res, 200, 20);
	    //on renvoie le résultat
	    return im;
	}
	public Modele getModel() {
		return this.ran.getModel();
	}
}


