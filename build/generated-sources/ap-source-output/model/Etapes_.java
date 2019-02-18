package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-02-04T11:27:55")
@StaticMetamodel(Etapes.class)
public class Etapes_ { 

    public static volatile SingularAttribute<Etapes, Date> dateDebutEtape;
    public static volatile SingularAttribute<Etapes, Date> dateFinEtape;
    public static volatile SingularAttribute<Etapes, Integer> dureeJourPrevu;
    public static volatile SingularAttribute<Etapes, Boolean> checkEtape;
    public static volatile SingularAttribute<Etapes, Integer> idEtape;
    public static volatile SingularAttribute<Etapes, String> nomEtape;
    public static volatile SingularAttribute<Etapes, Double> montantPrevu;
    public static volatile SingularAttribute<Etapes, Integer> idProjet;

}