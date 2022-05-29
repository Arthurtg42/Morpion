package morpion;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class IHMv2 {
    // Widget pour faire une case du jeu sous forme de JButton
    private class CaseJeu extends JButton {
        private int x, y, no_case;
        
        public CaseJeu(int x, int y, int no_case) {
            super();
            
            this.x = x;
            this.y = y;
            this.no_case = no_case;
            
            this.setFont(new Font("Helvetica", Font.BOLD, 90));
            this.setJoueur(null);
        }
        
        public void setJoueur(String joueur) {
            if (joueur == null) {
                this.setEnabled(true);
                this.setText("");
            } else {
                this.setEnabled(false);
                this.setText(joueur);
            }
        }
        
        public int getNumCase(){ return no_case;}
        
    };
 
    private Controleur controleur;
    private JLabel etatJeu;
    private JFrame fenetre;
    private ArrayList<CaseJeu> casesJeu;

    public IHMv2(Controleur controleur) {
        this.controleur = controleur;
        creerFenetre();
    }
    
    private void creerFenetre() {
        /* instanciation de la liste des cases de Jeu */
        casesJeu = new ArrayList<>();
        etatJeu = new JLabel("Au joueur X de jouer!");
        /* Instanciation et configuration du composant fenetre */
        fenetre = new JFrame("MORPION");

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(3,3));
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                casesJeu.add(new CaseJeu(i,j,i*3+j));
                int noCase = i*3+j;
                casesJeu.get(i*3+j).addActionListener(
                    new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                            controleur.jouerCoup(noCase);
                        }
                });
                panelCentral.add(casesJeu.get(i*3+j));
            }
        }
        JButton buttonTerminer = new JButton("Recommencer une partie");
        buttonTerminer.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        controleur.nouvellePartie();
                    }
                });
        
        
        panelPrincipal.add(etatJeu, BorderLayout.NORTH);
        panelPrincipal.add(panelCentral, BorderLayout.CENTER);
        panelPrincipal.add(buttonTerminer, BorderLayout.SOUTH);
        fenetre.add(panelPrincipal);
        // Garder à la fin
        afficher();
    }

    // Méthode appelée par le contrôleur
    public void demarrerJeu(String joueur) {
        // A Compléter
        
    }

    // Méthode appelée par le contrôleur    
    public void jouerCase(int no_case, String joueur) {
        // A Compléter
        casesJeu.get(no_case).setJoueur(joueur);
    }
    
    // Méthode appelée par le contrôleur 
    public void changerJoueur(String joueur) {
        // A Compléter
        etatJeu.setText("Au joueur "+joueur+" de jouer !");
    }

    // Méthode appelée par le contrôleur    
    public void terminerJeu(String gagnant) {
        // A Compléter
        etatJeu.setText("Jeu terminé : " + gagnant + " gagnant");
        for(JButton c : casesJeu){
            c.setEnabled(false);
        }
    }
    
    public void afficher() {
        fenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(400, 400);
        fenetre.setVisible(true);                        
    }
    
    public void nouvellePartie(){
        etatJeu.setText("NOUVELLE PARTIE : au joueur X de jouer!");
        for(JButton c : casesJeu){
            c.setEnabled(true);
            c.setText("");
        }
    }
}