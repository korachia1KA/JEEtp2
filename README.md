README - Système de Messagerie
Introduction
Ce projet développe un système de messagerie pour une société, permettant aux employés d'échanger des messages. Le système utilise une base de données MySQL et Java pour la gestion des données.

Prérequis
MySQL
Java JDK
JDBC Driver pour MySQL
IDE (comme Eclipse ou IntelliJ)
Installation
Créer la base de données : Exécutez les scripts SQL suivants pour créer les tables nécessaires :

CREATE TABLE IF NOT EXISTS `employe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=5;

CREATE TABLE IF NOT EXISTS `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `objet` varchar(50) NOT NULL,
  `sujet` varchar(500) NOT NULL,
  `date` date NOT NULL,
  `idE` int(11) NOT NULL,
  `idR` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idE` (`idE`,`idR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=18;
Ajoutez les clés étrangères nécessaires après la création des tables.

Configurer la connexion à la base de données : Créez un fichier base.properties à la racine du projet avec les informations suivantes :



jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost/messagerie
jdbc.username=root
jdbc.password=root
Structure du projet : Le projet doit contenir les packages suivants :

ma.projet.connexion : pour la classe de connexion à la base de données.
ma.projet.beans : pour les classes Employe et Message.
ma.projet.dao : pour l'interface IDao et les classes de service EmployeService et MessageService.
ma.projet.test : pour les tests CRUD.
Classes et Méthodes
Classe Connexion : Gère la connexion à la base de données.
Classe Employe : Représente un employé avec des attributs id, nom et prenom.
Classe Message : Représente un message avec des attributs id, objet, sujet, date, emetteur, et recepteur.
Interface IDao : Définit les méthodes CRUD de base.
Classes de service (EmployeService et MessageService) : Implémentent les méthodes de l'interface IDao.
Tests
Dans le package ma.projet.test, une classe de test crée trois employés et envoie des messages entre eux. Voici un extrait du code de test :

EmployeService es = new EmployeService();
es.create(new Employe("LACHGAR", "Mohamed"));
es.create(new Employe("RAMI", "ALI"));
es.create(new Employe("SAFI", "Fatima"));

MessageService ms = new MessageService();
ms.create(new Message("Réunion", "Réunion de fin d'année", new Date(), es.getById(1), es.getById(2)));
ms.create(new Message("Stage", "Stage à Marrakech", new Date(), es.getById(2), es.getById(3)));
Exécution
Compilez et exécutez la classe de test pour voir le système en action. Les messages envoyés et reçus par chaque employé seront affichés dans la console.

Conclusion
Ce projet offre une base solide pour un système de messagerie entre employés. Il peut être étendu pour inclure des fonctionnalités supplémentaires comme la gestion des fichiers joints, les notifications, etc.
-________________________________________________________________________________________________ Gestion des Employés_________________________________________________________________________________
Introduction
Ce projet implémente un système de gestion des employés d'une petite entreprise, représentant une hiérarchie simple avec un directeur général, un manager et plusieurs développeurs. Il permet d'afficher les noms et salaires des employés de haut en bas de la hiérarchie.

Prérequis
MySQL
Java JDK
JDBC Driver pour MySQL
IDE (comme Eclipse ou IntelliJ)
Installation
Créer la base de données : Exécutez les scripts SQL suivants pour créer les tables nécessaires :

CREATE TABLE IF NOT EXISTS `manager` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `nom` VARCHAR(50) NOT NULL,
  `salaire` DOUBLE NOT NULL,
  `isDirectorGeneral` BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS `developpeur` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `nom` VARCHAR(50) NOT NULL,
  `salaire` DOUBLE NOT NULL,
  `idGestionnaire` INT,
  FOREIGN KEY (idGestionnaire) REFERENCES manager(id)
);
Configurer la connexion à la base de données : Créez un fichier base.properties à la racine du projet avec les informations suivantes :


jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost/entreprise
jdbc.username=root
jdbc.password=root
Structure du projet : Le projet doit contenir les packages suivants :

ma.projet.connexion : pour la classe de connexion à la base de données.
ma.projet.beans : pour les classes Personne, Manager, Developpeur, et DirecteurGeneral.
ma.projet.dao : pour l'interface IDao.
ma.projet.service : pour les classes ManagerService et DeveloppeurService.
ma.projet.test : pour la classe Entreprise.
Classes et Méthodes
Classe Connexion : Gère la connexion à la base de données.
Classe Personne : Classe mère pour les employés.
Classe Manager : Hérite de Personne et gère les développeurs.
Classe Developpeur : Hérite de Personne et représente un développeur.
Classe DirecteurGeneral : Hérite de Manager et représente le directeur général.
Interface IDao : Définit les méthodes CRUD de base.
Classes de service (ManagerService et DeveloppeurService) : Implémentent les méthodes de l'interface IDao.
Exécution
Créer des employés : Utilisez la classe Entreprise pour créer des instances de Developpeur, Manager, et DirecteurGeneral, en les reliant selon la hiérarchie.
Afficher les employés : Le système affiche les noms et salaires des employés en fonction de leur niveau dans la hiérarchie.
Extrait de code (Classe Entreprise)


public class Entreprise {
    public static void main(String[] args) {
        DeveloppeurService ds = new DeveloppeurService();
        ManagerService ms = new ManagerService();

        // Créer des développeurs
        Developpeur developpeur1 = new Developpeur("NOUARI", 8000);
        Developpeur developpeur2 = new Developpeur("SEBIHI", 8500);
        ds.create(developpeur1);
        ds.create(developpeur2);

        // Créer un manager
        Manager manager = new Manager("SADDIK", 9000);
        ms.create(manager);
        manager.gerer(developpeur1);
        manager.gerer(developpeur2);

        // Créer un directeur général
        DirecteurGeneral dg = new DirecteurGeneral("RAMI", 9800);
        ms.create(dg, true);
        dg.gererD(manager);

        // Afficher les employés
        System.out.println(ds.getAll());
        System.out.println(ms.getAll());
    }
}
Conclusion
Ce projet fournit une solution simple pour gérer la hiérarchie des employés dans une entreprise. Il peut être étendu avec des fonctionnalités supplémentaires telles que la gestion des performances, des promotions, et une interface graphique
partie 2
Introduction
Ce projet inclut une interface graphique utilisant JTree pour afficher la hiérarchie des employés d'une entreprise. Cela permet aux utilisateurs de visualiser facilement les relations entre le directeur général, les managers et les développeurs.

Prérequis
Java JDK
IDE (comme Eclipse ou IntelliJ)
Installation
Clonez le projet :


Importez le projet dans votre IDE.

Configurez la connexion à la base de données (voir section précédente sur la configuration).

Utilisation de JTree
L'utilisation de JTree dans ce projet permet de représenter visuellement la hiérarchie des employés.

Structure de JTree
L'arborescence JTree est configurée pour afficher les employés comme suit :

Entreprise
RAMI (Directeur Général)
SADDIK (Manager)
NOUARI (Développeur)
SEBIHI (Développeur)
AMALI (Développeur)
Implémentation
Classe CouchePresentation :

Cette classe contient la logique pour afficher le JTree.
Lorsqu'un utilisateur clique sur un nœud dans le JTree, la liste des employés sous ce nœud est affichée.
