package co.edu.unicauca.gymadmdoc.entities;

import co.edu.unicauca.gymadmdoc.entities.MruGrupomuscular;
import co.edu.unicauca.gymadmdoc.entities.MruRutina;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-11T09:40:59")
@StaticMetamodel(MruDia.class)
public class MruDia_ { 

    public static volatile SingularAttribute<MruDia, Date> diaTiempomin;
    public static volatile SingularAttribute<MruDia, Integer> diaId;
    public static volatile SingularAttribute<MruDia, String> diaNumero;
    public static volatile SingularAttribute<MruDia, MruRutina> ruId;
    public static volatile CollectionAttribute<MruDia, MruGrupomuscular> mruGrupomuscularCollection;

}