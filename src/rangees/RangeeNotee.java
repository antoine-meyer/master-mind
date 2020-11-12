package rangees;

import java.awt.Color;

import application.Modele;
import application.MyImage;

public class RangeeNotee implements Rangee {
	private Rangee ran;
	private Color[] couleursResultat;
	public RangeeNotee(Rangee r) {
		this.ran = r;
		this.couleursResultat = new Color[4];
		this.couleursResultat[0] = Color.BLACK;
		this.couleursResultat[1] = Color.BLACK;
		this.couleursResultat[2] = Color.BLACK;
		this.couleursResultat[3] = Color.BLACK;
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
	    MyImage im = rangeeS.getImage(ligneEnCours);
	    MyImage res = new MyImage(400, TAILLE);
	    for (int j = 4; j < 8; j++) {
	        res.dessinerRond(j * TAILLE + (ECART+3)*j, ECART, TAILLE - 2, TAILLE - 2, couleursResultat[j-4]);
	    }
	    im.superposer(res, 215, 20);
	    return im;
	}
	public Modele getModel() {
		return this.ran.getModel();
	}
}


