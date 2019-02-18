package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-02-04T11:27:55")
@StaticMetamodel(Projets.class)
public class Projets_ { 

    public static volatile SingularAttribute<Projets, Integer> idDomaine;
    public static volatile SingularAttribute<Projets, Date> dateDebutProjet;
    public static volatile SingularAttribute<Projets, String> libelleProjet;
    public static volatile SingularAttribute<Projets, Integer> idProjet;
    public static volatile SingularAttribute<Projets, Date> dateFinProjet;

}