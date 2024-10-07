/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import ma.projet.beans.Developpeur;
import ma.projet.beans.DirecteurGeneral;
import ma.projet.beans.Manager;
import ma.projet.service.DeveloppeurService;
import ma.projet.service.ManagerService;

/**
 *
 * @author kor
 */
public class Entreprise {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        DeveloppeurService ds = new DeveloppeurService();
        ManagerService ms = new ManagerService();
        // Créer des développeurs
        Developpeur developpeur1 = new Developpeur("NOUARI", 8000);
        Developpeur developpeur2 = new Developpeur("NOUARI", 8500);
        ds.create(developpeur1);
        ds.create(developpeur1);
        // Créer un manager
        Manager manager = new Manager("SADDIK", 9000);
        ms.create(manager);
        manager.gerer(developpeur1);
        manager.gerer(developpeur2);
        // Créer un 3ème développeur
        Developpeur developpeur3 = new Developpeur("NOUARI", 8900);
        ds.create(developpeur3);
        // Créer un directeur général
        Manager dg = new DirecteurGeneral("RAMI", 9800);
        ms.create(dg, true);
        dg.gererD(manager);
        dg.gerer(developpeur3);

        //affichage
        System.out.println(ds.getAll());
        System.out.println(ms.getAll());

    }

}
