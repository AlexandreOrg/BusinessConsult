/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;


import facade.ProjetsFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.ChefsProjet;
import model.Consultants;
import model.DomainesProjet;
import model.Projets;

/**
 *
 * @author alexa
 */

@ManagedBean
@ApplicationScoped

public class ProjetsMBean implements Serializable {
    
/**************************
*** LIAISON AVEC LA BDD ***
**************************/
    @EJB
    private ProjetsFacade pf;

    public ProjetsFacade getPf() {
        return pf;
    }

    public void setPf(ProjetsFacade pf) {
        this.pf = pf;
    }
    
    
/************************************
*** NOS DECLARATIONS DE VARIABLES ***
************************************/
    String mailConsultant;
    int idConsultant;
    String ztNomDuProjet;
    Date ztDateDeDebut;
    Date ztDateDeFin;
    int idProjet;
    int idChef;
    String nbrVr="0";
    int idChefSelect;
    int idDomaine;
    String statutChef;
    Consultants user1 = new Consultants();
    List<Projets> lstProjets = new ArrayList<Projets>();
    ArrayList<Consultants> lstRecup;
    List<Projets> lstProjetsTest;
    List<Projets> lstProjetsParChef = new ArrayList<Projets>();
    List<ChefsProjet> listChefs = new ArrayList<ChefsProjet>();

    

/*****************************
*** NOS GETTERS ET SETTERS ***
*****************************/
    public int getIdChef() {
        return idChef;
    }
    public void setIdChef(int idChef) {
        this.idChef = idChef;
    }
    public String getMailConsultant() {
        return mailConsultant;
    }
    public void setMailConsultant(String mailConsultant) {
        this.mailConsultant = mailConsultant;
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
    public String getZtNomDuProjet() {
        return ztNomDuProjet;
    }
    public void setZtNomDuProjet(String ztNomDuProjet) {
        this.ztNomDuProjet = ztNomDuProjet;
    }
    public Date getZtDateDeDebut() {
        return ztDateDeDebut;
    }
    public void setZtDateDeDebut(Date ztDateDeDebut) {
        this.ztDateDeDebut = ztDateDeDebut;
    }
    public Date getZtDateDeFin() {
        return ztDateDeFin;
    }
    public void setZtDateDeFin(Date ztDateDeFin) {
        this.ztDateDeFin = ztDateDeFin;
    }
    public List<Projets> getLstProjets() {
        return lstProjets;
    }
    public void setLstProjets(List<Projets> lstProjets) {
        this.lstProjets = lstProjets;
    }
    public ArrayList<Consultants> getLstRecup() {
        return lstRecup;
    }
    public void setLstRecup(ArrayList<Consultants> lstRecup) {
        this.lstRecup = lstRecup;
    }
    public String getNbrVr() {
        return nbrVr;
    }
    public void setNbrVr(String nbrVr) {
        this.nbrVr = nbrVr;
    }
    public List<Projets> getLstProjetsTest() {
        return lstProjetsTest;
    }
    public void setLstProjetsTest(List<Projets> lstProjetsTest) {
        this.lstProjetsTest = lstProjetsTest;
    }
    public Consultants getUser1() {
        return user1;
    }
    public void setUser1(Consultants user1) {
        this.user1 = user1;
    }
    public List<Projets> getLstProjetsParChef() {
        return lstProjetsParChef;
    }
    public void setLstProjetsParChef(List<Projets> lstProjetsParChef) {
        this.lstProjetsParChef = lstProjetsParChef;
    }
    public List<ChefsProjet> getListChefs() {
        return listChefs;
    }
    public void setListChefs(List<ChefsProjet> listChefs) {
        this.listChefs = listChefs;
    }
    public int getIdDomaine() {
        return idDomaine;
    }
    public void setIdDomaine(int idDomaine) {
        this.idDomaine = idDomaine;
    }

    public String getStatutChef() {
        return statutChef;
    }

    public void setStatutChef(String statutChef) {
        this.statutChef = statutChef;
    }
    
    
/*******************************
*** NOS METHODES / FONCTIONS ***
*******************************/

//**************************************** PAGE D'ACCUEIL ****************************************
//Méthode pour trouver les projets en fonctions du consultant
    public List<Projets> afficher(){
        String login = getMailConsultant();
        //On récupère d'abord l'ID du consultant
        idConsultant = pf.idDuConsultant(login);
        System.out.println(idConsultant);
        //Grâce à cet id récupéré, on vient chercher les projets
        lstProjets = pf.lesProjetsUser(idConsultant);
       return lstProjets;       
    }

//**************************************** PAGE AJOUT PROJET ****************************************
//Aller sur la page pour ajouter un nouveau projet
   public String ajoutProjet(){
       setZtNomDuProjet("");
       setZtDateDeDebut(null);
       setZtDateDeFin(null);
       return "ajoutProjet?faces-redirect=true";
   }
   
//Ajout du nouveau projet
   public void nouveauProjet(){
       
       //Insertion du nouveau projet dans la base de données
       String statutChef = "Chef de Projet";
       String nomProjet = getZtNomDuProjet();
       Date debutProjet = getZtDateDeDebut();
       Date finProjet = getZtDateDeFin();
       //idConsultant;
       
    //OK   
       //Insertion du nouveau projet
       Projets nouveauProjet = new Projets();
       nouveauProjet = pf.insertNouveauProjet(getZtNomDuProjet(), getZtDateDeDebut(), getZtDateDeFin(), idDomaine);
    //OK   
       //Récupérer l'id du dernier projet saisi
       int idDuProjetSaisi = pf.recuperationDernierId();

       //Saisie du chef de projet
       ChefsProjetMBean saisieParNouveauProjet = new ChefsProjetMBean();
       saisieParNouveauProjet.newChefsProjet(statutChef, idConsultant, idDuProjetSaisi);
       //saisieParNouveauProjet.newChefsProjet(statutChef, idConsultant, 4);
       
       
   }
   
   
   
//**************************************** PAGE DE MODIFICATION PROJET ****************************************
//Méthode de modification d'un projet
   public String modificationProjet(){
       Projets editProjet = new Projets();
            editProjet.setIdProjet(getIdProjet());
            editProjet.setLibelleProjet(getZtNomDuProjet());
            editProjet.setDateDebutProjet(getZtDateDeDebut());
            editProjet.setDateFinProjet(getZtDateDeFin());
            editProjet.setIdDomaine(idDomaine);
            pf.edit(editProjet);
       
        return "accueil?faces-redirect=true";
       
   }
   
   
   
   
   
   
   
//Retourne la valeur du nombre de vrai pour connaître le pourcentage
    public String pourcent(){
        return nbrVr;
    }
        
//Méthode de déconnexion
   public void deconnexion(){
       Consultants viderVariable = new Consultants();
       viderVariable.setMailConsultant(null);  
   }


   
   
//Méthode pour récuérer les projets en fonction du chef
    public List<Projets> trouverProjets(){ 

        
        ConsultantsMBean recupIdConsult = new ConsultantsMBean();
        recupIdConsult.trouverProjets();
        System.out.println("Tentative : " + idDuConsul);
        System.out.println("Tentative : " + getIdDuConsul());
        lstProjetsParChef = pf.lesProjetsChef();

        return lstProjetsParChef;
    }
    
    
    int idDuConsul;
    public int getIdDuConsul() {
        return idDuConsul;
    }

    public void setIdDuConsul(int idDuConsul) {
        this.idDuConsul = idDuConsul;
    }
}
