/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.ChefsProjet;
import model.Consultants;
import model.Projets;

/**
 *
 * @author alexa
 */
@Stateless
public class ProjetsFacade extends AbstractFacade<Projets> {

    @PersistenceContext(unitName = "BusConsultPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProjetsFacade() {
        super(Projets.class);
    }
    
    
    
//Récupération de l'ID du consultant
    public Integer idDuConsultant(String login){
        
        List<Consultants> listPourIdConsultant = new ArrayList<Consultants>();
        
        try
       {
           Query sql = em.createQuery("SELECT c FROM Consultants as c WHERE c.mailConsultant='" + login + "'");
           listPourIdConsultant = sql.getResultList();
           
           int idDuConsultant = listPourIdConsultant.get(0).getIdConsultant();

           return idDuConsultant;

       }catch(NoResultException e){
           return null;
       }
    }
    
//Récupération des projets par utilisateur
    public List<Projets> lesProjetsUser(int idConsultant){
       List<Projets> lesProjets;
     try
       {
           System.out.println("dans sql : " + idConsultant);
           Query sql = em.createQuery("SELECT p FROM Projets as p, ChefsProjet as ch, Consultants as c WHERE p.idProjet=ch.idProjet AND ch.idConsultant=c.idConsultant AND c.idConsultant='" + idConsultant + "'");
           lesProjets = sql.getResultList();
           System.out.println(lesProjets.get(0).getLibelleProjet());
           return (List<Projets>) lesProjets;

       }catch(NoResultException e){
           return null;
       }
   }
    

//Insertion d'un nouveau projet
    public Projets insertNouveauProjet(String nomProjet, Date dateDebut, Date dateFin, int domaine){
        System.out.println("1" + nomProjet);
        System.out.println("2" + dateDebut);
        System.out.println("3" + dateFin);
        System.out.println("4" + domaine);
        Projets listeAjoutNouveauProjet = new Projets();
        try{
            String sql = "INSERT INTO projets(libelleProjet, dateDebutProjet, dateFinProjet, idDomaine) VALUES (?,?,?,?)";
            Query query = em.createNativeQuery(sql);
                query.setParameter(1, nomProjet);
                query.setParameter(2, dateDebut);
                query.setParameter(3, dateFin);
                query.setParameter(4, domaine);
                query.executeUpdate();           
            return listeAjoutNouveauProjet;
        }catch(EJBException e){
            e.printStackTrace();
            return null;
        }
        
    }
    
    
    
    
    
    
    
    
    int idDuConsul=0;

    public int getIdDuConsul() {
        return idDuConsul;
    }

    public void setIdDuConsul(int idDuConsul) {
        this.idDuConsul = idDuConsul;
    }
    
    
    public List<Projets> lesProjetsParChef(int idDuConsul){
        System.out.println("Dans la requete");
        List<Projets> lstProjetsParChef = new ArrayList<Projets>();
        
        try
        {
            System.out.println("re id : " + idDuConsul);
            String sqll = ("SELECT * "
                    + "FROM Projets as p, ChefsProjet as cp, Consultants as c "
                    + "WHERE p.idProjet=cp.idProjet AND cp.idConsultant=c.idConsultant AND c.idConsultant='" + idDuConsul + "'");
            System.out.println("Apres sql1");
            Query query = em.createNativeQuery(sqll);
            System.out.println("Apres sql");
            lstProjetsParChef = query.getResultList();
            System.out.println("Apres result");
            return (List<Projets>) lstProjetsParChef;

        }catch(NoResultException e){
            System.out.println("Sortie");
            return null;
        }
        
    }
    
    public List<Projets> lesProjetsChef(){
       List<Projets> lstProjetsParChef;
     try
       {
           String sql = ("SELECT p FROM Projets as p");
         //  String sql = ("SELECT * "
         //           + "FROM Projets as p, ChefsProjet as cp, Consultants as c "
         //           + "WHERE p.idProjet=cp.idProjet AND cp.idConsultant=c.idConsultant AND c.idConsultant='" + idDuConsul + "'");
            System.out.println("11");
            //String sql = ("SELECT p FROM Projets as p");
           Query query = this.em.createQuery(sql);
           System.out.println("22");
           lstProjetsParChef = query.getResultList();
           System.out.println(lstProjetsParChef.get(0).getLibelleProjet());
           return (List<Projets>) lstProjetsParChef;

       }catch(NoResultException e){
           return null;
       }
   }
    
    
    
    
//Récupération de l'id max des projets
    public int recuperationDernierId(){
        
        List<Projets> recupId = new ArrayList<Projets>();
        int recup = 0;
        
        try
        {
            Query sql = em.createQuery("SELECT p FROM Projets p");
            recupId = sql.getResultList();
            System.out.println("0");
            
            for (int i=0; i<recupId.size(); i++)
            {
                recup = recupId.get(i).getIdProjet();
            }

            return recup;

        }catch(NoResultException e){
            System.out.println("Sortie");
            return 0;
        }
    }
    
}
