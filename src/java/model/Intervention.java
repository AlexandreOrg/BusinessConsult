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
@Table (name="intervention")

public class Intervention implements Serializable{
    
/************************************************
*** NOM DES COLONNES DE NOTRE BASE DE DONNEES ***
************************************************/
    @Column (name="idIntervention")
    @Id
    private int idIntervention;
    
    @Column (name="dureeHeure")
    private int dureeHeure;
    
    @Column (name="dateDebutIntervention")
    private Date dateDebutIntervention;
    
    @Column (name="dateFinIntervention")
    private Date dateFinIntervention;
    
    @Column (name="idProjet")
    private int idProjet;
    
    @Column (name="idConsultant")
    private int idConsultant;

    
    
/************************
*** NOS CONSTRUCTEURS ***
************************/
    public Intervention() {
    }

    public Intervention(int idIntervention, int dureeHeure, Date dateDebutIntervention, Date dateFinIntervention, int idProjet, int idConsultant) {
        this.idIntervention = idIntervention;
        this.dureeHeure = dureeHeure;
        this.dateDebutIntervention = dateDebutIntervention;
        this.dateFinIntervention = dateFinIntervention;
        this.idProjet = idProjet;
        this.idConsultant = idConsultant;
    }

    

    

/*****************************
*** NOS GETTERS ET SETTERS ***
*****************************/
    public int getIdIntervention() {
        return idIntervention;
    }

    public void setIdIntervention(int idIntervention) {
        this.idIntervention = idIntervention;
    }

    public int getDureeHeure() {
        return dureeHeure;
    }

    public void setDureeHeure(int dureeHeure) {
        this.dureeHeure = dureeHeure;
    }

    public Date getDateDebutIntervention() {
        return dateDebutIntervention;
    }

    public void setDateDebutIntervention(Date dateDebutIntervention) {
        this.dateDebutIntervention = dateDebutIntervention;
    }

    public Date getDateFinIntervention() {
        return dateFinIntervention;
    }

    public void setDateFinIntervention(Date dateFinIntervention) {
        this.dateFinIntervention = dateFinIntervention;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public int getIdConsultant() {
        return idConsultant;
    }

    public void setIdConsultant(int idConsultant) {
        this.idConsultant = idConsultant;
    }

    
    
}
