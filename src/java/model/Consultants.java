/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author alexa
 */

@Entity
@Table (name="consultants")

public class Consultants implements Serializable{
    
/************************************************
*** NOM DES COLONNES DE NOTRE BASE DE DONNEES ***
************************************************/
    @Column (name="idConsultant")
    @Id
    private int idConsultant;
    
    @Column (name="nomConsultant")
    private String nomConsultant;
    
    @Column (name="prenomConsultant")
    private String prenomConsultant;
    
    @Column (name="telConsultant")
    private String telConsultant;
    
    @Column (name="mailConsultant")
    private String mailConsultant;
    
    @Column (name="passConsultant")
    private String passConsultant;

    
    
    
/************************
*** NOS CONSTRUCTEURS ***
************************/
    public Consultants() {
    }

    public Consultants(int idConsultant, String nomConsultant, String prenomConsultant, String telConsultant, String mailConsultant, String passConsultant) {
        this.idConsultant = idConsultant;
        this.nomConsultant = nomConsultant;
        this.prenomConsultant = prenomConsultant;
        this.telConsultant = telConsultant;
        this.mailConsultant = mailConsultant;
        this.passConsultant = passConsultant;
    }

    
    
    
/*****************************
*** NOS GETTERS ET SETTERS ***
*****************************/
    public int getIdConsultant() {
        return idConsultant;
    }

    public void setIdConsultant(int idConsultant) {
        this.idConsultant = idConsultant;
    }

    public String getNomConsultant() {
        return nomConsultant;
    }

    public void setNomConsultant(String nomConsultant) {
        this.nomConsultant = nomConsultant;
    }

    public String getPrenomConsultant() {
        return prenomConsultant;
    }

    public void setPrenomConsultant(String prenomConsultant) {
        this.prenomConsultant = prenomConsultant;
    }

    public String getTelConsultant() {
        return telConsultant;
    }

    public void setTelConsultant(String telConsultant) {
        this.telConsultant = telConsultant;
    }

    public String getMailConsultant() {
        return mailConsultant;
    }

    public void setMailConsultant(String mailConsultant) {
        this.mailConsultant = mailConsultant;
    }

    public String getPassConsultant() {
        return passConsultant;
    }

    public void setPassConsultant(String passConsultant) {
        this.passConsultant = passConsultant;
    }
    
    
    
}
