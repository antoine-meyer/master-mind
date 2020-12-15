/**
 * 
 */
package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controleurs.ControleurBouton;
import controleurs.ControleurCase;
import controleurs.ControleurCouleur;

/**
 * Classe � modifier selon l'enonce du TP, 
 * permet de construire l'interface graphique.
 *
 */
public class Principale {
	
	private static Modele model;
	private static VueGrille grille;
	private static JFrame frame;
	
	public static void main(String[] args) {
		Principale.model = new Modele();
		Principale.grille = new VueGrille(model);
		Principale.init();
	}
	
	private static void init() {
	
		Principale.grille.setPreferredSize(new Dimension(400,450));
		Principale.model.enregistrerObservateur(Principale.grille);
		ControleurCase controlCase= new ControleurCase(Principale.model);
		Principale.grille.addMouseListener(controlCase);
		
		// JPanel au centre de l'IG contenant les 4 boutons
		JPanel panelBouton= new JPanel(new GridLayout(3,2));
		ControleurBouton controlb=new ControleurBouton(Principale.model);
		JButton jbv = new JButton("Valider");
		jbv.addActionListener(controlb);
		panelBouton.add(jbv);
		
		
		
		/*JButton jb = new JButton("Masquer");
		jb.addActionListener(controlb);
		panelBouton.add(jb);*/
		
		// Rejouer
		JButton btnRejouer = new JButton("Rejouer");
		btnRejouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principale.frame.dispose();
				Principale.model=new Modele();
				Principale.grille = new VueGrille(model);
				Principale.init();
			}
		});
		btnRejouer.setEnabled(true);
		panelBouton.add(btnRejouer);
		
		
		
		JButton btnExpert = new JButton("Expert");
		btnExpert.addActionListener(controlb);
		panelBouton.add(btnExpert);
		JButton btnDebutant = new JButton("Debutant");
		btnDebutant.addActionListener(controlb);
		panelBouton.add(btnDebutant);

		

		// JPanel au sud de l'IG dans lequel se trouve l'affichage
		// des couleurs disponibles 
		JPanel choixCoul= new ChoixCoul(Principale.model);
		ControleurCouleur controlCoul=new ControleurCouleur(Principale.model);
		choixCoul.addMouseListener(controlCoul);

		/*************************************
		 * Construction de l'IG dans une JFrame
		 *************************************/
		Principale.frame=new JFrame("master-mind");
		Principale.frame.setBackground(new Color(0xDEB887)); // BurlyWood	
		Principale.frame.add(Principale.grille,BorderLayout.NORTH); 
		Principale.frame.add(panelBouton,BorderLayout.CENTER);
		Principale.frame.add(choixCoul, BorderLayout.SOUTH);
		Principale.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Principale.frame.pack();
		Principale.frame.setVisible(true);
	}
	
}
