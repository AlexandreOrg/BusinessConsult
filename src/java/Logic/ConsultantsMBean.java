/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;


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
import model.Consultants;


/**
 *
 * @author alexa
 */
@ManagedBean
@ApplicationScoped

public class ConsultantsMBean implements Serializable{
    
/**************************
*** LIAISON AVEC LA BDD ***
**************************/
    @EJB
    private ConsultantFacade consultantfacade;

    public ConsultantFacade getConsultantfacade() {
        return consultantfacade;
    }

    public void setConsultantfacade(ConsultantFacade consultantfacade) {
        this.consultantfacade = consultantfacade;
    }
    
/************************************
*** NOS DECLARATIONS DE VARIABLES ***
************************************/
    int idConsultant=0;
    String ztNomConsultant;
    String ztPrenomConsultant;
    String ztTelConsultant;
    String ztMailConsultant;
    String ztPassword;
    String ztPasswordConf;
    ArrayList<Consultants> lstConsultants;

    
/*****************************
*** NOS GETTERS ET SETTERS ***
*****************************/
    public int getIdConsultant() {
        return idConsultant;
    }

    public void setIdConsultant(int idConsultant) {
        this.idConsultant = idConsultant;
    }

    public String getZtNomConsultant() {
        return ztNomConsultant;
    }

    public void setZtNomConsultant(String ztNomConsultant) {
        this.ztNomConsultant = ztNomConsultant;
    }

    public String getZtPrenomConsultant() {
        return ztPrenomConsultant;
    }

    public void setZtPrenomConsultant(String ztPrenomConsultant) {
        this.ztPrenomConsultant = ztPrenomConsultant;
    }

    public String getZtTelConsultant() {
        return ztTelConsultant;
    }

    public void setZtTelConsultant(String ztTelConsultant) {
        this.ztTelConsultant = ztTelConsultant;
    }

    public String getZtMailConsultant() {
        return ztMailConsultant;
    }

    public void setZtMailConsultant(String ztMailConsultant) {
        this.ztMailConsultant = ztMailConsultant;
    }

    public String getZtPassword() {
        return ztPassword;
    }

    public void setZtPassword(String ztPassword) {
        this.ztPassword = ztPassword;
    }

    public String getZtPasswordConf() {
        return ztPasswordConf;
    }

    public void setZtPasswordConf(String ztPasswordConf) {
        this.ztPasswordConf = ztPasswordConf;
    }

    public ArrayList<Consultants> getLstConsultants() {
        return lstConsultants;
    }

    public void setLstConsultants(ArrayList<Consultants> lstConsultants) {
        this.lstConsultants = lstConsultants;
    }

    
    
    
/*******************************
*** NOS METHODES / FONCTIONS ***
*******************************/
    
    
//Connexion au site : Login + Mot de passe
    public String validerLogin(){
        Consultants connexionConsultant = new Consultants();

        try{
            connexionConsultant = consultantfacade.findUser(getZtMailConsultant(), getZtPassword());
        } catch(EJBException e){
            e.printStackTrace();
        }
        

        if (connexionConsultant!=null)
        {
            setZtNomConsultant(connexionConsultant.getNomConsultant());
            setZtPrenomConsultant(connexionConsultant.getPrenomConsultant());
            setZtMailConsultant(connexionConsultant.getMailConsultant());
            idConsultant = connexionConsultant.getIdConsultant();
            
            return "accueil?faces-redirect=true";
        }
        else
        {
            System.out.println("Mauvais ID et User");
            FacesMessage messTest = new FacesMessage("Mauvais user et ID");
            FacesContext.getCurrentInstance().addMessage(null, messTest);
            return null;
        }
    } //Fin ValiderLogin
    
    
    public ConsultantsMBean() {
        lstConsultants = new ArrayList<Consultants>();
    }
    
  
//Inscription d'un utilisateur
    public String buttonInscription(){
        
        if ((getZtNomConsultant().isEmpty()) || (getZtPrenomConsultant().isEmpty()) || (getZtTelConsultant().isEmpty()) || (getZtMailConsultant().isEmpty()) || (getZtPassword().isEmpty()) || (getZtPasswordConf().isEmpty()))
        {
            
            FacesMessage messTest = new FacesMessage("Tous les champs doivent être remplis");
            FacesContext.getCurrentInstance().addMessage("form:ztNomConsultant", messTest);
        }
        else
        {
            if (getZtPassword().equals(getZtPasswordConf()))
            {
                
                // APPEL DE LA REQUETE SQL
                Consultants newInscrit = new Consultants();
                newInscrit = consultantfacade.create(getZtNomConsultant(), getZtPrenomConsultant(), getZtTelConsultant(), getZtMailConsultant(), getZtPassword());
                return "index?faces-redirect=true";
            }
            else
            {
                
                FacesMessage messTest = new FacesMessage("Les mots de passe doivent être identiques");
                FacesContext.getCurrentInstance().addMessage(null, messTest);
               
            }
        }
        
        return "inscription?faces?redirect=true";
    }
    
  
//Méthode de modification du profil
    public void validModifProfil(){
        
        if (ztPasswordConf.isEmpty()){
            System.out.println("Erreur");
        }
        else{
            if (ztPasswordConf.equals(ztPassword)){

                    consultantfacade.editerConsultant(getZtNomConsultant(), getZtPrenomConsultant(), getZtTelConsultant(), getZtMailConsultant(), getZtPassword(), idConsultant);
                
            }
            else{
                System.out.println("Erreur");
            }
        }
      
    }
    
    List<Consultants> listConsultants = new ArrayList<Consultants>();

    public List<Consultants> getListConsultants() {
        return listConsultants;
    }

    public void setListConsultants(List<Consultants> listConsultants) {
        this.listConsultants = listConsultants;
    }
    
    //Pour la liste des consultants dans la page statistiques
    public List<Consultants> listeDesChefs(){
       listConsultants = consultantfacade.trouverLesChefsProjet();
       return listConsultants;
   }
    
    public void trouverProjets(){
        ProjetsMBean envoiID = new ProjetsMBean();
        envoiID.setIdDuConsul(getIdConsultant());
    }
     
}
