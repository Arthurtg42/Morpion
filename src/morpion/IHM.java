package morpion;

import java.awt.*;
import javax.swing.*;

public class IHM {
    private VueInscription inscription;
    private VueJeu jeu;
    private JFrame fenetre;
    private Controleur controleur;
    
    public IHM(Controleur controleur) {
        this.controleur = controleur;
        
        creerFenetre();
    }
    
    private void creerFenetre() {
        inscription = new VueInscription(this);
        jeu = new VueJeu(this);
        
        fenetre = new JFrame("Morpion");
        fenetre.setLayout(new GridLayout(2,1));
        fenetre.add(inscription);
        fenetre.add(jeu);
        fenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(400, 150);
        fenetre.setVisible(true);
    }

    // Méthode appelée par la vue inscription (classe VueInscription)
    public void choixPremierJoueur(String joueur) {
        controleur.choisirPremierJoueur(joueur);
    }

    // Méthode appelée par la vue jeu (classe VueJeu)    
    public void selectionCase(int no_case) {
        controleur.jouerCoup(no_case);
    }
    
    // Méthode appelée par le contrôleur
    public void demarrerJeu(String joueur) {
        inscription.setEnabled(false);
        jeu.setEnabled(true);
        jeu.clear();
        jeu.setJoueur(joueur);        
    }

    // Méthode appelée par le contrôleur    
    public void jouerCase(int no_case) {
        jeu.jouerCase(no_case);
    }
    
    // Méthode appelée par le contrôleur 
    public void changerJoueur(String joueur) {
         jeu.setJoueur(joueur);
    }

    // Méthode appelée par le contrôleur    
    public void terminerJeu(String gagnant) {
        jeu.setGagnant(gagnant);
        jeu.setEnabled(false);        
        inscription.setEnabled(true);
    }
}