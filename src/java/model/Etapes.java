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
@Table (name="etapes")

public class Etapes implements Serializable{
    
/************************************************
*** NOM DES COLONNES DE NOTRE BASE DE DONNEES ***
************************************************/
    @Column (name="idEtape")
    @Id
    private int idEtape;
    
    @Column (name="nomEtape")
    private String nomEtape;
    
    @Column (name="dateDebutEtape")
    private Date dateDebutEtape;
    
    @Column (name="dateFinEtape")
    private Date dateFinEtape;
    
    @Column (name="montantPrevu")
    private Double montantPrevu;
    
    @Column (name="dureeJourPrevu")
    private int dureeJourPrevu;
    
    @Column (name="checkEtape")
    private boolean checkEtape;
    
    @Column (name="idProjet")
    private int idProjet;

    
    
/************************
*** NOS CONSTRUCTEURS ***
************************/
    public Etapes() {
    }

    public Etapes(int idEtape, String nomEtape, Date dateDebutEtape, Date dateFinEtape, Double montantPrevu, int dureeJourPrevu, boolean checkEtape, int idProjet) {
        this.idEtape = idEtape;
        this.nomEtape = nomEtape;
        this.dateDebutEtape = dateDebutEtape;
        this.dateFinEtape = dateFinEtape;
        this.montantPrevu = montantPrevu;
        this.dureeJourPrevu = dureeJourPrevu;
        this.checkEtape = checkEtape;
        this.idProjet = idProjet;
    }

    


/*****************************
*** NOS GETTERS ET SETTERS ***
*****************************/
    public int getIdEtape() {
        return idEtape;
    }

    public void setIdEtape(int idEtape) {
        this.idEtape = idEtape;
    }

    public String getNomEtape() {
        return nomEtape;
    }

    public void setNomEtape(String nomEtape) {
        this.nomEtape = nomEtape;
    }

    public Double getMontantPrevu() {
        return montantPrevu;
    }

    public void setMontantPrevu(Double montantPrevu) {
        this.montantPrevu = montantPrevu;
    }

    public int getDureeJourPrevu() {
        return dureeJourPrevu;
    }

    public void setDureeJourPrevu(int dureeJourPrevu) {
        this.dureeJourPrevu = dureeJourPrevu;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public Date getDateDebutEtape() {
        return dateDebutEtape;
    }

    public void setDateDebutEtape(Date dateDebutEtape) {
        this.dateDebutEtape = dateDebutEtape;
    }

    public Date getDateFinEtape() {
        return dateFinEtape;
    }

    public void setDateFinEtape(Date dateFinEtape) {
        this.dateFinEtape = dateFinEtape;
    }

    public boolean isCheckEtape() {
        return checkEtape;
    }

    public void setCheckEtape(boolean checkEtape) {
        this.checkEtape = checkEtape;
    }
    
    
    
    
}
