/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Scanner;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.servlet.http.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author alexa
 */
@ManagedBean (name="mailgctr")
//@ApplicationScoped
@ViewScoped
public class MailSenderMBean implements Serializable{
    
    private String fromMail;
    private String username;
    private String password;
    private String toMail;
    private String subject;
    private String message;
    public UploadedFile file;
    
    public String getFromMail() {
        return fromMail;
    }
    public void setFromMail(String fromMail) {
        this.fromMail = fromMail;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getToMail() {
        return toMail;
    }
    public void setToMail(String toMail) {
        this.toMail = toMail;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public UploadedFile getFile() {
        return file;
    }
    public void setFile(UploadedFile file) {
        this.file = file;
    }
 
    //Méthode de récupération des informations pour le mail
    public void lancementMail() throws IOException {
        
        
        // Informations SMTP
        String host = "smtp.gmail.com";
        String port = "587";
        String mailFrom = "testEnvoi@businessconsult.com";
        String password = "Wenceslas147$";
        String userName = "alexandre.leuridan@gmail.com";
        System.out.println("Lancement 1");
        
        // Informations pour le message
        String mailTo = "alexandre.leuridan@gmail.com";
        String subject = "New email with attachments";
        String message = "I have some attachments for you.";
        String toAddress = "alexandre.leuridan@gmail.com";
        System.out.println("Lancement 2");
        /*
        this.monFichier();
*/
        System.out.println("Lancement 3");
        // Préparer la pièce jointe
        String[] attachFiles = new String[1];
        attachFiles[0] = "C:\\Users\\alexa\\AppData\\Roaming\\NetBeans\\8.2\\config\\GF_4.1.1\\domain1\\generated\\jsp\\BusConsult\\" + file.getFileName();
        //attachFiles[1] = "C:/wamp64/file.txt";
        //attachFiles[2] = "C:/wamp64/file.txt";
 
        try {
            //Passer les informations nécessaire dans la fonction d'envoi du mail
            this.sendEmailWithAttachments(host, port, userName, password, toAddress, subject, message, attachFiles);
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Could not send email.");
            ex.printStackTrace();
        }
    }
    
    // Méthode pour attacher la pièce jointe au message et envoi
    public void sendEmailWithAttachments(String host, String port, final String userName, final String password, String toAddress, String subject, String message, String[] attachFiles) throws AddressException, MessagingException {

        // Envoi des propriétés SMTP du serveur
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.user", userName);
        properties.put("mail.password", password);
 
        // Création d'une nouvelle session avec authentification
        Authenticator auth = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(properties, auth);
 
        // Création du message du mail :
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(toAddress));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
 
        // creates message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(message, "text/html");
 
        // creates multi-part
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        // Ajouter la pièce jointe
        if (attachFiles != null && attachFiles.length > 0) {
            for (String filePath : attachFiles) {
                MimeBodyPart attachPart = new MimeBodyPart();
 
                try {
                    attachPart.attachFile(filePath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                multipart.addBodyPart(attachPart);
            }
        }
 
        // Envoyer la préparation de la pièce jointe dans le contenu de l'e-mail
        msg.setContent(multipart);

        // Envoi de l'e-mail
        Transport.send(msg);
        
    }
    
    //Méthode qui se déclenche à l'upload du fichier
    public void fileUploadListener(FileUploadEvent e) throws Exception{
        // Préparer le fichier télécharger
        this.file = e.getFile();

        // Ecrire le fichier dans un dossier
        file.write(getFile().getFileName());
    }
    
    

    /*
    private UploadedFile filee;

    public UploadedFile getFilee() {
        return filee;
    }

    public void setFilee(UploadedFile filee) {
        this.filee = filee;

    }
    
    */
    
    
    /*
    File fichierPdf;

    public File getFichierPdf() {
        return fichierPdf;
    }

    public void setFichierPdf(File fichierPdf) {
        this.fichierPdf = fichierPdf;
    }
    
*/
    
    
    
    /*
    
    private UploadedFile uploadedFile; // +getter+setter

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }*/


    /*
    public void validateFile(FacesContext ctx, UIComponent comp, Object value) throws MessagingException, IOException {
        Part file = (Part) value;
        
        System.out.println(file.getSize());
        System.out.println(file.getName());
        if (file.getSize() > 0) {
            System.out.println("Avant upload");
            //this.upload();
            this.lancementMail();
            throw new ValidatorException(new FacesMessage("Ici 1"));
            
        }
        if(!file.getContentType().equals("text/plain")) {
            throw new ValidatorException(new FacesMessage("Ici 2"));
        }
        //this.lancementMail();
    }
    */
    
    
    
    
    
    
    
    
    
    
    
 
    
     
 /*   public void uploadDeux() {
        if(filez != null) {
            FacesMessage message = new FacesMessage("Succesful " + filez.getFileName() + " is uploaded.");
            System.out.println("1 - Succesful " + filez.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            
        }
        else{
            System.out.println("Pas upload");
        }
    }
     
    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Handle Succesful" + event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        String cheminFichier = event.getFile().getFileName();
        System.out.println(cheminFichier);
    }
    */
    
    
    
}
