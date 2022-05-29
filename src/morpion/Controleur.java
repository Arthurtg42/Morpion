package morpion;

public class Controleur {
    private IHMv2 ihm;
    private Morpion morpion;
    
    public Controleur() {
        ihm = new IHMv2(this);
        morpion = new Morpion();        
    }
   
    private String getJoueurVue(int numero_joueur) {
        return (numero_joueur == 0 ? "X" : (numero_joueur == 1 ? "O" : "aucun"));
    }
    
    private int getNumeroJoueur(String vJoueur) {
        return ("X".equals(vJoueur) ? 0 : 1);
    }
    
    public void choisirPremierJoueur(String joueur) {
         morpion.commencerPartie(getNumeroJoueur(joueur));
         ihm.demarrerJeu(joueur);
    }
    
    public void jouerCoup(int no_case) {
         boolean fini;
         String joueur;
        
         // Mise à jour de l'IHM
         joueur = getJoueurVue(morpion.getJoueurCourant());
         ihm.jouerCase(no_case, joueur);
         
         // Jouer un coup
         fini = morpion.jouer(no_case);         

         joueur = getJoueurVue(morpion.getJoueurCourant());
         if (fini) {
             ihm.terminerJeu(joueur);
         } else {
             ihm.changerJoueur(joueur);
         }
    }
    
    public void nouvellePartie(){
        ihm.nouvellePartie();
        morpion.nouvellePartie();
    }
}