# master-mind

Jeu développé en **Java** au cours de mon deuxième semestre à l'*Institut Universitaire de Technologie* en informatique de Nancy, France. Ce projet a été réalisé seul.

Ce jeu est une copie/version informatisée du célèbre jeu de société **Mastermind**.

Captures d'écrans du jeu :

[à venir]

Fonctionnalitées :
- Choix du mode d'évaluation des rangées :    
→ Par défaut c'est le mode débutant qui est actif.  
→ Le mode courant est lisible à partir du moment où on a évalué la première ligne.   
→ Le mode d'évaluation ne ré-évalue pas les lignes lorsqu'il est changé : seul l'affichage 'Débutant' ou 'Expert' change.   
→ Mode débutant :       
  - Disque noir = bille bien placée et de la bonne couleur   
  - Disque blanc = bille d'une couleur de la combinaison à découvrir mais mal placée    
  - Disque gris = bille d'une couleur qui ne correspond pas à une couleur de la combinaison à découvrir  
  
  → Mode expert : Indique uniquement le nombre de couleurs bien ou mal placées sans en donner la position
  
- Bouton pour relancer une partie
- Choix des couleurs et de la case courante à la souris
- Un curseur pour identifier la case courante

Techniquement :
- Utilisation de patrons de conception :       
→ stratégie    
→ décorateur    
→ observateur    
- Architecture globale dite MVC ( Modèle Vues Contrôleurs )
