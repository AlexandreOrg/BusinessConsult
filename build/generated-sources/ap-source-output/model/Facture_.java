package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-02-04T11:27:55")
@StaticMetamodel(Facture.class)
public class Facture_ { 

    public static volatile SingularAttribute<Facture, Double> montantFacture;
    public static volatile SingularAttribute<Facture, Integer> numeroFacture;
    public static volatile SingularAttribute<Facture, Date> dateFacture;
    public static volatile SingularAttribute<Facture, Integer> idProjet;

}