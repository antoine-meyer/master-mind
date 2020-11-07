/**
 * 
 */
package tp_note_2017;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Classe � modifier selon l'enonce du TP, 
 * permet de construire l'interface graphique.
 *
 */
public class Principale {

	public static void main(String[] args) {	
		Modele m = new Modele();
		ControleurBouton c = new ControleurBouton(m);
		ControleurCouleur cc = new ControleurCouleur(m);
		ControleurCase ccase = new ControleurCase(m);
		VueGrille v = new VueGrille(m);
		v.addMouseListener(ccase);
		m.enregistrerObservateur(v);

		// JPanel situ� au nord de l'IG contenant les rang�es
		// du jeu � remplir pour d�couvrir la bonne combinaison de couleurs
		v.setPreferredSize(new Dimension(400,450));
		// JPanel au centre de l'IG contenant les 4 boutons
		JPanel panelBouton= new JPanel(new GridLayout(2,2));
		//crea des boutons
		JButton jbv = new JButton("Valider");
		jbv.addActionListener(c);
		panelBouton.add(jbv);
		JButton jb = new JButton("Masquer");
		jb.addActionListener(c);
		panelBouton.add(jb);
		JButton btnExpert = new JButton("Expert");
		btnExpert.addActionListener(c);
		panelBouton.add(btnExpert);
		JButton btnDebutant = new JButton("Debutant");
		btnDebutant.addActionListener(c);
		panelBouton.add(btnDebutant);
		// JPanel au sud de l'IG dans lequel se trouve l'affichage
		// des couleurs disponibles 
		ChoixCoul choixCoul= new ChoixCoul(m);
		choixCoul.addMouseListener(cc);
		/*************************************
		 * Construction de l'IG dans une JFrame
		 *************************************/
		JFrame frame=new JFrame("master-mind");	
		frame.add(v,BorderLayout.NORTH); 
		frame.add(panelBouton,BorderLayout.CENTER);
		frame.add(choixCoul, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
