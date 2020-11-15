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
		
		
		res[0] = 0;
		res[1] = 1;
		res[2] = 0;
		res[3] = 2;
		
		return res;
	}

	public Modele getModel() {
		return this.model;
	}
}
