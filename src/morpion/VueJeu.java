/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morpion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author laurillau
 */
public class VueJeu extends JPanel {
    private JLabel etatJeu;
    private JComboBox choixCases;
    private JButton jouer;
    private IHM vueIHM;

    public VueJeu(IHM ihm) {
        this.vueIHM = ihm;

        /* Composant pour l'action à réaliser : choisir une case */
        etatJeu = new JLabel("Jeu terminé : aucun gagnant");        
        choixCases = new JComboBox();
        jouer = new JButton("Jouer");   

        /* Placement des composants */
        this.setLayout(new GridLayout(2,2));
        this.add(etatJeu);    this.add(new JPanel());
        this.add(choixCases); this.add(jouer); 

        // Action pour le bouton jouer
        jouer.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                  Integer no_case = (Integer) choixCases.getSelectedItem();
                  vueIHM.selectionCase(no_case);
              }
        });
    } 

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);

        choixCases.setEnabled(enabled);
        jouer.setEnabled(enabled);
    }         

    public void clear() {
        choixCases.removeAllItems();
        for(int i = 0; i < 9; i++) { choixCases.addItem(i); }            
    }

    public void setJoueur(String joueur) {
        etatJeu.setText("Joueur " + joueur + " choisi une case");
    }

    public void setGagnant(String joueur) {
        etatJeu.setText("Jeu terminé : " + joueur + " gagnant");
    }
    
    public void jouerCase(int no_case) {
        choixCases.removeItem(no_case);
    }
}
