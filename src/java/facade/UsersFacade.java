/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*package facade;

import java.sql.SQLException;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Users;*/

/**
 *
 * @author alexa
 */

/*@Stateless
public class UsersFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "BusConsultPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
    
    
   public Users findUser(String login, String mdp)
   {
       Users user = new Users();
       try
       {
           Query sql = em.createQuery("SELECT u FROM Users u WHERE u.mailUser ='"+login+"' AND u.mdpUser='"+mdp+"'");
           user = (Users) sql.getSingleResult();
           return user;
       }catch(NoResultException e){
           return null;
       }
   }
   
   
   
//Créer un nouvel utilisateur par le bouton "Inscription"
   public Users create(String nom, String prenom, String mail, String pass)
   {
       Users newRegister = new Users();
       
       try
       {
           Query sql = em.createNativeQuery("INSERT INTO Users (nomUser, prenomUser, mailUser, mdpUser) VALUES (?,?,?,?)");
            sql.setParameter(1, nom);
            sql.setParameter(2, prenom);
            sql.setParameter(3, mail);
            sql.setParameter(4, pass);
            sql.executeUpdate();
           
           return newRegister;
           //return newRegister;
       }catch(EJBException e){
           return null;
       }
   }

   
   
   public Users edition(String nom, String prenom, String mail, String pass, int id){
       
       try
       {
           
           //Users newEdit = new Users();
           
           Query sql = em.createNativeQuery("UPDATE users SET nomUser='" + nom + "', prenomUser='" + prenom + "', mailUser='" + mail + "', mdpUser='" + pass + "' WHERE idUser='" + id + "'");
            sql.executeUpdate();
            
           return null;
           //return newRegister;
       }catch(EJBException e){
           return null;
       }
       
   }
}
*/