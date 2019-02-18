
package Logic;

import facade.EtapesFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.Etapes;


@ManagedBean
@ApplicationScoped
public class EtapesMBean implements Serializable {
    
//*************************
//***** LES VARIABLES *****
//*************************
    @EJB
    private EtapesFacade etapesfacade;
    private boolean cocheCreationMCD;
    private boolean cocheCreationMODOP;
    int idProjet;
    double valeurBarreProgress=0;
    String resultPourBarreProgress="0";
    String maValeur = "0";
    //Mettre les valeurs supplémentaires pour les prix
    double prix;
    int nbHr;
    List<Etapes> lstPourPdf;
    double chiffreTotal;
    List<Etapes> lstVerif = new ArrayList();
    String nomEtape;
    boolean checkEtape;
    int NbrTotal = 0;
    int nbrVrai = 0;
    private boolean boolNewEtape;
    int index;
    boolean boolle;
    String couleur="";
    boolean valeureBooleene;
    int idEtape;
    String ztNomEtape;
    Date ztDateDebutEtape;
    Date ztDateFinEtape;
    double montantPrevu;
    int dureeJourPrevu;
    List<Etapes> lesEtapes = new ArrayList<Etapes>();

    
//**********************************
//***** LES GETTERS ET SETTERS *****
//**********************************
    public EtapesMBean() {
    }
    public boolean isCocheCreationMCD() {
        return cocheCreationMCD;
    }
    public void setCocheCreationMCD(boolean cocheCreationMCD) {
        this.cocheCreationMCD = cocheCreationMCD;
    }
    public boolean isCocheCreationMODOP() {
        return cocheCreationMODOP;
    }
    public void setCocheCreationMODOP(boolean cocheCreationMODOP) {
        this.cocheCreationMODOP = cocheCreationMODOP;
    }
    public EtapesFacade getEtapesfacade() {
        return etapesfacade;
    }
    public void setEtapesfacade(EtapesFacade etapesfacade) {
        this.etapesfacade = etapesfacade;
    }
    public int getIdProjet() {
        return idProjet;
    }
    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }
    public String getResultPourBarreProgress() {
        return resultPourBarreProgress;
    }
    public void setResultPourBarreProgress(String resultPourBarreProgress) {
        this.resultPourBarreProgress = resultPourBarreProgress;
    }
    public double getValeurBarreProgress() {
        return valeurBarreProgress;
    }
    public void setValeurBarreProgress(double valeurBarreProgress) {
        this.valeurBarreProgress = valeurBarreProgress;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public int getNbHr() {
        return nbHr;
    }
    public void setNbHr(int nbHr) {
        this.nbHr = nbHr;
    }
    public String getMaValeur() {
        return maValeur;
    }
    public void setMaValeur(String maValeur) {
        this.maValeur = maValeur;
    }
    public List<Etapes> getLstPourPdf() {
        return lstPourPdf;
    }
    public void setLstPourPdf(List<Etapes> lstPourPdf) {
        this.lstPourPdf = lstPourPdf;
    }
    public double getChiffreTotal() {
        return chiffreTotal;
    }
    public void setChiffreTotal(double chiffreTotal) {
        this.chiffreTotal = chiffreTotal;
    }
    public List<Etapes> getLstVerif() {
        return lstVerif;
    }
    public void setLstVerif(List<Etapes> lstVerif) {
        this.lstVerif = lstVerif;
    }
    public String getNomEtape() {
        return nomEtape;
    }
    public void setNomEtape(String nomEtape) {
        this.nomEtape = nomEtape;
    }
    public boolean isCheckEtape() {
        return checkEtape;
    }
    public void setCheckEtape(boolean checkEtape) {
        this.checkEtape = checkEtape;
    }
    public int getNbrTotal() {
        return NbrTotal;
    }
    public void setNbrTotal(int NbrTotal) {
        this.NbrTotal = NbrTotal;
    }
    public int getNbrVrai() {
        return nbrVrai;
    }
    public void setNbrVrai(int nbrVrai) {
        this.nbrVrai = nbrVrai;
    }
    public boolean isBoolNewEtape() {
        return boolNewEtape;
    }
    public void setBoolNewEtape(boolean boolNewEtape) {
        this.boolNewEtape = boolNewEtape;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public boolean isBoolle() {
        return boolle;
    }
    public void setBoolle(boolean boolle) {
        this.boolle = boolle;
    }
    public String getCouleur() {
        return couleur;
    }
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
    public boolean isValeureBooleene() {
        return valeureBooleene;
    }
    public void setValeureBooleene(boolean valeureBooleene) {
        this.valeureBooleene = valeureBooleene;
    }
    public int getIdEtape() {
        return idEtape;
    }
    public void setIdEtape(int idEtape) {
        this.idEtape = idEtape;
    }
    public String getZtNomEtape() {
        return ztNomEtape;
    }
    public void setZtNomEtape(String ztNomEtape) {
        this.ztNomEtape = ztNomEtape;
    }
    public Date getZtDateDebutEtape() {
        return ztDateDebutEtape;
    }
    public void setZtDateDebutEtape(Date ztDateDebutEtape) {
        this.ztDateDebutEtape = ztDateDebutEtape;
    }
    public Date getZtDateFinEtape() {
        return ztDateFinEtape;
    }
    public void setZtDateFinEtape(Date ztDateFinEtape) {
        this.ztDateFinEtape = ztDateFinEtape;
    }
    public double getMontantPrevu() {
        return montantPrevu;
    }
    public void setMontantPrevu(double montantPrevu) {
        this.montantPrevu = montantPrevu;
    }
    public int getDureeJourPrevu() {
        return dureeJourPrevu;
    }
    public void setDureeJourPrevu(int dureeJourPrevu) {
        this.dureeJourPrevu = dureeJourPrevu;
    }
    public List<Etapes> getLesEtapes() {
        return lesEtapes;
    }
    public void setLesEtapes(List<Etapes> lesEtapes) {
        this.lesEtapes = lesEtapes;
    }
    
    
//*************************************
//***** LES METHODES ET FONCTIONS *****
//*************************************
    
//Mise à jour des checkBox dans la base de données après l'appui sur le bouton
    public void miseAJourCheckBox(){
        boolean boobool = isCheckEtape();
        boolean test = isCheckEtape();
        etapesfacade.miseAJCheckBox(nomEtape, idProjet, boolNewEtape);
        this.leNomEtape();
        this.verifDejaCoche();
    }
    
//Désigne la valeur de la barre de progression et coche les CheckBox vraies
    public String verifDejaCoche(){

        try{
            //Récupération des valeurs pour calculer la barre de progression
            //Récupération du nombre d'étape en fonction de l'ID du projet
            Object nbr = etapesfacade.countNbrEtapes(idProjet);
            
            //Transformation de l'ID objet en ID Long
            Long NbrTotal = (Long) nbr;
            
            //Récupération du nombre d'étape du projet effectué
            Long nbrVrai = etapesfacade.trouverLesTrueEtFalse(idProjet);
            
            //Récupération de la liste des étapes
            lstVerif = etapesfacade.findAllEtapeDuProjet(idProjet);
            for(int i=0; i<lstVerif.size(); i++)
            {
                System.out.println("Test : " + lstVerif.get(i).isCheckEtape());
                //if(lstVerif.get(i).getIdProjet()==idProjet){
                    System.out.println("Nom de l'étape : " + lstVerif.get(i).getNomEtape());
                    System.out.println("Valeur de l'étape : " + lstVerif.get(i).isCheckEtape());
                    
                    //Si nom de l'étape = 
                    if(lstVerif.get(i).isCheckEtape()==true){
                        boolNewEtape = true;
                                        
                    }
                    else{
                        boolNewEtape = false;
                                        
                    }
                    
                 /*   switch (lstVerif.get(i).getNomEtape()){
                        case 3: 
                            if(lstVerif.get(i).isCheckEtape()==true){
                                setCocheCreationMCD(true);
                                                break;
                            }
                            else{
                                setCocheCreationMCD(false);
                                                break;
                            }

                        case 4: 
                            if(lstVerif.get(i).isCheckEtape()==true){
                                setCocheCreationMODOP(true);
                                                break;
                            }
                            else{
                                setCocheCreationMODOP(false);
                                                break;
                            }

                    }//Fin Switch*/
                //}//Fin If
                //else{
                  //  setCocheCreationMCD(false);
                    //setCocheCreationMODOP(false);
                //}
            }//Fin For
            
            if (nbrVrai!=0){
                valeurBarreProgress = 100/(NbrTotal/nbrVrai);
            }
            else{
                valeurBarreProgress=0;
            }
            
            setMaValeur(String.valueOf(valeurBarreProgress));
            lstVerif.clear();
            
            return "recapProjet?faces-redirect=true";
            
        }catch(EJBException e){
            System.out.println("Exception de création de liste Etapes");
            return null;
        }
      
    }
    
//Méthode pour la liste des étapes
//Pour afficher la liste complète sur le PDF
    public List<Etapes> tabDesEtapes(){
        lstPourPdf = etapesfacade.lstPourLesPDF(idProjet);
        return lstPourPdf;
    }

//Après la création de la liste pour PDF
//Pour afficher le total à facturer sur le PDF
    public double sumTotaux(){
        chiffreTotal=0.0;
        for(int i=0; i<lstPourPdf.size(); i++){
            double chiffreAjout = lstPourPdf.get(i).getMontantPrevu() * lstPourPdf.get(i).getDureeJourPrevu();
            chiffreTotal = chiffreTotal + chiffreAjout;
        }
        return chiffreTotal;
    }
    
//Méthode de sélection si nouvelle étape effectuée ou non
    public void addMessageNewEtape() {
        String summary = boolNewEtape ? "Checked" : "Unchecked";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }
    
    
    public String testModifCheck(){
            
        //Mettre ça dans ajax listener
        //Récupérer l'id de l'étape et modifier la valeur booleenne
        idEtape = getIdEtape();
        //System.out.println("Etape id : " + idEtape);
        
        //Maintenant, requête SQL pour modifier la valeur booléenne
        //On recherche dans la liste déjà créée la valeure actuelle
        for (int i=0; i<lesEtapes.size(); i++){
            if(lesEtapes.get(i).getIdEtape()==idEtape){
                System.out.println("Valeur avant de refaire la liste : " + lesEtapes.get(i).isCheckEtape());
                valeureBooleene = lesEtapes.get(i).isCheckEtape();
                //System.out.println(valeureBooleene);
                if(valeureBooleene==false){
                    valeureBooleene=true;
                    couleur = "success";
                    
                }
                else
                {
                    valeureBooleene=false;
                    couleur = "danger";
                }
                lesEtapes.get(i).setCheckEtape(valeureBooleene);
                System.out.println("New valeur dans liste : " + lesEtapes.get(i).isCheckEtape());
            }
        }
        
        //On arrive à la récupérer. Maintenant on inverse la valeur pour avoir celle à insérer :
        
        System.out.println("New valeur : " + valeureBooleene);
        System.out.println("Sortie");
        
        //Valeures échangées. On vient l'insérer dans la base de données :
        etapesfacade.miseAJCheckBoxDeux(idEtape, valeureBooleene);
        
        for (int i=0; i<lesEtapes.size(); i++)
        {
            System.out.println("Id projet : " + lesEtapes.get(i).getIdEtape() + " pou valeur " + lesEtapes.get(i).isCheckEtape());
       //     if (lesEtapes.get(i).getIdEtape()==idEtape){
       //         System.out.println("Nom de l'étape à changer : " + lesEtapes.get(i).getNomEtape());
       //         System.out.println("Nom de l'étape à changer : " + lesEtapes.get(i).isCheckEtape());
       //         boolean ee7 = valeureBooleene;
                
       //         lesEtapes = etapesfacade.listEtape(idProjet);
       //         System.out.println("Essai modif : " + lesEtapes.get(i).getNomEtape() + " et " + lesEtapes.get(i).isCheckEtape());
       //     }
        }

        return "recapProjet?faces-redirect=true";
    }
    
    
    public void changeCouleurButton(){
        //Ici on va mettre success ou danger
        
        for(int i=0; i<lesEtapes.size(); i++){
            if (lesEtapes.get(i).isCheckEtape()){
                couleur = "success";
            }
            else
            {
                couleur = "danger";
            }
            System.out.println(couleur);
        }
        
    }
    
    

    
    public String SauvegardeNewEtape(){
        //Insertion de l'étape
        etapesfacade.insertNewEtape(ztNomEtape, ztDateDebutEtape, ztDateFinEtape, montantPrevu, dureeJourPrevu, boolNewEtape, idProjet);
        this.verifDejaCoche();
        return "recapProjet?faces-redirect=true";
    }
    
    
    
    public List<Etapes> leNomEtape(){
        
        //lesEtapes.clear();
        
        //setLesEtapes(etapesfacade.listEtape(idProjet));
        lesEtapes = etapesfacade.listEtape(idProjet);
        //System.out.println("Verif de l'idProjet : " + idProjet);
        //for(int i=0; i<lesEtapes.size(); i++){
        //    System.out.println("Nom : " + lesEtapes.get(i).getNomEtape() + " est dans l'état : " + lesEtapes.get(i).isCheckEtape());
        //}
        
        return lesEtapes;
    }
    
    
} //--> Fin de la classe