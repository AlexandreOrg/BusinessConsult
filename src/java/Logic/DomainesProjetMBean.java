/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import facade.DomainesProjetFacade;
import facade.ProjetsFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.DomainesProjet;

/**
 *
 * @author alexa
 */

@ManagedBean
@ApplicationScoped
public class DomainesProjetMBean implements Serializable{
    
/**************************
*** LIAISON AVEC LA BDD ***
**************************/
    @EJB
    private DomainesProjetFacade dpf;

    public DomainesProjetFacade getDpf() {
        return dpf;
    }

    public void setDpf(DomainesProjetFacade dpf) {
        this.dpf = dpf;
    }

    
    
    int idDomaine;
    int idDomaineSelect;
    String libelleDomaine;
    List<DomainesProjet> listeDesDomaines = new ArrayList<DomainesProjet>();

    public int getIdDomaineSelect() {
        return idDomaineSelect;
    }

    public void setIdDomaineSelect(int idDomaineSelect) {
        this.idDomaineSelect = idDomaineSelect;
    }

    public List<DomainesProjet> getListeDesDomaines() {
        return listeDesDomaines;
    }

    public void setListeDesDomaines(List<DomainesProjet> listeDesDomaines) {
        this.listeDesDomaines = listeDesDomaines;
    }

    public int getIdDomaine() {
        return idDomaine;
    }

    public void setIdDomaine(int idDomaine) {
        this.idDomaine = idDomaine;
    }

    public String getLibelleDomaine() {
        return libelleDomaine;
    }

    public void setLibelleDomaine(String libelleDomaine) {
        this.libelleDomaine = libelleDomaine;
    }
    
    
//Liste des domaines pour l'ajout d'un projet
    //@PostConstruct
    public List<DomainesProjet> creerListeDomaines(){
       
        
       System.out.println("Dedans");
       
       listeDesDomaines = dpf.findAll();
       
       System.out.println("Id : " + listeDesDomaines.get(0).getIdDomaine() + "   -   Nom : " + listeDesDomaines.get(0).getLibelleDomaine());
       System.out.println("Id : " + listeDesDomaines.get(1).getIdDomaine() + "   -   Nom : " + listeDesDomaines.get(1).getLibelleDomaine());
       return listeDesDomaines;
   }

    /*
    public void trouverDomaine(){
        System.out.println("id select : " + getIdDomaine());
        System.out.println("id select : " + idDomaine);
        System.out.println("id select : " + idDomaineSelect);
        
        idDomaineSelect = getIdDomaine();
        System.out.println("id select : " + getIdDomaine());
        System.out.println("id select : " + idDomaine);
        System.out.println("id select : " + idDomaineSelect);
        
        idDomaineSelect = idDomaine;
        System.out.println("id select : " + getIdDomaine());
        System.out.println("id select : " + idDomaine);
        System.out.println("id select : " + idDomaineSelect);
        
        setIdDomaineSelect(getIdDomaine());
        System.out.println("id select : " + getIdDomaine());
        System.out.println("id select : " + idDomaine);
        System.out.println("id select : " + idDomaineSelect);
        
        setIdDomaineSelect(idDomaine);
        System.out.println("id select : " + getIdDomaine());
        System.out.println("id select : " + idDomaine);
        System.out.println("id select : " + idDomaineSelect);
        
        System.out.println("Id : " + listeDesDomaines.get(0).getIdDomaine() + "   -   Nom : " + listeDesDomaines.get(0).getLibelleDomaine());
        System.out.println("Id : " + listeDesDomaines.get(1).getIdDomaine() + "   -   Nom : " + listeDesDomaines.get(1).getLibelleDomaine());
    }  */


    
}
