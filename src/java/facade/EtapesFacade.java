/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Etapes;

/**
 *
 * @author alexa
 */
@Stateless
public class EtapesFacade extends AbstractFacade<Etapes> {

    @PersistenceContext(unitName = "BusConsultPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EtapesFacade() {
        super(Etapes.class);
    }
    
    //Mise à jour de la checkBox 1 :
  /*  public void miseAJCheckBox(Boolean cocheCreationMCD){
        int myInt = cocheCreationMCD ? 1 : 0;
        try{
            
            //--> Mettre le label pour repérer la ligne BDD dans le WHERE
            Query sql = em.createNativeQuery("UPDATE etapes SET checkEtape='" + myInt + "' WHERE idEtape='3'");
            sql.executeUpdate();
        }catch(NullPointerException e){
            System.out.println("Dans le catch");
        }
        
    }*/
    
    public void miseAJCheckBox(String nomEtape, int idProjet, Boolean boolNewEtape){
        System.out.println("Dans requete MAJ");
        int myInt = boolNewEtape ? 1 : 0;
        System.out.println(nomEtape);
        System.out.println(idProjet);
        System.out.println(myInt);
        System.out.println(boolNewEtape);
        try{
            //--> Mettre le label pour repérer la ligne BDD dans le WHERE
            Query sql = em.createNativeQuery("UPDATE etapes SET checkEtape='" + myInt + "' WHERE idProjet='" + idProjet + "' AND nomEtape='" + nomEtape + "'");
            sql.executeUpdate();
        }catch(NullPointerException e){
            System.out.println("Dans le catch");
        }
        
    }
    
    
//Mise à jour de la checkBox 2 :
    public void miseAJCheckBoxDeux(int idEtape, Boolean valeureRecuperee){
        System.out.println("Dans requete MAJ");
        System.out.println(idEtape);
        System.out.println(valeureRecuperee);
        int valeur = valeureRecuperee ? 1 : 0;
        //int myInt = boolNewEtape ? 1 : 0;
        //System.out.println(nomEtape);
        //System.out.println(idProjet);
        //System.out.println(myInt);
        //System.out.println(boolNewEtape);
        try{
            //--> Mettre le label pour repérer la ligne BDD dans le WHERE
            Query sql = em.createNativeQuery("UPDATE etapes SET checkEtape='" + valeur + "' WHERE idEtape='" + idEtape + "'");
            sql.executeUpdate();
        }catch(NullPointerException e){
            System.out.println("Dans le catch");
        }
        
    }
//SQL temporaire --> Remplace findAll Etapes    
    public Long trouverLesTrueEtFalse(int idProjet){
        try
       {
           Query sql = em.createNativeQuery("SELECT COUNT(e.checkEtape) FROM Etapes e WHERE e.checkEtape=true AND e.idProjet='" + idProjet + "'");
           Long nbrVrai = (Long) sql.getSingleResult();
           return nbrVrai;
       }catch(NullPointerException e){
           return null;
       }
    }
//Pour afficher la liste des étapes pour le PDF
    public List<Etapes> lstPourLesPDF(int idProjet){
        List<Etapes> lstPourLesPdf;
        
        try
        {
            Query sql = em.createQuery("SELECT e FROM Etapes as e WHERE e.idProjet='" + idProjet + "'");
            lstPourLesPdf = sql.getResultList();

            return (List<Etapes>) lstPourLesPdf;

        }catch(NoResultException e){
            return null;
        }
        
    }
    
    
    
    public void insertNewEtape(String nom, Date dateD, Date dateF, double montant, int dureeJour, boolean newEtape, int idProjet){
        
        try{
            String sql = "INSERT INTO Etapes (nomEtape, dateDebutEtape, dateFinEtape, montantPrevu, dureeJourPrevu, checkEtape, idProjet) VALUES (?,?,?,?,?,?,?)";
            Query query = em.createNativeQuery(sql);
            query.setParameter(1, nom);
            query.setParameter(2, dateD);
            query.setParameter(3, dateF);
            query.setParameter(4, montant);
            query.setParameter(5, dureeJour);
            query.setParameter(6, newEtape);
            query.setParameter(7, idProjet);
            query.executeUpdate();
        }catch(EJBException e){
            System.out.println("Erreur insertion étape");
            e.printStackTrace();
        }
    }
    
    public List<Etapes> listEtape(int idProjet){
        
        List<Etapes> listDesEtapes = new ArrayList<Etapes>();
        
        try{
            String sql = "SELECT e FROM Etapes as e WHERE e.idProjet='" + idProjet + "'";
            Query query = em.createQuery(sql);
            listDesEtapes = query.getResultList();
            return listDesEtapes;
        }catch(EJBException e){
            System.out.println("Pas de liste");
            e.printStackTrace();
            
            return null;
        }
        
        
    }
    
    
    public Object countNbrEtapes(int idProjet){
        try{
            String sql = "SELECT COUNT(e) as nbr FROM Etapes as e WHERE e.idProjet='" + idProjet + "'";
            Query query = em.createQuery(sql);
            Object nbrEtape = new Object();
            nbrEtape = query.getSingleResult();
            return nbrEtape;
        }catch(EJBException e){
            System.out.println("Pas de liste");
            e.printStackTrace();
            
            return 0;
        }
    }
    
    
    
    
    public List<Etapes> findAllEtapeDuProjet(int idProjet){
        List<Etapes> listRecupEtapes = new ArrayList<Etapes>();
        
        try{
            String sql = "SELECT e FROM Etapes as e WHERE e.idProjet='" + idProjet + "'";
            Query query = em.createQuery(sql);
            listRecupEtapes = query.getResultList();
            return listRecupEtapes;
        }catch(EJBException e){
            System.out.println("Pas de liste");
            e.printStackTrace();
            
            return null;
        }
    }
    
}
