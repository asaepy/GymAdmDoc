package co.edu.unicauca.gymadmdoc.entities;

import co.edu.unicauca.gymadmdoc.entities.MruDia;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-11T09:40:59")
@StaticMetamodel(MruRutina.class)
public class MruRutina_ { 

    public static volatile SingularAttribute<MruRutina, Date> ruFechaini;
    public static volatile SingularAttribute<MruRutina, Date> ruFechafin;
    public static volatile SingularAttribute<MruRutina, Integer> ruId;
    public static volatile SingularAttribute<MruRutina, Float> ruPeso;
    public static volatile SingularAttribute<MruRutina, Float> ruTalla;
    public static volatile SingularAttribute<MruRutina, String> ruObservaciones;
    public static volatile CollectionAttribute<MruRutina, MruDia> mruDiaCollection;

}