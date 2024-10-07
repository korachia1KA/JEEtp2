/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import ma.projet.beans.Employe;
import ma.projet.beans.Message;
import ma.projet.service.EmployeService;
import ma.projet.service.MessageService;

/**
 *
 * @author kor
 */
public class Messagerie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EmployeService es = new EmployeService();
       //Création des employes
        es.create(new Employe("LACHGAR", "Mohamed"));
        es.create(new Employe("RAMI", "ALI"));
        es.create(new Employe("SAFI", "Fatima"));
        //Modification d'un employe
        Employe e = es.getById(3);
        if (e != null) {
            e.setNom("ALAOUI");
            e.setPrenom("Manale");
            es.update(e);
        }
        //Suppression d'un employe
        //Liste des employes
        for (Employe emp : es.getAll()) {
            System.out.println("" + emp.getNom());
        }
        //Teste Message
        MessageService ms = new MessageService();
        ms.create(new Message("Réunion", "Réunion de fin d'année", new Date(),
                es.getById(1), es.getById(2)));
        ms.create(new Message("Réunion", "Réunion de fin d'année", new Date(),
                es.getById(1), es.getById(3)));
        ms.create(new Message("Stage", "Stage à Marrakech", new Date(),
                es.getById(2), es.getById(1)));
        ms.create(new Message("Stage", "Stage à Marrakech", new Date(),
                es.getById(2), es.getById(3)));
        for (Message m : ms.getAll()) {
            if (m.getEmpRecepteur().getId() == 3) {
                System.out.println("" + m.getSujet());
            }
        }

    }
}
