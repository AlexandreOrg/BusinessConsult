/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;


import facade.ChefsProjetFacade;
import facade.ConsultantFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.ChefsProjet;
import model.Consultants;


/**
 *
 * @author alexa
 */
@ManagedBean
@ApplicationScoped

public class ChefsProjetMBean implements Serializable{
    
/**************************
*** LIAISON AVEC LA BDD ***
**************************/
    @EJB
    private ChefsProjetFacade cpf;

    public ChefsProjetFacade getCpf() {
        return cpf;
    }

    public void setCpf(ChefsProjetFacade cpf) {
        this.cpf = cpf;
    }

    
    
/************************************
*** NOS DECLARATIONS DE VARIABLES ***
************************************/
    int idChefProjet;
    String statutChef;
    int idConsultant;
    int idProjet;


    
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


    
    
    
/*******************************
*** NOS METHODES / FONCTIONS ***
     * @param statutChef
     * @param idConsultant
     * @param idProjet
*******************************/
    
//**************************** PAGE AJOUT D'UN PROJET ****************************
//Pour l'ajout d'un nouveau projet, on vient saisir le chef du projet
    public void newChefsProjet(String statutChef, int idConsultant, int idProjet){
        
        System.out.println("new statut : " + statutChef);
        System.out.println("new idCon : " + idConsultant);
        System.out.println("new idProj : " + idProjet);
        //ChefsProjetFacade essai = new ChefsProjetFacade();
        //essai.insertChef(statutChef, idConsultant, idProjet);
        cpf.insertChef(statutChef, idConsultant, idProjet);
        //On appelle directement la requête SQL
        //ChefsProjet nouveauChef = new ChefsProjet();
        //nouveauChef = 
        try{
            //ChefsProjet nouveauChef = new ChefsProjet();
            //List<ChefsProjet> nouveauChef = new ArrayList();
            //nouveauChef = cpf.insertChef(statutChef, idConsultant, idProjet);
            //nouveauChef = 
                    //cpf.test();
        }catch(NullPointerException en){
            System.out.println("snif");
            en.printStackTrace();
        }
    }
    
    
    List<ChefsProjet> listeDesChefs = new ArrayList<ChefsProjet>();

    public List<ChefsProjet> getListeDesChefs() {
        return listeDesChefs;
    }

    public void setListeDesChefs(List<ChefsProjet> listeDesChefs) {
        this.listeDesChefs = listeDesChefs;
    }
    
    
    
}
