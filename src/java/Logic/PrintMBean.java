/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;


import com.lowagie.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletResponse;
import org.xhtmlrenderer.pdf.ITextRenderer;

/**
 *
 * @author alexa
 */

@ManagedBean (name = "printMBean")
@ApplicationScoped

public class PrintMBean implements Serializable{
    
    private String nomDuProjet;

    public String getNomDuProjet() {
        return nomDuProjet;
    }
    public void setNomDuProjet(String nomDuProjet) {
        this.nomDuProjet = nomDuProjet;
    }
    
    
    
    public PrintMBean(){
    }
    
    //Création du PDF
    public void createPDF() throws MalformedURLException, FileNotFoundException, DocumentException, IOException{
        
        FacesContext facesContext = FacesContext.getCurrentInstance ();
        ExternalContext externalContext=facesContext.getExternalContext();
        String url="http://localhost:8080/BusConsult/print.xhtml";
        
        try{
            ITextRenderer renderer=new ITextRenderer();
            renderer.setDocument(new URL(url).toString());
            renderer.layout();
            HttpServletResponse response=(HttpServletResponse) externalContext.getResponse();
            response.reset();
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=\"Facture " + nomDuProjet + ".pdf\"");
            System.out.println("create 2");
            try (OutputStream outputStream = response.getOutputStream()) {
                renderer.createPDF(outputStream);
                outputStream.flush();
            }
            facesContext.responseComplete();
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Erreur PDF");
        }
        
    }

}
