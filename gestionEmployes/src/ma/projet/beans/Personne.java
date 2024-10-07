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
public class Personne {

    int id;
    private String nom;
    private double salaire;

    public Personne(String nom, double salaire) {
        this.nom = nom;
        this.salaire = salaire;
    }

    public Personne(int id, String nom, double salaire) {
        this.id = id;
        this.nom = nom;
        this.salaire = salaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return "{" + "id=" + id + ", nom=" + nom + ", salaire=" + salaire + '}';
    }
    

}
