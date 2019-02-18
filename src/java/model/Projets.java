/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author alexa
 */

@Entity
@Table (name="projets")

public class Projets implements Serializable{
    
/************************************************
*** NOM DES COLONNES DE NOTRE BASE DE DONNEES ***
************************************************/
    @Column (name="idProjet")
    @Id
    private int idProjet;
    
    @Column (name="libelleProjet")
    private String libelleProjet;
    
    @Column (name="dateDebutProjet")
    private Date dateDebutProjet;
    
    @Column (name="dateFinProjet")
    private Date dateFinProjet;
    
    @Column (name="idDomaine")
    private int idDomaine;

    
    
/************************
*** NOS CONSTRUCTEURS ***
************************/
    public Projets() {
    }

    public Projets(int idProjet) {
        this.idProjet = idProjet;
    }

    public Projets(String libelleProjet, Date dateDebutProjet, Date dateFinProjet, int idDomaine) {
        this.libelleProjet = libelleProjet;
        this.dateDebutProjet = dateDebutProjet;
        this.dateFinProjet = dateFinProjet;
        this.idDomaine = idDomaine;
    }

    public Projets(int idProjet, String libelleProjet, Date dateDebutProjet, Date dateFinProjet, int idDomaine) {
        this.idProjet = idProjet;
        this.libelleProjet = libelleProjet;
        this.dateDebutProjet = dateDebutProjet;
        this.dateFinProjet = dateFinProjet;
        this.idDomaine = idDomaine;
    }

    

    

/*****************************
*** NOS GETTERS ET SETTERS ***
*****************************/
    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public String getLibelleProjet() {
        return libelleProjet;
    }

    public void setLibelleProjet(String libelleProjet) {
        this.libelleProjet = libelleProjet;
    }

    public Date getDateDebutProjet() {
        return dateDebutProjet;
    }

    public void setDateDebutProjet(Date dateDebutProjet) {
        this.dateDebutProjet = dateDebutProjet;
    }

    public Date getDateFinProjet() {
        return dateFinProjet;
    }

    public void setDateFinProjet(Date dateFinProjet) {
        this.dateFinProjet = dateFinProjet;
    }

    public int getIdDomaine() {
        return idDomaine;
    }

    public void setIdDomaine(int idDomaine) {
        this.idDomaine = idDomaine;
    }

    
    
}
