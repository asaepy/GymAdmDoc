package co.edu.unicauca.gymadmdoc.entities;

import co.edu.unicauca.gymadmdoc.entities.GrupomuscRealizaEjercicioPK;
import co.edu.unicauca.gymadmdoc.entities.MruEjercicio;
import co.edu.unicauca.gymadmdoc.entities.MruGrupomuscular;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-11T09:40:59")
@StaticMetamodel(GrupomuscRealizaEjercicio.class)
public class GrupomuscRealizaEjercicio_ { 

    public static volatile SingularAttribute<GrupomuscRealizaEjercicio, Date> greTiempo;
    public static volatile SingularAttribute<GrupomuscRealizaEjercicio, Integer> greRepeticiones;
    public static volatile SingularAttribute<GrupomuscRealizaEjercicio, GrupomuscRealizaEjercicioPK> grupomuscRealizaEjercicioPK;
    public static volatile SingularAttribute<GrupomuscRealizaEjercicio, String> variacionpeso;
    public static volatile SingularAttribute<GrupomuscRealizaEjercicio, MruEjercicio> mruEjercicio;
    public static volatile SingularAttribute<GrupomuscRealizaEjercicio, MruGrupomuscular> mruGrupomuscular;

}