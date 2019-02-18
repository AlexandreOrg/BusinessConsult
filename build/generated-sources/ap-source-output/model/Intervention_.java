package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-02-04T11:27:55")
@StaticMetamodel(Intervention.class)
public class Intervention_ { 

    public static volatile SingularAttribute<Intervention, Date> dateFinIntervention;
    public static volatile SingularAttribute<Intervention, Integer> idConsultant;
    public static volatile SingularAttribute<Intervention, Integer> dureeHeure;
    public static volatile SingularAttribute<Intervention, Date> dateDebutIntervention;
    public static volatile SingularAttribute<Intervention, Integer> idIntervention;
    public static volatile SingularAttribute<Intervention, Integer> idProjet;

}