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
@Table (name="chefsProjet")

public class ChefsProjet implements Serializable{
    
/************************************************
*** NOM DES COLONNES DE NOTRE BASE DE DONNEES ***
************************************************/
    @Column (name="idChefProjet")
    @Id
    private int idChefProjet;
    
    @Column (name="statutChef")
    private String statutChef;
    
    @Column (name="idConsultant")
    private int idConsultant;
    
    @Column (name="idProjet")
    private int idProjet;

    
    
/************************
*** NOS CONSTRUCTEURS ***
************************/
    public ChefsProjet() {
    }

    public ChefsProjet(String statutChef, int idConsultant, int idProjet) {
        this.statutChef = statutChef;
        this.idConsultant = idConsultant;
        this.idProjet = idProjet;
    }

    public ChefsProjet(int idChefProjet, String statutChef, int idConsultant, int idProjet) {
        this.idChefProjet = idChefProjet;
        this.statutChef = statutChef;
        this.idConsultant = idConsultant;
        this.idProjet = idProjet;
    }

    

    
/*****************************
*** NOS GETTERS ET SETTERS ***
*****************************/
    public int getIdChefProjet() {
        return idChefProjet;
    }

    public void setIdChefProjet(int idChefProjet) {
        this.idChefProjet = idChefProjet;
    }

    public String getStatutChef() {
        return statutChef;
    }

    public void setStatutChef(String statutChef) {
        this.statutChef = statutChef;
    }

    public int getIdConsultant() {
        return idConsultant;
    }

    public void setIdConsultant(int idConsultant) {
        this.idConsultant = idConsultant;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    
    
    
}
