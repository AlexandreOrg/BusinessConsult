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
@Table (name="facture")

public class Facture implements Serializable{
    
/************************************************
*** NOM DES COLONNES DE NOTRE BASE DE DONNEES ***
************************************************/
    @Column (name="numeroFacture")
    @Id
    private int numeroFacture;
    
    @Column (name="montantFacture")
    private Double montantFacture;
    
    @Column (name="dateFacture")
    private Date dateFacture;
    
    @Column (name="idProjet")
    private int idProjet;

    
    
/************************
*** NOS CONSTRUCTEURS ***
************************/
    public Facture() {
    }

    public Facture(int numeroFacture, Double montantFacture, Date dateFacture, int idProjet) {
        this.numeroFacture = numeroFacture;
        this.montantFacture = montantFacture;
        this.dateFacture = dateFacture;
        this.idProjet = idProjet;
    }

    

/*****************************
*** NOS GETTERS ET SETTERS ***
*****************************/
    public int getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(int numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public Double getMontantFacture() {
        return montantFacture;
    }

    public void setMontantFacture(Double montantFacture) {
        this.montantFacture = montantFacture;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    
    
}
