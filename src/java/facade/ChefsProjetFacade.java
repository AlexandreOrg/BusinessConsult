/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.ChefsProjet;

/**
 *
 * @author alexa
 */
@Stateless
public class ChefsProjetFacade extends AbstractFacade<ChefsProjet> {
    
    @PersistenceContext(unitName = "BusConsultPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ChefsProjetFacade() {
        super(ChefsProjet.class);
    }
    
    
/**************************************************
*** INSERTION DE NOS REQUETES SQL PERSONNALISES ***
     * @param statut
     * @param idConsultant
     * @param idProjet
**************************************************/
    

//Insertion d'un nouveau chef de projet lors de l'ajout d'un projet
    //public ChefsProjet insertChef(String statut, int idConsultant, int idProjet){
    public void insertChef(String statut, int idConsultant, int idProjet){
        System.out.println("Rentré dans la requête");
        ChefsProjet newEnregistrement = new ChefsProjet();
        System.out.println("new2 " + statut);
        System.out.println("new2 " + idConsultant);
        System.out.println("new2 " + idProjet);
       
        
       
       try
       {
            //String sql = "INSERT INTO chefsProjet (statutChef, idConsultant, idProjet) VALUES (?,?,?)";
            String sql = "INSERT INTO chefsProjet(statutChef, idConsultant, idProjet) VALUES (?,?,?)";
            Query query = em.createQuery(sql);
            query.setParameter(1, statut);
            query.setParameter(2, idConsultant);
            query.setParameter(3, idProjet);
            query.executeUpdate();
           
           //return newEnregistrement;
           //return newRegister;
       }catch(EJBException e){
           //return null;
       }
       
    }
    
    
  
    
   
}
