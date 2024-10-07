/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

/**
 *
 * @author kor
 */
public class Developpeur extends Personne {

    private Manager gestionnaire;

    public Developpeur(String nom, double salaire) {
        super(nom, salaire);
    }

    public Developpeur(int id, String nom, double salaire) {
        super(id, nom, salaire);

    }

  

    public Personne getGestionnaire() {
        return gestionnaire;
    }

    public void setGestionnaire(Personne gestionnaire) {
        this.gestionnaire = (Manager) gestionnaire;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + super.toString()+"gestionnaire:"+gestionnaire;

    }

}
