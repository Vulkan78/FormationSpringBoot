package com.objis.ensup.domaine;

public class Employe {

    private String nom;      // Propriété 'nom'
    private String prenom;

    public Employe(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Employe() {
    }

    public String getNom() {  // Getter pour propri�t� 'nom'
        return nom;
    }

    public void setNom(String nom) { // Setter pour propri�t� 'nom'
        this.nom = nom;
    }

    public String getPrenom() { // Getter pour propri�t� 'prenom'
        return prenom;
    }

    public void setPrenom(String prenom) { // Setter pour propri�t� 'prenom'
        this.prenom = prenom;
    }

    public void poserConges() {
        System.out.println("L'employe " + this.prenom + " " + this.nom + " pose des Conges");
    }
}