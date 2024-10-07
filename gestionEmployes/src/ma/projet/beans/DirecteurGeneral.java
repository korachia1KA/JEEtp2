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
public class DirecteurGeneral extends Manager {

    public DirecteurGeneral(String nom, double salaire) {
        super(nom, salaire);
    }

    public DirecteurGeneral(int id, String nom, double salaire) {
        super(id, nom, salaire);
    }
     @Override
    public String toString(){
        return  super.toString();
    
    }
    
     

}
