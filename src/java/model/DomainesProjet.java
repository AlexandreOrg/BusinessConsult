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
@Table (name="domainesProjet")

public class DomainesProjet implements Serializable{
    
/************************************************
*** NOM DES COLONNES DE NOTRE BASE DE DONNEES ***
************************************************/
    @Column (name="idDomaine")
    @Id
    private int idDomaine;
    
    @Column (name="libelleDomaine")
    private String libelleDomaine;

    
    
/************************
*** NOS CONSTRUCTEURS ***
************************/
    public DomainesProjet() {
    }

    public DomainesProjet(int idDomaine, String libelleDomaine) {
        this.idDomaine = idDomaine;
        this.libelleDomaine = libelleDomaine;
    }

    
    

    
/*****************************
*** NOS GETTERS ET SETTERS ***
*****************************/
    public int getIdDomaine() {
        return idDomaine;
    }

    public void setIdDomaine(int idDomaine) {
        this.idDomaine = idDomaine;
    }

    public String getLibelleDomaine() {
        return libelleDomaine;
    }

    public void setLibelleDomaine(String libelleDomaine) {
        this.libelleDomaine = libelleDomaine;
    }

    
    
}
