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
public class VueInscription extends JPanel {
    private JLabel choixJoueur;    
    private JComboBox choixPremierJoueur;
    private JButton demarrer;
    private IHM vueIHM;

    public VueInscription(IHM ihm) {
        this.vueIHM = ihm;

        /* Composants pour choisir le joueur qui commence la partie */
        choixJoueur = new JLabel("Choix du premier joueur");
        choixPremierJoueur = new JComboBox(new String [] { "X", "O" });
        demarrer = new JButton("Demarrer partie");

        this.setLayout(new GridLayout(2,2));
        this.add(choixJoueur);        this.add(new JPanel());
        this.add(choixPremierJoueur); this.add(demarrer);     

        // Action pour le bouton demarrer
        demarrer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vueIHM.choixPremierJoueur((String) choixPremierJoueur.getSelectedItem());
            }
        });
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);

        demarrer.setEnabled(enabled);
        choixJoueur.setEnabled(enabled);
        choixPremierJoueur.setEnabled(enabled);             
    }        
}

