/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Consultants;

/**
 *
 * @author alexa
 */
@Stateless
public class ConsultantFacade extends AbstractFacade<Consultants> {
    
    @PersistenceContext(unitName = "BusConsultPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConsultantFacade() {
        super(Consultants.class);
    }
    
    
/**************************************************
*** INSERTION DE NOS REQUETES SQL PERSONNALISES ***
**************************************************/
    
//Requête de connexion : Trouver le bon utilisateur
    public Consultants findUser(String login, String mdp){
       Consultants consult = new Consultants();
       try
       {
           String sql = "SELECT c FROM Consultants c WHERE c.mailConsultant ='" + login + "' AND c.passConsultant='" + mdp + "'";
           Query query = em.createQuery(sql);
           consult = (Consultants) query.getSingleResult();
           return consult;
       }catch(NoResultException e){
           return null;
       }
   }
    
//Créer un nouvel utilisateur par le bouton "Inscription"
   public Consultants create(String nom, String prenom, String tel, String mail, String pass){
       Consultants newRegister = new Consultants();
       
       try
       {
           Query sql = em.createNativeQuery("INSERT INTO Consultants (nomConsultant, prenomConsultant, telConsultant, mailConsultant, passConsultant) VALUES (?,?,?,?,?)");
            sql.setParameter(1, nom);
            sql.setParameter(2, prenom);
            sql.setParameter(3, tel);
            sql.setParameter(4, mail);
            sql.setParameter(5, pass);
            sql.executeUpdate();
           
           return newRegister;
           //return newRegister;
       }catch(EJBException e){
           return null;
       }
   }

//Editer le profil d'un consultant existant
   public Consultants editerConsultant(String nom, String prenom, String tel, String mail, String pass, int id){
       try
       {
            String sql = "UPDATE Consultants SET nomConsultant='" + nom + "', prenomConsultant='" + prenom + "', telConsultant='" + tel + "', mailConsultant='" + mail + "', passConsultant='" + pass + "' WHERE idConsultant='" + id + "'";
            Query query = em.createNativeQuery(sql);
            query.executeUpdate();
       }catch(EJBException e){
           e.printStackTrace();
       }
       return null;
   }
   
   
   
   
   public List<Consultants> trouverLesChefsProjet(){
        
        List<Consultants> listDesConsultants;
        
        try
        {
            
            Query sql = em.createQuery("SELECT DISTINCT c FROM Consultants as c");
            //Query sql = em.createQuery("SELECT DISTINCT * FROM Consultants as c, ChefsProjet as cp, Projets as p WHERE c.idConsultant=cp.idConsultant AND cp.idProjet=p.idProjet");
           listDesConsultants = sql.getResultList();
           
           return (List<Consultants>) listDesConsultants;

        }catch(NoResultException e){
            System.out.println("Sortie");
            return null;
        }
        
    }
   
}
