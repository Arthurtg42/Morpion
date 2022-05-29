package morpion;

public class Morpion {        
    /*  Numérotation des cases
    **    +---+---+---+
    **    | 0 | 1 | 2 |
    **    +---+---+---+
    **    | 3 | 4 | 5 |
    **    +---+---+---+
    **    | 6 | 7 | 8 |
    **    +---+---+---+
    **  valeur -1 = case innocupée 
    */
    private int casesLibres, joueurCourant;
    private int gagnant; // No joueur ou -1 (pas de gagnant)
    private int [] plateau = new int[9];
    private boolean fini = false;
    
    public Morpion() {
        commencerPartie(0);
    }

    public void commencerPartie(int joueur) {
        joueurCourant = joueur; 
        fini = false;
        
        // Initialise le plateau et l'état du jeu
        gagnant = -1;
        casesLibres = 9;
        for(int i = 0; i < plateau.length; i++) {
            plateau[i] = -1;
        }        
    }

    public int getJoueurCourant() {
         return joueurCourant;
    }
    
    public boolean jouer(int c) {
        casesLibres--;
        plateau[c] = joueurCourant;
        
        if (   ((plateau[0] != -1) && (plateau[0] == plateau[1]) && (plateau[0] == plateau[2]))
            || ((plateau[3] != -1) && (plateau[3] == plateau[4]) && (plateau[3] == plateau[5]))
            || ((plateau[6] != -1) && (plateau[6] == plateau[7]) && (plateau[6] == plateau[8]))
            || ((plateau[0] != -1) && (plateau[0] == plateau[3]) && (plateau[0] == plateau[6]))
            || ((plateau[1] != -1) && (plateau[1] == plateau[4]) && (plateau[1] == plateau[7]))
            || ((plateau[2] != -1) && (plateau[2] == plateau[5]) && (plateau[2] == plateau[8]))
            || ((plateau[0] != -1) && (plateau[0] == plateau[4]) && (plateau[0] == plateau[8]))
            || ((plateau[2] != -1) && (plateau[2] == plateau[4]) && (plateau[2] == plateau[6]))) {
            gagnant = joueurCourant;
        }
        
        fini = ((gagnant >= 0) || (casesLibres == 0));
        
        if (fini) {
            joueurCourant = gagnant;
        } else {            
            joueurCourant = 1 - joueurCourant;            
        }
        
        return fini;
    }
    
    public void nouvellePartie(){
        commencerPartie(0);
    }
}