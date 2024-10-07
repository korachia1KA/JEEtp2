/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.projet.connexion.Connexion;
import ma.projet.service.ManagerService;

/**
 *
 * @author kor
 */
public class Manager extends Personne {

    private DirecteurGeneral gestionnaire;

    public Manager(String nom, double salaire) {
        super(nom, salaire);
    }

    public Manager(int id, String nom, double salaire) {
        super(id, nom, salaire);
    }

    public Personne getGestionnaire() {
        return gestionnaire;
    }

    public void setGestionnaire(Personne gestionnaire) {
        this.gestionnaire = (DirecteurGeneral) gestionnaire;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + super.toString() + "gestionnaire:" + gestionnaire;

    }

    public void gerer(Personne p) {

        try {
            String req = "update developpeur set  nom = ?, salaire = ? idGestionnaire = ? where id = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, p.getNom());
            ps.setDouble(2, p.getSalaire());
            ps.setInt(3, this.getId());
            ps.setInt(4, p.getId());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void gererD(Manager p) {
        try {
            String req = "update manager set idGestionnaire = ? where id = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, this.getId());
            ps.setInt(1, p.getId());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void gererD(Developpeur p) {

        try {
            String req = "update manager set idGestionnaire = ? where id = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, this.getId());
            ps.setInt(1, p.getId());

            ps.executeUpdate() ;
                
            
        } catch (SQLException ex) {
            Logger.getLogger(ManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

}
